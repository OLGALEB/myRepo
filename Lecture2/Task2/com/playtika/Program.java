package com.playtika;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        List<Student> studentList = Student.listDeclaration();

        List<Student> selectedBySurnameList = Student.surnameStartsWithI(studentList);
        System.out.println("Students starts with I: " + selectedBySurnameList);

        double averageAge = Student.getAverageAge(studentList);
        System.out.println("Average age: " + Double.toString(averageAge));

        Map<Integer, Student> hashMapWithStudents = Student.convertToMap(studentList);
        System.out.println("Student's HashMap:" + hashMapWithStudents);

        Map<Integer, Student> selectedByKeyHashMap = Student.selectedByKey((HashMap<Integer, Student>) hashMapWithStudents);
        System.out.println("Selected by Key6:" + selectedByKeyHashMap);
    }
}
