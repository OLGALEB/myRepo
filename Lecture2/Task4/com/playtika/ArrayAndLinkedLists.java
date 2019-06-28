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

        long x = addRandomtoCreatedArrayListMeasure(newRandom, createdArrayList);
        System.out.println("Time delta for created ArrayList: " + x);

        long y = addRandomCreatedLinkedListMeasure(newRandom, createdLinkedList);
        System.out.println("Time delta for created LinkedList: " + y);

        long w = measureForDeletedElementForArrayList(createdArrayList);
        System.out.println("Time delta for created ArrayList: " + w);

        long z = measureForDeletedElementInLinkedList(createdLinkedList);
        System.out.println("Time delta for delete 1000 elements from LinkedList:" + z);


        long c = measureForFoundedValuesInArrayList(createdArrayList);
        System.out.println("Time delta for count 1000 elements from ArrayList: " + c);


        long r = measureForFoundedValuesInLinkedList(createdLinkedList);
        System.out.println("Time delta for count 1000 elements from LinkedList: " + r);
    }


    private static void addRandomToCreatedList(List<Integer> integers, Random newRandom) { // newRandom used in this method
        for (int i = 0; i < 100000; i++) {
            int a = newRandom.nextInt(1000);
            integers.add(a);
        }

    }

    private static long addRandomtoCreatedArrayListMeasure(Random newRandom, List<Integer> createdArrayList) {
        long startTime1 = System.nanoTime();
        addRandomToCreatedList(createdArrayList, newRandom);
        long endTime1 = System.nanoTime();
        return (endTime1 - startTime1);
    }


    private static long addRandomCreatedLinkedListMeasure(Random newRandom, List<Integer> createdLinkedList) {

        long startTime2 = System.nanoTime();
        addRandomToCreatedList(createdLinkedList, newRandom);
        long endTime2 = System.nanoTime();
        return (endTime2 - startTime2);
    }


    private static void deleteElementsFormSelectedList(List<Integer> integers) {

        int i = 0;
        while (i < 100) {
            integers.remove(i);
            i++;
        }

    }

    private static long measureForDeletedElementInLinkedList(List<Integer> createdLinkedList) {
        long startTime4 = System.nanoTime();
        deleteElementsFormSelectedList(createdLinkedList);
        long endTime4 = System.nanoTime();
        return (endTime4 - startTime4);
    }

    private static long measureForDeletedElementForArrayList(List<Integer> createdArrayList) {
        long startTime3 = System.nanoTime();
        deleteElementsFormSelectedList(createdArrayList);
        long endTime3 = System.nanoTime();
        return (endTime3 - startTime3);

    }

    private static void foundByElement(List<Integer> integers) {

        int i = 0;
        while (i < 100) {
            integers.contains(i);
            i++;
        }
    }

    private static long measureForFoundedValuesInArrayList(List<Integer> createdArrayList) {
        long startTime5 = System.nanoTime();
        foundByElement(createdArrayList);
        long endTime5 = System.nanoTime();
        return (endTime5 - startTime5);
    }

    private static long measureForFoundedValuesInLinkedList(List<Integer> createdLinkedList) {
        long startTime6 = System.nanoTime();
        foundByElement(createdLinkedList);
        long endTime6 = System.nanoTime();
        return (endTime6 - startTime6);
    }
}




















