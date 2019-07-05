package com.playtika;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayAndLinkedLists {
    static final Random RANDOM = new Random();
    static final int MAX_VALUE = 1000000;
    static final int AMOUNT_OF_ITERATIONS = 1000;

    public static void main(String[] args) {

        List<Integer> createdArrayList = new ArrayList<>();
        List<Integer> createdLinkedList = new LinkedList<>();

        long deltaForArrayListCreate = addRandomtoCreatedListMeasure(createdArrayList, MAX_VALUE, AMOUNT_OF_ITERATIONS);
        System.out.println("Time delta for created ArrayList: " + deltaForArrayListCreate);

        long deltaForLinkedListCreate = addRandomtoCreatedListMeasure(createdLinkedList, MAX_VALUE, AMOUNT_OF_ITERATIONS);
        System.out.println("Time delta for created LinkedList: " + deltaForLinkedListCreate);

        long deltaForDeleteItemsArrayList = measureForDeletedElements(createdArrayList, AMOUNT_OF_ITERATIONS);
        System.out.println("Time delta for created ArrayList: " + deltaForDeleteItemsArrayList);

        long deltaForDeleteitemsLinkedList = measureForDeletedElements(createdLinkedList, AMOUNT_OF_ITERATIONS);
        System.out.println("Time delta for delete 1000 elements from LinkedList:" + deltaForDeleteitemsLinkedList);

        long deltaForFoundedItemsArrayList = measureForFoundedValues(createdArrayList, AMOUNT_OF_ITERATIONS);
        System.out.println("Time delta for count 1000 elements from ArrayList: " + deltaForFoundedItemsArrayList);

        long deltaForFoundedElementsLinkedList = measureForFoundedValues(createdLinkedList, AMOUNT_OF_ITERATIONS);
        System.out.println("Time delta for count 1000 elements from LinkedList: " + deltaForFoundedElementsLinkedList);
    }

    private static void addRandomToCreatedList(List<Integer> integers, int maxValue, int amountOfIterations) {
        for (int i = 0; i < maxValue; i++) {
            int a = RANDOM.nextInt(amountOfIterations);
            integers.add(a);
        }
    }

    private static long addRandomtoCreatedListMeasure(List<Integer> integers, int maxValue, int amountOfIterations) {
        long startTime = System.nanoTime();
        addRandomToCreatedList(integers, MAX_VALUE, AMOUNT_OF_ITERATIONS);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    private static void deleteElementsFormSelectedList(List<Integer> integers, int amountOfIterations) {

        for (int i = 0; i < amountOfIterations; i++) {
            integers.remove(i);
        }
    }

    private static long measureForDeletedElements(List<Integer> integers, int amountOfIterations) {
        long startTime = System.nanoTime();
        deleteElementsFormSelectedList(integers, amountOfIterations);
        long endTime = System.nanoTime();
        return (endTime - startTime);

    }

    private static void foundByElement(List<Integer> integers, int amountOfIterations) {

        for (int i = 0; i < amountOfIterations; i++) {
            integers.contains(i);
        }
    }


    private static long measureForFoundedValues(List<Integer> integers, int amountOfIterations) {
        long startTime = System.nanoTime();
        foundByElement(integers, amountOfIterations);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }
}