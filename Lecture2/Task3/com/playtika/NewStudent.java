package com.playtika;

import java.util.List;


public class NewStudent {
    private int id;
    private String name;
    public String surname;
    public int age;

    public NewStudent(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    public int getAge() {

        return age;
    }


    public int getId() {

        return id;
    }


    @Override
    public String toString() {
        return "NewStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public static void userOutPut(String s, List<NewStudent> studentsList) {
        System.out.println(s);
        for (NewStudent newStudent : studentsList) {
            System.out.println(studentsList);

        }

    }

    public static void printAverageAge(String s) {
        System.out.println(s);
    }

    public static void getHashMap(String s) {
        System.out.println(s);

    }

}















