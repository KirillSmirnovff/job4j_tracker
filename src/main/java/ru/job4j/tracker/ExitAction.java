package ru.job4j.tracker;

public class ExitAction implements UserAction {
    private Output out;

    public ExitAction(Output out) {
        this.out = out;
    }

    public ExitAction() {
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Exit Program ===");
        return false;
    }
}
