package playtika;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String HELMET_DELETE = "Helmet.*?}(\n|, )";
    static final String CORRECT_ELEMENTS_AMOUNT = "All his ammunition.*?\n";
    static final String REPLACE_EQUAL_SIGN = "\\=";

    public static void main(String[] args) throws UserWrongPriceAmountException, WrongPriceTypeException, IOException {

        Armor firstSuite = buildArmor();
        Knight firstKnight = new Knight(5, "Arthur", firstSuite, "soldier");
        CostRange costRange = collectUserInput();
        String knightInfo = buildKnightInfo(firstKnight, firstSuite);

        String userInputResult = buildSortedByUserInputResult(costRange, firstSuite);

        String sortedByCost = buildSortedByCostArmor(firstSuite);
        writeToFile(userInputResult, "UserInputResult.txt");
        writeToFile(firstKnight, "Knight.txt");
        writeToFile(sortedByCost, "SortedByCostKnight.txt");


        try {
            System.out.println(readKnightInfoFromTxtFile("Knight.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String knightWithOutHelmet = changeInKnightInfoViaRegex(knightInfo);
        System.out.println("Knight with out Helmet: " + knightWithOutHelmet);
    }

    public static Armor buildArmor() {
        List<ArmorItem> armorList = Arrays.asList(
                ArmorFactory.buildArmorItem(ItemsType.BOOT, 25, 50, "black"),
                ArmorFactory.buildArmorItem(ItemsType.CUIRASS, 55, 100, "gold"),
                ArmorFactory.buildArmorItem(ItemsType.HELMET, 35, 55, "gold"),
                ArmorFactory.buildArmorItem(ItemsType.SHIELD, 115, 125, "red"),
                ArmorFactory.buildArmorItem(ItemsType.SWORD, 125, 155, "silver")
        );
        return new Armor(armorList);
    }

    private static CostRange collectUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Here is a created knight!Fill in  Maximum and Minimum cost's value to find the corresponding ammunition! ");

        try {
            int minCost = in.nextInt();
            int maxCost = in.nextInt();
            if (minCost > maxCost) {
                throw new UserWrongPriceAmountException("Fill in correct price! minCost should be greater than maxCost!");
            } else {
                return new CostRange(minCost, maxCost);
            }
        } catch (InputMismatchException e) {
            throw new WrongPriceTypeException("Please, fill in number!");
        } finally {
            in.close();
        }
    }

    private static String buildSortedByUserInputResult(CostRange costRange, Armor firstSuite) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ArmorItem> listSelectedByCost = firstSuite.getByCost(costRange.getMinCost(), costRange.getMaxCost());
        stringBuilder.append("Ammunition which falling in the sample!").append(System.lineSeparator());
        for (ArmorItem armorItem : listSelectedByCost) {
            stringBuilder.append(armorItem);
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static String buildKnightInfo(Knight firstKnight, Armor firstSuite) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstKnight).append(System.lineSeparator());
        stringBuilder.append("All his ammunition costs:").append(firstSuite.getCost()).append(System.lineSeparator());
        stringBuilder.append("All his ammunition weight:").append(firstSuite.getWeight()).append(System.lineSeparator());
        return stringBuilder.toString();
    }

    private static String buildSortedByCostArmor(Armor firstSuite) {
        StringBuilder stringBuilder = new StringBuilder();
        List<ArmorItem> sorted = firstSuite.sortedByCost();
        stringBuilder.append("His ammunition sorted by cost in incremental order:").append(System.lineSeparator());
        for (ArmorItem armorItem : sorted) {
            stringBuilder.append(armorItem);
        }
        return stringBuilder.toString();
    }

    public static void writeToFile(Object text, String fileName)  {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(text);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write to out file", e);
        }
    }

    public static Knight readKnightInfoFromTxtFile(String filename) throws ClassNotFoundException, IOException {

        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (Knight) objectInputStream.readObject();
    }

    private static String changeInKnightInfoViaRegex(Object text) {
        String knightInfo = text.toString();
        knightInfo = knightInfo.replaceAll(HELMET_DELETE, "");
        knightInfo = knightInfo.replaceAll(CORRECT_ELEMENTS_AMOUNT, "");
        knightInfo = knightInfo.replaceAll(REPLACE_EQUAL_SIGN, " equals ");
        return knightInfo;
    }
}