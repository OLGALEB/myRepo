package com.playtika;

import java.util.List;
import java.util.Map;

public class ProgramPerformance {
    public static void main(String[] args) {
        NewStudents studentsList = new NewStudents();
        studentsList.sortByAge ();

        List<NewStudent> x = studentsList.surnameStartWithI();
        NewStudent.userOutPut("Surname starts with I",x);

        double a = studentsList.getAverageAge();
        Student.printAverageAge("Average age: " + Double.toString(a));

        Map<Integer, NewStudent> w = studentsList.convertToMap();
        Student.getHashMap("Student's HashMap:" + w);

        Map<Integer, NewStudent> selectedByKeyStudents = studentsList.selectedByKey(w);
    }
}
