package ru.job4j.tracker;

public class FindByNamesAction implements UserAction {
    private final Output out;

    public FindByNamesAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by names";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявка с именем: " + name + " не найдена.");
        }
        return true;
    }
}
