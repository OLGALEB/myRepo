package com.playtika;

import java.util.*;


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

    public static List<Student> listDeclaration() {
        List<Student> studentList = new ArrayList<>();
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
            System.out.println(st.toString());
        }
        Collections.sort(studentList, new AgeComparator());
        System.out.println(studentList);

        return studentList;
    }

    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student st1, Student st2) {

            return st2.getAge() - st1.getAge();
        }
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

    public static HashMap<Integer, Student> convertToMap(List<Student> studentList) {
        HashMap<Integer, Student> studentsHM = new HashMap<>(); //convert list to map

        for (Student student1 : studentList) {
            studentsHM.put((student1.getId()), student1);
        }
        return studentsHM;
    }

    public static Map<Integer, Student> selectedByKey(HashMap<Integer, Student> studentsHM) {
        Map<Integer, Student> selectedByKeyMap = new HashMap<>();
        Iterator<Map.Entry<Integer, Student>> iterator = studentsHM.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Student> entry = iterator.next();
            Integer key = entry.getKey();
            if (key > 5) {
                selectedByKeyMap.put(entry.getKey(), entry.getValue());
            }

        }
        System.out.println("printlnSelected by Key HashMap: " + selectedByKeyMap);
        return selectedByKeyMap;
    }

    public static List<Student> surnameStartsWithI(List<Student> studentList) {
        ArrayList<Student> listSelectedBySurname = new ArrayList<>();
        for (Student sortedStudent : studentList) {
            if (sortedStudent.getSurname().startsWith("I")) {
                listSelectedBySurname.add(sortedStudent);
            }
        }
        return listSelectedBySurname;
    }

    public static double getAverageAge(List<Student> studentList) {
        int startedPoint = 0;

        for (Student elementForAverage : studentList) {
            startedPoint += elementForAverage.getAge();
        }
        double averageAgeResult = startedPoint / studentList.size();
        return averageAgeResult;
    }

}













