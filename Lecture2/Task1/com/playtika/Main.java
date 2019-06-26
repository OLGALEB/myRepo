package com.playtika;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Armor knightSuite = buildArmor();

        Knight firstKnight = new Knight(4, "Arthur", knightSuite, "soldier");

        UserInput userInput = collectUserInpt();
        printResult(userInput, knightSuite, firstKnight);
    }


    private static Armor buildArmor() {
        List<ArmorItem> armorList = Arrays.asList( //enter args > ArrayList
                new Helmet("black", HelmType.CLOSED, 5, 10, 15),
                new Cuirass("gold", 15, 25, 35),
                new Boot("black", 20, 30, 21),
                new Boot("black", 20, 30, 21),
                new Sword("gold", 15, 10, 15, 25),
                new Shield("gold", 27, 31, 19)
        );
        return new Armor(armorList);
    }

    private static UserInput collectUserInpt() {
        UserInput userInput = new UserInput();
        Scanner in = new Scanner(System.in);
        System.out.println("Here is a created knight!Fill in  Maximum and Minimum cost's value to find the corresponding ammunition! ");
        int minCost = in.nextInt();//reads entered Int
        int maxCost = in.nextInt();
        System.out.println();
        userInput.maxCost = maxCost;
        userInput.minCost = minCost;
        in.close();
        return userInput;
    }

    private static void printResult(UserInput userInput, Armor firstSuite, Knight firstKnight) {
        int minIndex = 10;
        if (userInput.minCost < minIndex) {

            System.out.println("Can not to perform the action - the entered sum does not correspond the condition!Min value should be more or equal to 10!");
        } else {
            List<ArmorItem> byCost = firstSuite.getByCost(userInput.minCost, userInput.maxCost);
            System.out.println("Ammunition which falling in the sample:");
            for (ArmorItem armorItem : byCost) {
                System.out.println(armorItem);
            }

            System.out.println("There is our knight:" + firstKnight);
            System.out.println("All his ammunition costs:" + firstSuite.getCost());
            System.out.println("All his ammunition weight:" + firstSuite.getWeight());
            List<ArmorItem> sorted = firstSuite.sortedByCost();
            System.out.println("His ammunition sorted by cost in incremental order: ");
            for (ArmorItem armorItem : sorted) {
                System.out.println(armorItem);
            }
        }

    }
 }









