package com.playtika;

import java.util.*;

public class Runner {

    public static void main(String[] args) {
        List<Student> studentList = prepareList();

        List<Student> listSortedByAge = sortedByAge(studentList);
        System.out.println("Students sorted by age :" + listSortedByAge);

        List<Student> selectedBySurnameList = surnameStartsWithI(studentList);
        System.out.println("Students starts with I: " + selectedBySurnameList);

        double averageAge = getAverageAge(studentList);
        System.out.println("Average age: " + Double.toString(averageAge));

        Map<Integer, Student> hashMapWithStudents = convertToMap(studentList);
        System.out.println("Student's HashMap:" + hashMapWithStudents);

        Map<Integer, Student> selectedByKeyHashMap = selectedByKey((HashMap<Integer, Student>) hashMapWithStudents);
        System.out.println("Selected by Key:" + selectedByKeyHashMap);
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

    public static List<Student> sortedByAge(List<Student> studentList) {
        Collections.sort(studentList, new Student.AgeComparator());
        return studentList;
    }
}