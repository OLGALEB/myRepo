package com.playtika.task1.lecture3;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Armor firstSuite = ArmorFactory.buildArmor("black","gold","white");
        Knight firstKnight = new Knight(4, "Arthur", firstSuite, "soldier");

        CostRange costRange = collectUserInput();
        String userInputResult, knightInfo, sortedByCost;
        try {
            userInputResult = buildSortedByUserInputResult(costRange, firstSuite);
            knightInfo = buildKnightInfo(firstKnight, firstSuite);
            sortedByCost = buildSortedBysCostArmor(firstSuite);

        } catch (WrongMinPriceException e) {
            throw e;
        }
        writeToFile(userInputResult, false);
        writeToFile(knightInfo, true);
        writeToFile(sortedByCost, true);

        String textFromFile = readFromFile();
        System.out.println(textFromFile); //read from file

        String a = textFromFile.replaceAll("Helmet.*?}(\n|, )", ""); // Task3
        a = a.replaceAll("All his ammunition.*?\n", "");
        a  = a.replaceAll("\\=", " equals ");
        System.out.println(a);
    }

    private static CostRange collectUserInput() {

        Scanner in = new Scanner(System.in);
        System.out.println("Here is a created knight!Fill in  Maximum and Minimum cost's value to find the corresponding ammunition! ");
        try {
            return getCostRange(in);
        } catch (UserWrongInputException e) {
            throw e;
        }
    }

    private static CostRange getCostRange(Scanner in) throws UserWrongInputException {
        try {
            int minCost = in.nextInt();
            int maxCost = in.nextInt();
            CostRange costRange = new CostRange(minCost, maxCost);
            System.out.println();
            in.close();
            return costRange;
        } catch (InputMismatchException e) {
            throw new UserWrongInputException("Please, fill in number!");
        }
    }

    private static String buildSortedByUserInputResult(CostRange costRange, Armor firstSuite) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ArmorItem> listSelectedByCost = firstSuite.getByCost(costRange.getMinCost(), costRange.getMaxCost());
        if (firstSuite.getByMinCost(costRange.getMinCost()).size() == 0) {
            throw new WrongMinPriceException("MinPrice is too high!");
        }
        if (firstSuite.getByMaxCost(costRange.getMaxCost()).size() == 0) {
            throw new WrongMaxPriceException("MaxPrice is too low!");
        }
        stringBuilder.append("Ammunition which falling in the sample! \n");
        for (ArmorItem armorItem : listSelectedByCost) {
            stringBuilder.append(armorItem);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static String buildKnightInfo(Knight firstKnight, Armor firstSuite) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There is our knight:" + firstKnight + "\n");
        stringBuilder.append("All his ammunition costs:" + firstSuite.getCost() + "\n");
        stringBuilder.append("All his ammunition weight:" + firstSuite.getWeight() + "\n");
        return stringBuilder.toString();
    }

    private static String buildSortedBysCostArmor(Armor firstSuite) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ArmorItem> sorted = firstSuite.sortedByCost();
        stringBuilder.append("His ammunition sorted by cost in incremental order: \n");
        for (ArmorItem armorItem : sorted) {
            stringBuilder.append(armorItem + "\n");
        }
        return stringBuilder.toString();
    }

    private static void writeToFile(String text, boolean append) {
        try (OutputStream writer = new FileOutputStream("Knight.txt", append)) {

            writer.write(text.getBytes());
            writer.flush();
        } catch (IOException ex) { // if some problems with Knight.txt

            System.out.println(ex.getMessage());
        }
    }

    private static String readFromFile() {
        InputStream reader;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            reader = new FileInputStream("Knight.txt");
            Scanner sc = new Scanner(reader);
            while (sc.hasNextLine()) {
                stringBuilder.append(sc.nextLine() + "\n");
            }
            reader.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return stringBuilder.toString();
    }
}