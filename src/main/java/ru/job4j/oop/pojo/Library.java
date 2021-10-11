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
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - "
                    + books[i].getPageCount() + " страниц");
        }
        System.out.println("Меняем местами 1 и 4 книгу");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - "
                    + books[i].getPageCount() + " страниц");
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println(books[i].getName() + " - "
                        + books[i].getPageCount() + " страниц");
                break;
            }
        }
    }
}
