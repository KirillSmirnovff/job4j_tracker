package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class
                .getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenTestFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("first"));
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenTestFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        Item result = tracker.findAll().get(0);
        assertThat(result.getName(), is(first.getName()));
    }

    @Test
    public void whenTestFindByNameCheckArrayLength() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        Item fifth = tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(first.getName());
        assertThat(result.size(), is(3));
        assertThat(result, is(List.of(first, third, fifth)));
    }

    @Test
    public void whenTestFindByNameCheckSecondItemName() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        Item forth = tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        List<Item> result = tracker.findByName(second.getName());
        assertThat(result, is(List.of(second, forth)));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = tracker.add(new Item("Bug"));
        int id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item bug = tracker.add(new Item("Bug"));
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenReplaceMockito() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker(connection);
        Item replacedItem = tracker.add(new Item("Replaced item"));
        int id = replacedItem.getId();
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(id);
        when(input.askStr(any(String.class))).thenReturn(replacedName);
        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ===" + ln + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteMockito() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker(connection);
        Item deleteItem = tracker.add(new Item("Bug"));
        int id = deleteItem.getId();
        DeleteAction del = new DeleteAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(id);
        del.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(tracker.findById(id), is(nullValue()));
        assertThat(out.toString(), is("=== Delete item ===="
                + ln + "Заявка удалена успешно." + ln));
    }

    @Test
    public void whenFindByIdMockito() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker(connection);
        Item findItem = tracker.add(new Item("Find me"));
        int id = findItem.getId();
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(id);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(tracker.findById(id), is(findItem));
        assertThat(out.toString(), is("=== Find item by id ===" + ln + findItem + ln));
    }

    @Test
    public void whenFindByNameMockito() {
        Output out = new StubOutput();
        SqlTracker tracker = new SqlTracker(connection);
        Item findItem = tracker.add(new Item("Find me"));
        String name = findItem.getName();
        FindByNameAction find = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(name);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(tracker.findByName(name), is(List.of(findItem)));
        assertThat(out.toString(), is("=== Find items by name ===" + ln + findItem + ln));
    }
}
