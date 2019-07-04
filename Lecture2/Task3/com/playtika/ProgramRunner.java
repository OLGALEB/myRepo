package com.playtika;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgramRunner {
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

        Map<Integer, Student> selectedByKeyStudents = selectedByKey(studentsListHash);
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
        Comparator<Student> byStudentListAge = Comparator.comparingInt(Student::getAge);
        studentList = studentList.stream().sorted(byStudentListAge).collect(Collectors.toList());

        for (int i = 0; i < studentList.size(); i++) {

        }
        return studentList;
    }

    public static List<Student> surnameStartWithI(List<Student> studentList) {
        List<Student> filteredBySurname =
                studentList
                        .stream()
                        .filter(p -> p.getSurname().startsWith("I"))
                        .collect(Collectors.toList());
        return filteredBySurname;
    }


    public static double getAverageAge(List<Student> studentList) {
        double averageAge = studentList
                .stream()
                .collect(Collectors.averagingInt(p -> p.getAge()));

        return averageAge;
    }

    public static Map<Integer, Student> convertToMap(List<Student> studentList) {
        Map<Integer, Student> studentsListHash =
                studentList.stream().collect(Collectors.toMap(Student::getId, student -> student));
        return studentsListHash;
    }

    public static Map<Integer, Student> selectedByKey(Map<Integer, Student> studentsListHash) {
        Map<Integer, Student> selectedByKeyStudents = studentsListHash.entrySet().stream().filter(entry -> entry.getKey() <= 5).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        return selectedByKeyStudents;
    }
}
