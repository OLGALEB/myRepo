package com.playtika;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {


    public static void main(String[] args) {
        Students studentList = new Students();
        studentList.printStudent();

        List<Student> x = studentList.surnameStartsWithI();
        Student.userOutPut("Students starts with I: ", x);

        double a = studentList.getAverageAge();
        Student.printAverageAge("Average age: " + Double.toString(a));

        Map<Integer, Student> w = studentList.convertToMap();
        Student.getHashMap("Student's HashMap:" + w);

        Map<Integer, Student> t = studentList.selectedByKey(w);
        Student.getHashMap("Selected by Key:" + t);

    }

}
