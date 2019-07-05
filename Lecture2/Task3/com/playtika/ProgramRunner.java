package com.playtika;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProgramRunner {
    static final int KEY_VALUE = 5;

    public static void main(String[] args) {
        List<Student> studentList = prepareList();
        System.out.println("Students List: " + studentList);

        List<Student> sortedByAgeList = sortByAge(studentList);
        System.out.println("Sorted by age List: " + sortedByAgeList);

        List<Student> selectedBySurnameList = surnameStartWithI(studentList);
        System.out.println("Students starts with I: " + selectedBySurnameList);

        double averageAge = getAverageAge(studentList);
        System.out.println("Average age: " + averageAge);

        Map<Integer, Student> studentsListHash = convertToMap(studentList);
        System.out.println("Hash Map: " + studentsListHash);

        Map<Integer, Student> selectedByKeyStudents = selectedByKey(studentsListHash, KEY_VALUE);
        System.out.println("Selected by Key Map : " + selectedByKeyStudents);
    }


    public static List<Student> prepareList() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Vova", "Ivanov", 18));
        studentList.add(new Student(2, "Lesha", "Lebedeva", 18));
        studentList.add(new Student(3, "Lesha", "Ivanov", 19));
        studentList.add(new Student(4, "Sergey", "Petrov", 19));
        studentList.add(new Student(5, "Sergey", "Sidorov", 22));
        studentList.add(new Student(6, "Andrey", "Ivanov", 20));
        studentList.add(new Student(7, "Igor", "Makarevich", 18));
        studentList.add(new Student(8, "Igor", "Nazarov", 19));
        studentList.add(new Student(9, "Artem", "Petrov", 24));
        studentList.add(new Student(10, "Pavel", "Nazarov", 21));
        for (Student st : studentList) {
            System.out.println(st.toString());
        }
        return studentList;
    }

    public static List<Student> sortByAge(List<Student> studentList) {
        Comparator<Student> comparator = new Student.AgeComparator();
        return studentList.stream().sorted(comparator).collect(Collectors.toList());
    }

    public static List<Student> surnameStartWithI(List<Student> studentList) {
        return studentList
                .stream()
                .filter(p -> p.getSurname().startsWith("I"))
                .collect(Collectors.toList());
    }


    public static double getAverageAge(List<Student> studentList) {
        return studentList
                .stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));
    }

    public static Map<Integer, Student> convertToMap(List<Student> studentList) {
        Map<Integer, Student> studentsListHash =
                studentList.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
        return studentsListHash;
    }

    public static Map<Integer, Student> selectedByKey(Map<Integer, Student> studentsListHash, int keyValue) {
        return studentsListHash.entrySet().stream().filter(entry -> entry.getKey() <= keyValue).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
    }
}