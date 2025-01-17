package ru.job4j.tracker;

import java.util.List;

public class StartUI {
    private Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public StartUI() {
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select:");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput(
                new ConsoleInput()
        );
        Output output = new ConsoleOutput();
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
               new CreateAction(output),
               new ReplaceAction(output),
               new DeleteAction(output),
               new FindAllAction(output),
               new FindByIdAction(output),
               new FindByNameAction(output),
               new ExitAction(output),
               new CreateTenAction(output),
               new DeleteTenAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
    }
}