package ru.job4j.oop.pojo;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Обломов", 200);
        Book second = new Book("Война и мир", 1500);
        Book third = new Book("Clean code", 500);
        Book fourth = new Book("Rhythm of war", 1300);
        Book[] books = new Book[4];
        books[0] = first;
        books[1] = second;
        books[2] = third;
        books[3] = fourth;
        for (Book book : books) {
            System.out.println(book.getName() + " - "
                    + book.getPageCount() + " страниц");
        }
        System.out.println("Меняем местами 1 и 4 книгу");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " - "
                    + book.getPageCount() + " страниц");
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " - "
                        + book.getPageCount() + " страниц");
            }
        }
    }
}
