package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenDuplicateThenFalse() {
        Citizen first = new Citizen("2f44a", "Petr Arsentev");
        Citizen second = new Citizen("2f44a", "Pavel Afanasyev");
        PassportOffice office = new PassportOffice();
        office.add(first);
        assertFalse(office.add(second));
    }

    @Test
    public void whenNotFoundThenNull() {
        Citizen first = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(first);
        assertNull(office.get("2f4aa"));
    }

}