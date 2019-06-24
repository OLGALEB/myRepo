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





    /* Armor secondSuite = new Armor(
                new Helmet("black", "OpenedHelmet", 3, 9, 20),
                new Cuirass("red", 21, 29, 37),
                new Boot("silver", 23, 31, 25),
                new Boot("silver", 17, 33, 27),
                new Sword("red", 19, 17, 17, 27),
                new Shield("silver", 25, 23, 21)
        );
        System.out.println("secondSuite.getCost() = " + secondSuite.getCost());
        System.out.println("secondSuite.getWeight() = " + secondSuite.getWeight());
        List<Item> byCost = secondSuite.getByCost(17, 29);
        for (Item item : byCost) {
            System.out.println("item = " + item);
        }

        Armor thirdSuite = new Armor(
                new Helmet("green", "ClosedHelmet", 7, 11, 15),
                new Cuirass("silver", 17, 27, 37),
                new Boot("red", 21, 33, 23),
                new Boot("gold", 21, 33, 25),
                new Sword("red", 17, 11, 17, 27),
                new Shield("red", 25, 25, 21)
        );
        System.out.println("thirdSuite.getCost() = " + thirdSuite.getCost());
        System.out.println("thirdSuite.getWeight() = " + thirdSuite.getWeight());

        List<Item> sorted = thirdSuite.sorterByCost();
        for (Item item : sorted) {
            System.out.println("item = " + item);
        }*/



