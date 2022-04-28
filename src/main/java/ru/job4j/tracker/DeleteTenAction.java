package ru.job4j.tracker;

public class DeleteTenAction implements UserAction {
    private final Output out;

    public DeleteTenAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete 10 fixed items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        for (int i = id; i < 1000 + id; i++) {
            tracker.delete(i);
        }
        out.println("10 items deleted");
        return true;
    }
}
