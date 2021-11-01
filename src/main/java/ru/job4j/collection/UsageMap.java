package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("smirnovk.1990@gmail.com", "Smirnov Kirill Maksimovich");
        for (String key : map.keySet()) {
            System.out.printf("%s: %s%n", key, map.get(key));
        }
    }
}
