package com.playtika;
import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size :");
        String userInput = in.nextLine();
        int sideSize = Integer.parseInt(userInput); //convert string to int or user will see exception after some number was entered
        System.out.println();

        int shiftedSize = sideSize - 1;
        int side = sideSize * 2 - 1;
        for (int i = 0; i < sideSize; i++) {
            for (int j = 0; j < side; j++) {
                if (j == shiftedSize-i || j == shiftedSize+i) {
                    System.out.print("*");
                } else  {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < shiftedSize; i++) {
            for (int j = 0; j < side; j++) {
                if (j == shiftedSize-(shiftedSize -1 - i) || j == shiftedSize+(shiftedSize -1 - i)) {
                    System.out.print("*");
                } else  {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}

