package com.playtika;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayAndLinkedLists {
    static final Random RANDOM = new Random();
    static final int amountOfIteration = 1000;

    public static void main(String[] args) {

        List<Integer> createdArrayList = new ArrayList<>();
        List<Integer> createdLinkedList = new LinkedList<>();

        long deltaForArrayListCreate = addRandomtoCreatedListMeasure(createdArrayList);
        System.out.println("Time delta for created ArrayList: " + deltaForArrayListCreate);

        long deltaForLinkedListCreate = addRandomtoCreatedListMeasure(createdLinkedList);
        System.out.println("Time delta for created LinkedList: " + deltaForLinkedListCreate);

        long deltaForDeleteItemsArrayList = measureForDeletedElements(createdArrayList);
        System.out.println("Time delta for created ArrayList: " + deltaForDeleteItemsArrayList);

        long deltaForDeleteitemsLinkedList = measureForDeletedElements(createdLinkedList);
        System.out.println("Time delta for delete 1000 elements from LinkedList:" + deltaForDeleteitemsLinkedList);

        long deltaForFoundedItemsArrayList = measureForFoundedValues(createdArrayList);
        System.out.println("Time delta for count 1000 elements from ArrayList: " + deltaForFoundedItemsArrayList);

        long deltaForFoundedElementsLinkedList = measureForFoundedValues(createdLinkedList);
        System.out.println("Time delta for count 1000 elements from LinkedList: " + deltaForFoundedElementsLinkedList);
    }

    private static void addRandomToCreatedList(List<Integer> integers) {
        for (int i = 0; i < 1000000; i++) {
            int a = RANDOM.nextInt(amountOfIteration);
            integers.add(a);
        }
    }

    private static long addRandomtoCreatedListMeasure(List<Integer> integers) {
        long startTime = System.nanoTime();
        addRandomToCreatedList(integers);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    private static void deleteElementsFormSelectedList(List<Integer> integers) {

        for (int i = 0; i < amountOfIteration; i++) {
            integers.remove(i);
        }
    }

    private static long measureForDeletedElements(List<Integer> integers) {
        long startTime = System.nanoTime();
        deleteElementsFormSelectedList(integers);
        long endTime = System.nanoTime();
        return (endTime - startTime);

    }

    private static void foundByElement(List<Integer> integers) {


        for (int i = 0; i < amountOfIteration; i++) {
            integers.contains(i);
        }
    }

    private static long measureForFoundedValues(List<Integer> integers) {
        long startTime = System.nanoTime();
        foundByElement(integers);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }
}