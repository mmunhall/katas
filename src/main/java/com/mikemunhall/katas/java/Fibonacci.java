package com.mikemunhall.katas.java;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    // 1, 2, 3, 5, 8, 13, 21, 34 ...
    public static List<Integer> getResult(int max) {
        List<Integer> acc = new ArrayList<>();
        Integer current = 0;

        while (current < max) {
            // [] or [1]
            if (acc.size() <= 1) {
                acc.add(1);
                current++;
                continue;
            }

            // [1, 1, ...]
            acc.add(acc.get(acc.size() - 1) + acc.get(acc.size() - 2));
            current++;
            continue;
        }

        return acc;
    }
}
