package com.playtika;


import java.util.Comparator;

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

    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student st1, Student st2) {

            return st2.getAge() - st1.getAge();
        }
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
}