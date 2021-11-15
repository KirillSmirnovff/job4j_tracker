package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-2, -4, 0, 2, 4));
        List<Integer> result = list.stream().filter(value -> value >= 0)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
