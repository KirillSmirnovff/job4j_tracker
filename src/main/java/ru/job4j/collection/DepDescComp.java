package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/", 2);
        String[] o2Array = o2.split("/", 2);
        int result = o2Array[0].compareTo(o1Array[0]);
        if (result == 0) {
            if (Math.min(o1Array.length, o2Array.length) > 1) {
                return o1Array[1].compareTo(o2Array[1]);
            }
            return Integer.compare(o1Array.length, o2Array.length);
        }
        return result;
    }
}