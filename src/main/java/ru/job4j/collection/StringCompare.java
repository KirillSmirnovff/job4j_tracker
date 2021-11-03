package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int leftSize = left.length();
        int rightSize = right.length();
        int letters = Math.min(leftSize, rightSize);
        for (int letter = 0; letter < letters; letter++) {
            result = Character.compare(left.charAt(letter), right.charAt(letter));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(leftSize, rightSize);
    }
}