package com.playtika;
import java.util.Arrays;

public class Result {
    public static void main(String[] args) {
        int[] a = {341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299, 343, 317, 265};
        String[] b = {"Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron", "Kate"};
        boolean isSorted = false;
        int intBuffer;
        String stringBufffer;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length-1; i++) {
                if(a[i] > a[i+1]){
                    isSorted = false;
                    intBuffer = a[i];
                    a[i] = a[i+1];
                    a[i+1] = intBuffer;
                    stringBufffer = b[i];
                    b[i] = b[i+1];
                    b[i+1] = stringBufffer;
                }
            }
        }

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}