package com.playtika;
import java.security.Key;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import static java.lang.System.*;

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

    public static void main(String[] args) {

        ArrayList<Student> studentList = new ArrayList<>();
        Student firstStudent = new Student(1, "Vova", "Ivanov", 18);
        studentList.add(firstStudent);
        Student secondStudent = new Student(2, "Lesha", "Lebedev", 19);
        studentList.add(secondStudent);
        Student thirdStudent = new Student(3, "Vanya", "Petrov", 21);
        studentList.add(thirdStudent);
        Student fourthStudent = new Student(4, "Vanya", "Ivanov", 20);
        studentList.add(fourthStudent);
        Student fifthStudent = new Student(5, "Sergey", "Sidorov", 22);
        studentList.add(fifthStudent);
        Student sixthStudent = new Student(6, "Andrey", "Ivanov", 20);
        studentList.add(sixthStudent);
        Student seventhStudent = new Student(7, "Igor", "Makarevich", 18);
        studentList.add(seventhStudent);
        Student eighthStudent = new Student(8, "Igor", "Nazarov", 19);
        studentList.add(eighthStudent);
        Student ninthStudent = new Student(9, "Artem", "Petrov", 24);
        studentList.add(ninthStudent);
        Student tenthStudent = new Student(10, "Pavel", "Nazarov", 21);
        studentList.add(tenthStudent);
        for (Student st : studentList) {
            out.println(st.toString());
        }
        Collections.sort(studentList, new AgeComparator());
        out.println(studentList);

        startsWith(studentList);
        getAverage(studentList);



        HashMap <Integer,Student>  studentsHM = new HashMap <Integer, Student>(); //convert list to map

        for  (Student student1: studentList) {
            studentsHM.put((student1.getId()), student1);
        }

        System.out.println("Student's HashMap is: " + studentsHM);


        HashMap <Integer,Student> selectedByKey = new HashMap<>();
        Iterator<Map.Entry<Integer, Student>> iterator = studentsHM.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Student> entry = iterator.next();
            Integer key = entry.getKey();
            if(key>5){
                selectedByKey.put(entry.getKey(),entry.getValue());
            }

        }
        System.out.println("Selected by Key HashMap: " + selectedByKey);
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

    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student st1, Student st2) {
            return st2.getAge() - st1.getAge();
        }
    }

    public static ArrayList<Student> startsWith(ArrayList<Student> student) {
        ArrayList<Student> resultSorted = new ArrayList<>();
        for (Student sortedStudent : student) {
            if (sortedStudent.getSurname().startsWith("I")) {
                resultSorted.add(sortedStudent);
            }
        }
        System.out.println("Selection by the first I - letter of the surname: ");
        for (Student st1 : resultSorted) {
            System.out.println(st1.toString());
        }
        return resultSorted;
    }

    public static double getAverage(ArrayList<Student> student) {
        int startedPoint = 0;

        for (Student elementForAverage : student) {
            startedPoint += elementForAverage.getAge();
        }
        double averageAgeResult = startedPoint / student.size();
        System.out.println("Average age: " + averageAgeResult);
        return averageAgeResult;
    }
}










