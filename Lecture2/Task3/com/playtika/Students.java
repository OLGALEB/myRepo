package com.playtika;
import java.security.Key;
import java.util.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;


import static java.util.Locale.filter;


public class Students {
    private int id;
    private String name;
    private String surname;
    private int age;

    public Students(int id, String name, String surname, int age) {
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
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        List<Students> studentList = new ArrayList<>();
        Students firstStudent = new Students(1, "Vova", "Ivanov", 18);
        studentList.add(firstStudent);
        Students secondStudent = new Students(2, "Lesha", "Lebedev", 19);
        studentList.add(secondStudent);
        Students thirdStudent = new Students(3, "Vanya", "Petrov", 21);
        studentList.add(thirdStudent);
        Students fifthStudent = new Students(5, "Sergey", "Sidorov", 22);
        studentList.add(fifthStudent);
        Students sixthStudent = new Students(6, "Andrey", "Ivanov", 20);
        studentList.add(sixthStudent);
        Students seventhStudent = new Students(7, "Igor", "Makarevich", 18);
        studentList.add(seventhStudent);
        Students eighthStudent = new Students(8, "Igor", "Nazarov", 19);
        studentList.add(eighthStudent);
        Students ninthStudent = new Students(9, "Artem", "Petrov", 24);
        studentList.add(ninthStudent);
        Students tenthStudent = new Students(10, "Pavel", "Nazarov", 21);
        studentList.add(tenthStudent);




        System.out.println("Sorted list by age:");
        Comparator<Students> byStudentListAge = Comparator.comparingInt(Students::getAge); //Sort by age
        studentList = studentList.stream().sorted(byStudentListAge).collect(Collectors.toList());

        for (int i = 0; i < studentList.size(); i++) {

            System.out.println(studentList.get(i).getAge());
        }


        System.out.println("Surnаme starts with I :"); //Select surnames which startsWith "I"

        List<Students> filteredBySurname =
                studentList
                        .stream()
                        .filter(p -> p.surname.startsWith("I"))
                        .collect(Collectors.toList());
        System.out.println(filteredBySurname);

        Double averageAge = studentList // Find average age
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        System.out.println("Students average age : " + averageAge);

        Map<String, List<Students>> studentsListHash =
                studentList.stream().collect(Collectors.groupingBy(Students::getName));
        System.out.println("HashMap with students: " + studentsListHash); // convert to HashMap
        }
      }







