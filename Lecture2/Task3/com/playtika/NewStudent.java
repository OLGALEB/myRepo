package com.playtika;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class NewStudent {
    private int id;
    private String name;
    private String surname;
    private int age;

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

    public static void main(String[] args) {

        List<NewStudent> studentList = new ArrayList<>();
        NewStudent firstStudent = new NewStudent(1, "Vova", "Ivanov", 18);
        studentList.add(firstStudent);
        NewStudent secondStudent = new NewStudent(2, "Lesha", "Lebedev", 19);
        studentList.add(secondStudent);
        NewStudent thirdStudent = new NewStudent(3, "Vanya", "Petrov", 21);
        studentList.add(thirdStudent);
        NewStudent fifthStudent = new NewStudent(5, "Sergey", "Sidorov", 22);
        studentList.add(fifthStudent);
        NewStudent sixthStudent = new NewStudent(6, "Andrey", "Ivanov", 20);
        studentList.add(sixthStudent);
        NewStudent seventhStudent = new NewStudent(7, "Igor", "Makarevich", 18);
        studentList.add(seventhStudent);
        NewStudent eighthStudent = new NewStudent(8, "Igor", "Nazarov", 19);
        studentList.add(eighthStudent);
        NewStudent ninthStudent = new NewStudent(9, "Artem", "Petrov", 24);
        studentList.add(ninthStudent);
        NewStudent tenthStudent = new NewStudent(10, "Pavel", "Nazarov", 21);
        studentList.add(tenthStudent);

        sortByAge(studentList);
        surnameStartWithI(studentList);
        getAverageAge(studentList);
        Map<Integer, NewStudent> studentsListHash = convertToMap(studentList);
        Map<Integer, NewStudent> selectedByKeyStudents = selectedByKey(studentsListHash);


    }

    public static void sortByAge(List<NewStudent> studentList) {
        System.out.println("Sorted list by age:");
        Comparator<NewStudent> byStudentListAge = Comparator.comparingInt(NewStudent::getAge);
        studentList = studentList.stream().sorted(byStudentListAge).collect(Collectors.toList());

        for (int i = 0; i < studentList.size(); i++) {

            System.out.println(studentList.get(i).getAge());
        }
    }

    public static void surnameStartWithI(List<NewStudent> studentList) {
        System.out.println("Surnаme starts with I :");
        List<NewStudent> filteredBySurname =
                studentList
                        .stream()
                        .filter(p -> p.surname.startsWith("I"))
                        .collect(Collectors.toList());
        System.out.println(filteredBySurname);
    }

    public static void getAverageAge(List<NewStudent> studentList) {
        double averageAge = studentList
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        System.out.println("Student's average age : " + averageAge);

    }

    public static Map<Integer, NewStudent> convertToMap(List<NewStudent> studentList) {
        Map<Integer, NewStudent> studentsListHash =
                studentList.stream().collect(Collectors.toMap(NewStudent::getId, student -> student));

        System.out.println("HashMap with students: " + studentsListHash);

        return studentsListHash;
    }


    public static Map<Integer, NewStudent> selectedByKey(Map<Integer, NewStudent> studentListHash) {
        Map<Integer, NewStudent> selectedByKeyStudents = studentListHash.entrySet().stream().filter(entry -> entry.getKey() <= 5).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        System.out.println("Sorted by Key: " + selectedByKeyStudents);
        return selectedByKeyStudents;
    }
}














