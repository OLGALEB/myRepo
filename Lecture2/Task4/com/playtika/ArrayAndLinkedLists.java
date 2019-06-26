package com.playtika;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ArrayAndLinkedLists {
    public static void main(String[] args) {
        int a = 0;
        final Random newRandom = new Random(); // Create Random generator

        List<Integer> createdArrayList = new ArrayList<>();
        List<Integer> createdLinkedList = new LinkedList<>();
        System.out.println("createdArrayList = " + createdArrayList);
        System.out.println("createdLinkedList = " + createdLinkedList);

        addRandomtoCreatedArrayListMeasure(newRandom, createdArrayList);
        addRandomCreatedLinkedListMeasure(newRandom, createdLinkedList);

        measureForDeletedElementForArrayList(createdArrayList);
        measureForDeletedElementInLinkedList(createdLinkedList);


        measureForFoundedValuesInArrayList(createdArrayList);
        measureForFoundedValuesInLinkedList(createdLinkedList);
    }


    private static void addRandomToCreatedList(List<Integer> integers, Random newRandom) {
        for (int i = 0; i < 100000; i++) {
            int a = newRandom.nextInt(1000);
            integers.add(a);
        }

    }

    private static void addRandomtoCreatedArrayListMeasure(Random newRandom, List<Integer> createdArrayList) {
        long startTime1 = System.nanoTime();
        addRandomToCreatedList(createdArrayList, newRandom);
        long endTime1 = System.nanoTime();
        System.out.println("Time delta for LinkedList: " + (endTime1 - startTime1));
    }


    private static void addRandomCreatedLinkedListMeasure(Random newRandom, List<Integer> createdLinkedList) {

        long startTime2 = System.nanoTime();
        addRandomToCreatedList(createdLinkedList, newRandom);
        long endTime2 = System.nanoTime();
        System.out.println("Time delta for LinkedList: " + (endTime2 - startTime2));
    }


    private static void deleteElement(List<Integer> integers) {

        int i = 0;
        while (i < 100) {
            integers.remove(i);
            i++;
        }

    }

    private static void measureForDeletedElementInLinkedList(List<Integer> createdLinkedList) {
        long startTime4 = System.nanoTime();
        deleteElement(createdLinkedList);
        long endTime4 = System.nanoTime();
        System.out.println("Time delta for delete 1000 elements from LinkedList: " + (endTime4 - startTime4));
    }

    private static void measureForDeletedElementForArrayList(List<Integer> createdArrayList) {
        long startTime3 = System.nanoTime();
        deleteElement(createdArrayList);
        long endTime3 = System.nanoTime();
        System.out.println("Time delta for delete 1000 elements from ArrayList: " + (endTime3 - startTime3));
    }

    private static void foundByElement(List<Integer> integers) {

        int i = 0;
        while (i < 100) {
            integers.contains(i);
            i++;
        }
    }

    private static void measureForFoundedValuesInArrayList(List<Integer> createdArrayList) {
        long startTime5 = System.nanoTime();
        foundByElement(createdArrayList);
        long endTime5 = System.nanoTime();
        System.out.println("Time delta for count 1000 elements from ArrayList: " + (endTime5 - startTime5));
    }

    private static void measureForFoundedValuesInLinkedList(List<Integer> createdLinkedList) {
        long startTime6 = System.nanoTime();
        foundByElement(createdLinkedList);
        long endTime6 = System.nanoTime();
        System.out.println("Time delta for count 1000 elements from LinkedList: " + (endTime6 - startTime6));
    }

}




















