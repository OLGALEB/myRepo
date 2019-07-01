package com.playtika;

import java.util.List;
import java.util.Map;

public class ProgramPerformance {
    public static void main(String[] args) {
        List<NewStudent> studentsList = NewStudent.listDeclaration();
        System.out.println("Students List: " + studentsList);

        List<NewStudent> sortedByAgeList = NewStudent.sortByAge(studentsList);
        System.out.println("Sorted by age List: " + sortedByAgeList);

        List<NewStudent> selectedBySurnameList = NewStudent.surnameStartWithI(studentsList);
        System.out.println("Students starts with I: " + selectedBySurnameList);

        double averageAge = NewStudent.getAverageAge(studentsList);
        System.out.println("Average age: " + averageAge);

        Map<Integer, NewStudent> studentsListHash = NewStudent.convertToMap(studentsList);
        System.out.println("Hash Map: " + studentsListHash);

        Map<Integer, NewStudent> selectedByKeyStudents = NewStudent.selectedByKey(studentsListHash);
        System.out.println("Selected by Key Map : " + selectedByKeyStudents);
    }
}
