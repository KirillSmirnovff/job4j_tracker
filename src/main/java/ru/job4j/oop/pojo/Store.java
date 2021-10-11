package ru.job4j.oop.pojo;

public class Store {
    public static void main(String[] args) {
        Product milk = new Product("Milk", 10);
        Product bread = new Product("Bread", 4);
        Product egg = new Product("Egg", 19);
        Product[] prods = new Product[3];
        prods[0] = milk;
        prods[1] = bread;
        prods[2] = egg;
        for (Product  prod: prods) {
            System.out.println(prod.getName() + " - " + prod.getCount());
        }
        System.out.println("Replace milk to oil.");
        Product oil = new Product("Oil", 11);
        prods[0] = oil;
        for (Product prod : prods) {
            if (prod.getCount() > 10) {
                System.out.println(prod.getName() + " - " + prod.getCount());
            }
        }
    }
}
