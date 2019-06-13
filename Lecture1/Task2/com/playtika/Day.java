package com.playtika;
import java.util.Scanner;

public class Day {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of the day :");
        String s = in.nextLine();
        int result = Integer.parseInt(s);
        System.out.println();
        String monthString;
        switch (result) {
            case 1:  monthString = "Monday";
                break;
            case 2:  monthString = "Tuesday";
                break;
            case 3:  monthString = "Wednesday";
                break;
            case 4:  monthString = "Thursday";
                break;
            case 5:  monthString = "Friday";
                break;
            case 6:  monthString = "Saturday";
                break;
            case 7:  monthString = "Sunday";
                break;
            default: monthString = "Does not exist";
                break;
        }
        System.out.println(monthString);
    }
}
