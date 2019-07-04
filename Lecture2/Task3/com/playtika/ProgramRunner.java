package com.playtika;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgramRunner {
    public static void main(String[] args) {
        List<NewStudent> studentsList = listDeclaration();
        System.out.println("Students List: " + studentsList);

        List<NewStudent> sortedByAgeList = sortByAge(studentsList);
        System.out.println("Sorted by age List: " + sortedByAgeList);

        List<NewStudent> selectedBySurnameList = surnameStartWithI(studentsList);
        System.out.println("Students starts with I: " + selectedBySurnameList);

        double averageAge = getAverageAge(studentsList);
        System.out.println("Average age: " + averageAge);

        Map<Integer, NewStudent> studentsListHash = convertToMap(studentsList);
        System.out.println("Hash Map: " + studentsListHash);

        Map<Integer, NewStudent> selectedByKeyStudents = selectedByKey(studentsListHash);
        System.out.println("Selected by Key Map : " + selectedByKeyStudents);
    }

    public static List<NewStudent> listDeclaration() {
        List<NewStudent> studentsList = new ArrayList<>();
        NewStudent firstStudent = new NewStudent(1, "Vova", "Ivanov", 18);
        studentsList.add(firstStudent);
        NewStudent secondStudent = new NewStudent(2, "Lesha", "Lebedev", 19);
        studentsList.add(secondStudent);
        NewStudent thirdStudent = new NewStudent(3, "Vanya", "Petrov", 21);
        studentsList.add(thirdStudent);
        NewStudent fifthStudent = new NewStudent(5, "Sergey", "Sidorov", 22);
        studentsList.add(fifthStudent);
        NewStudent sixthStudent = new NewStudent(6, "Andrey", "Ivanov", 20);
        studentsList.add(sixthStudent);
        NewStudent seventhStudent = new NewStudent(7, "Igor", "Makarevich", 18);
        studentsList.add(seventhStudent);
        NewStudent eighthStudent = new NewStudent(8, "Igor", "Nazarov", 19);
        studentsList.add(eighthStudent);
        NewStudent ninthStudent = new NewStudent(9, "Artem", "Petrov", 24);
        studentsList.add(ninthStudent);
        NewStudent tenthStudent = new NewStudent(10, "Pavel", "Nazarov", 21);
        studentsList.add(tenthStudent);
        return studentsList;
    }

    public static List<NewStudent> sortByAge(List<NewStudent> studentsList) {
        Comparator<NewStudent> byStudentListAge = Comparator.comparingInt(NewStudent::getAge);
        studentsList = studentsList.stream().sorted(byStudentListAge).collect(Collectors.toList());

        for (int i = 0; i < studentsList.size(); i++) {

        }
        return studentsList;
    }

    public static List<NewStudent> surnameStartWithI(List<NewStudent> studentsList) {
        List<NewStudent> filteredBySurname =
                studentsList
                        .stream()
                        .filter(p -> p.surname.startsWith("I"))
                        .collect(Collectors.toList());
        return filteredBySurname;
    }

    public static double getAverageAge(List<NewStudent> studentsList) {
        double averageAge = studentsList
                .stream()
                .collect(Collectors.averagingInt(p -> p.age));

        return averageAge;
    }

    public static Map<Integer, NewStudent> convertToMap(List<NewStudent> studentsList) {
        Map<Integer, NewStudent> studentsListHash =
                studentsList.stream().collect(Collectors.toMap(NewStudent::getId, student -> student));
        return studentsListHash;
    }

    public static Map<Integer, NewStudent> selectedByKey(Map<Integer, NewStudent> studentListHash) {
        Map<Integer, NewStudent> selectedByKeyStudents = studentListHash.entrySet().stream().filter(entry -> entry.getKey() <= 5).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        return selectedByKeyStudents;
    }
}