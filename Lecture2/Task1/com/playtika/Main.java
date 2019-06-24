package com.playtika;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        Armor firstSuite = new Armor(
                new Helmet("black", "ClosedHelmet", 5, 10, 15),
                new Cuirass("gold", 15, 25, 35),
                new Boot("black", 20, 30, 21),
                new Boot("black", 20, 30, 21),
                new Sword("gold", 15, 10, 15, 25),
                new Shield("gold", 27, 31, 19)
        );


        Knight firstKnight = new Knight(4, "Arthur", firstSuite, "soldier");


        Scanner in = new Scanner(System.in);
        System.out.println("Here is a created knight!Fill in  Maximum and Minimum cost's value to find the corresponding ammunition! ");
        int minCost = in.nextInt();//reads entered Int
        int maxCost = in.nextInt();
        System.out.println();
        int minIndex = 10;
        if (minCost < minIndex) {

            System.out.println("Can not to perform the action - the entered sum does not correspond the condition!Min value should be more or equal to 10!");
            return;
        }


        List<Item> byCost = firstSuite.getByCost(minCost, maxCost);
        System.out.println("Ammunition which falling in the sample:");
        for (Item item : byCost) {
            System.out.println(item);
        }

        System.out.println("There is our knight:" + firstKnight);
        System.out.println("All his ammunition costs:" + firstSuite.getCost());
        System.out.println("All his ammunition weight:" + firstSuite.getWeight());
        List<Item> sorted = firstSuite.sorterByCost();
        System.out.println("His ammunition sorted by cost in incremental order: ");
        for (Item item : sorted) {
            System.out.println(item);
        }

    }
}








