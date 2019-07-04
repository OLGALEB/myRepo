package com.playtika;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Armor knightSuite = buildArmor();
        Armor firstSuite = buildArmor();
        Knight firstKnight = new Knight(4, "Arthur", knightSuite, "soldier");

        CostRange costRange = collectUserInput();
        printSortedByUserInputResult(costRange, knightSuite);
        printKnightInfo(firstKnight, firstSuite);
        printSortedByCostArmor(firstSuite);
    }

    private static Armor buildArmor() {
        List<ArmorItem> armorList = Arrays.asList(
                new Helmet("black", HelmType.CLOSED, 5, 10, 15),
                new Cuirass("gold", 15, 25, 35),
                new Boot("black", 20, 30, 21),
                new Boot("black", 20, 30, 21),
                new Sword("gold", 15, 10, 15, 25),
                new Shield("gold", 27, 31, 19)
        );
        return new Armor(armorList);
    }

    private static CostRange collectUserInput() {

        Scanner in = new Scanner(System.in);
        System.out.println("Here is a created knight!Fill in  Maximum and Minimum cost's value to find the corresponding ammunition! ");
        int minCost = in.nextInt();
        int maxCost = in.nextInt();
        CostRange costRange = new CostRange(minCost, maxCost);
        System.out.println();
        in.close();
        return costRange;
    }

    private static void printSortedByUserInputResult(CostRange costRange, Armor firstSuite) {

        List<ArmorItem> listSelectedByCost = firstSuite.getByCost(costRange.getMinCost(), costRange.getMaxCost());
        System.out.println("Ammunition which falling in the sample:");
        for (ArmorItem armorItem : listSelectedByCost) {
            System.out.println(armorItem);
        }
    }

    private static void printKnightInfo(Knight firstKnight, Armor firstSuite) {
        System.out.println("There is our knight:" + firstKnight);
        System.out.println("All his ammunition costs:" + firstSuite.getCost());
        System.out.println("All his ammunition weight:" + firstSuite.getWeight());
    }

    private static void printSortedByCostArmor(Armor firstSuite) {

        List<ArmorItem> sorted = firstSuite.sortedByCost();
        System.out.println("His ammunition sorted by cost in incremental order: ");
        for (ArmorItem armorItem : sorted) {
            System.out.println(armorItem);
        }
    }
}