package com.playtika;

import java.util.Arrays;

public class Result {
    public static void main(String[] args) {
        int[] results = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        boolean isSorted = false;
        int resultsBuffer;
        String namesBufffer;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < results.length - 1; i++) {
                if (results[i] > results[i + 1]) {
                    isSorted = false;
                    resultsBuffer = results[i];
                    results[i] = results[i + 1];
                    results[i + 1] = resultsBuffer;
                    namesBufffer = names[i];
                    names[i] = names[i + 1];
                    names[i + 1] = namesBufffer;
                }
            }
        }

        System.out.println(Arrays.toString(results));
        System.out.println(Arrays.toString(names));
    }
}