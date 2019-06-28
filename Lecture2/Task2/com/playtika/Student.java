package com.playtika;

import java.util.Comparator;
import java.util.List;
import java.util.Map;


public class Student {
    private int id;
    private String name;
    private String surname;
    private int age;

    public Student(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getAge() {

        return age;
    }

    public String getSurname() {

        return surname;
    }

    public int getId() {

        return id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }


    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student st1, Student st2) {

            return st2.getAge() - st1.getAge();
        }
    }

    public static void userOutPut(String s, List<Student> studentList) {
        System.out.println(s);
        for (Student student : studentList) {
            System.out.println(studentList);
        }
    }

    public static void printAverageAge(String s) {
        System.out.println(s);
    }

    public static void getHashMap(String s) {
        System.out.println(s);

    }

    public static void selectByKeyPrunt(String f, Map<Integer, Student> integerStudentMap) {
        System.out.println(f);
        for (Map.Entry<Integer, Student> integerStudentEntry : integerStudentMap.entrySet()) {

        }

    }
}




























