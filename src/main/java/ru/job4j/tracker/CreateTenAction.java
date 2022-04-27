package ru.job4j.tracker;

public class CreateTenAction implements UserAction {
    private final Output out;

    public CreateTenAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add 10 fixed items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        for (int i = 0; i < 1000; i++) {
            tracker.add(new Item("name" + i));
        }
        out.println("10 items added");
        return true;
    }
}

