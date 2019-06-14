package com.playtika;
import java.util.Scanner;
import java.util.Arrays;

public class Phrase {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter something: ");
        String input = in.nextLine();

        System.out.println("Reverse: " + new StringBuilder(input).reverse().toString()); //task 1.1

        String[] words = input.split(" ");
        System.out.println ("Split:");
        for (String word : words) {
            System.out.println(word); // task 1.2
        }
        System.out.println("Change: " + input.replace(' ', '*'));// task 1.3
        String strUpper = input.toUpperCase();
        System.out.println ("Upper case: " +strUpper);// task 1.4
        int maxIndex = 10;
        if (input.length () < maxIndex) {
            System.out.println("Can not to perform the action - the entered character does not correspond the condition!");
            return;
        }
        System.out.print("Substring: ");
        System.out.println(input.substring(5, maxIndex)); // task 1.5
            }
     }