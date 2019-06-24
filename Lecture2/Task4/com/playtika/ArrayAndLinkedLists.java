package com.playtika;
import java.util.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;



public class ArrayAndLinkedLists {



    public static void main(String[] args) {
        int a = 0;
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        final Random newRandom = new Random(); // Create Random generator

        ArrayList <Integer> ourArrayList = new ArrayList<>();
        LinkedList <Integer> ourLinkedList = new LinkedList<>();
        long startTime1 = System.nanoTime();
        enterRandomtoList(ourArrayList,a,startTime,endTime,newRandom);
        long endTime1 = System.nanoTime();

        long startTime2 = System.nanoTime();
        enterRandomtoList(ourLinkedList,a,startTime,endTime, newRandom);
        long endTime2 = System.nanoTime();

        System.out.println("ourArrayList = " + ourArrayList);
        System.out.println("ourLinkedList = " + ourLinkedList);
        System.out.println("Time delta for ArrayList: " + (endTime1 - startTime1));
        System.out.println("Time delta for LinkedList: " + (endTime2 - startTime2));

        long startTime3 = System.nanoTime();
        deleteElement(ourArrayList,a,startTime,endTime,newRandom);
        long endTime3 = System.nanoTime();

        long startTime4 = System.nanoTime();
        deleteElement(ourLinkedList,a,startTime,endTime,newRandom);
        long endTime4 = System.nanoTime();

        System.out.println("Time delta for delete 1000 elements from ArrayList: " + (endTime3 - startTime3));
        System.out.println("Time delta for delete 1000 elements from ArrayList: " + (endTime4 - startTime4));

        long startTime5 = System.nanoTime();
        foundByElement(ourArrayList,a,startTime,endTime,newRandom);
        long endTime5 = System.nanoTime();

        long startTime6 = System.nanoTime();
        foundByElement(ourLinkedList,a,startTime,endTime,newRandom);
        long endTime6 = System.nanoTime();

        System.out.println("Time delta for count 1000 elements from ArrayList: " + (endTime5 - startTime5));
        System.out.println("Time delta for count 1000 elements from ArrayList: " + (endTime6 - startTime6));
    }


    private static long enterRandomtoList(List<Integer> integers, int a, long startTime, long endTime, Random newRandom) {
for (int i= 0; i < 1000000; i++) {
    a = newRandom.nextInt(1000);
    integers.add(a);

    }


        return endTime;
    }


    private static long deleteElement(List<Integer> integers, int a, long startTime, long endTime, Random newRandom) {
        //for (int i= 0; i < 1000000; i++) {
                //a = newRandom.nextInt(1000000);
            integers.remove(1000);


        return endTime;
    }

    private static long foundByElement(List<Integer> integers, int a, long startTime, long endTime, Random newRandom) {

            integers.contains(1000);


        return endTime;
    }

}















