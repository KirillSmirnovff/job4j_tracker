package ru.job4j.oop;

public class Error {

    private boolean active;

    private String message;

    private int status;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println("Статус: " + active);
        System.out.println("ID ошибки: " + status);
        System.out.println("Текст ошибки: " + message);
    }

    public static void main(String[] args) {
        Error firstError = new Error();
        Error secondError = new Error(true, 1033, "Copy file interrupted, not enough space");
        Error thirdError = new Error(true, 228, "Not enough cash");
        firstError.showInfo();
        secondError.showInfo();
        thirdError.showInfo();
    }
}
