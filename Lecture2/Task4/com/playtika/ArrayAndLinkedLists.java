package com.playtika;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayAndLinkedLists {
    static final Random RANDOM = new Random();

    public static void main(String[] args) {


        List<Integer> createdArrayList = new ArrayList<>();
        List<Integer> createdLinkedList = new LinkedList<>();

        long deltaForArrayListCreate = addRandomtoCreatedArrayListMeasure(createdArrayList);
        System.out.println("Time delta for created ArrayList: " + deltaForArrayListCreate);

        long deltaForLinkedListCreate = addRandomCreatedLinkedListMeasure(createdLinkedList);
        System.out.println("Time delta for created LinkedList: " + deltaForLinkedListCreate);

        long deltaForDeleteItemsArrayList = measureForDeletedElementForArrayList(createdArrayList);
        System.out.println("Time delta for created ArrayList: " + deltaForDeleteItemsArrayList);

        long deltaForDeleteitemsLinkedList = measureForDeletedElementInLinkedList(createdLinkedList);
        System.out.println("Time delta for delete 1000 elements from LinkedList:" + deltaForDeleteitemsLinkedList);


        long deltaForFoundedItemsArrayList = measureForFoundedValuesInArrayList(createdArrayList);
        System.out.println("Time delta for count 1000 elements from ArrayList: " + deltaForFoundedItemsArrayList);


        long deltaForFoundedElementsLinkedList = measureForFoundedValuesInLinkedList(createdLinkedList);
        System.out.println("Time delta for count 1000 elements from LinkedList: " + deltaForFoundedElementsLinkedList);
    }

    private static void addRandomToCreatedList(List<Integer> integers) {
        for (int i = 0; i < 1000000; i++) {
            int a = RANDOM.nextInt(1000);
            integers.add(a);
        }

    }

    private static long addRandomtoCreatedArrayListMeasure(List<Integer> createdArrayList) {
        long startTime = System.nanoTime();
        addRandomToCreatedList(createdArrayList);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }


    private static long addRandomCreatedLinkedListMeasure(List<Integer> createdLinkedList) {

        long startTime = System.nanoTime();
        addRandomToCreatedList(createdLinkedList);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }


    private static void deleteElementsFormSelectedList(List<Integer> integers) {

        int i = 0;
        while (i < 1000) {
            integers.remove(i);
            i++;
        }

    }

    private static long measureForDeletedElementInLinkedList(List<Integer> createdLinkedList) {
        long startTime = System.nanoTime();
        deleteElementsFormSelectedList(createdLinkedList);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    private static long measureForDeletedElementForArrayList(List<Integer> createdArrayList) {
        long startTime = System.nanoTime();
        deleteElementsFormSelectedList(createdArrayList);
        long endTime = System.nanoTime();
        return (endTime - startTime);

    }

    private static void foundByElement(List<Integer> integers) {

        int i = 0;
        while (i < 1000) {
            integers.contains(i);
            i++;
        }
    }

    private static long measureForFoundedValuesInArrayList(List<Integer> createdArrayList) {
        long startTime = System.nanoTime();
        foundByElement(createdArrayList);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    private static long measureForFoundedValuesInLinkedList(List<Integer> createdLinkedList) {
        long startTime = System.nanoTime();
        foundByElement(createdLinkedList);
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }
}