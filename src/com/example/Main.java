package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> a = randomList(0, 100, 5);
        List<Integer> b = randomList(0, 100, 5);

        System.out.println("Before merge first array: " + a);
        System.out.println("Before merge second array: " + b);

        merge(a, b);

        System.out.println("After merge first array: " + a);
        System.out.println("After merge second array: " + b);

    }

    public static void merge(List<Integer> a, List<Integer> b) {
        int size = a.size() + b.size();
        List<Integer> integers = new ArrayList<>(a.size());
        integers.addAll(a);
        a.clear();

        int indexA = 0, indexB = 0;

        for (int i = 0; i < size; i++) {
            if (indexA >= integers.size()) {
                a.add(b.get(indexB++));
            } else if (indexB >= b.size()) {
                a.add(integers.get(indexA++));
            } else if (integers.get(indexA) <= b.get(indexB)) {
                a.add(integers.get(indexA++));
            } else {
                a.add(b.get(indexB++));
            }
        }
    }

    public static List<Integer> randomList(int min, int max, int count) {
        return new Random()
            .ints(min, max + 1)
            .limit(count)
            .sorted()
            .boxed()
            .collect(Collectors.toList());
    }
}
