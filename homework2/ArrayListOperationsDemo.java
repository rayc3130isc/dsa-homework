package HW2_ArrayLists_Generics.homework2;

import java.util.*;

public class ArrayListOperationsDemo <T> {
    public static void main(String [] args) {
        line();
        Student s1 = new Student("S101", "John", "Doe", "jdoe1@gmail.com",4.0, "Interdisciplinary Studies", 4);
        Student s2 = new Student("S121", "Jane", "Doe", "jdoe2@yahoo.com",1.2, "Gender Studies", 2);
        Student s3 = new Student("S132", "Donnie", "John", "djohn03@gmail.com",3.7, "Aerospace Engineering", 3);
        Student s4 = new Student("S144", "Abcde", "Effgee", "abcdefg@gmail.com",2.5, "English", 1);
        Student s5 = new Student("S150", "Owen", "Ng", "ong@gmail.com",3.0, "Religious Studies", 4);
        Student[] array1 = {s1, s2, s3, s4, s5};

        List<Student> converted = new ArrayList<>(Arrays.asList(array1));
        converted.remove(s3);
        printAll(converted);
        line();
        converted.add(s3);
        printAll(converted);
        line();
        ArrayList<Student> converted2 = copyList(converted);

        Student[] array2 = converted2.toArray(new Student[converted2.size()]);

        printAll(converted2.subList(1,4));
        line();
        converted2.subList(1,4).remove(s2);
        printAll(converted2);

        Collections.sort(converted,(st1, st2) -> Double.compare(st2.getGpa(), st1.getGpa()));
        line();
        printAll(converted);

        Collections.sort(converted, Comparator.comparing(Student::getLastName));
        line();
        printAll(converted);

        Student target = new Student("S000", "Little", "Timmy", "liltim@bing.com", 0.2, "Undeclared", 1);
        line();
        System.out.println("Index of target: " + converted.indexOf(target));
        System.out.println("Contains target: " + converted.contains(target));
        converted.add(target);
        line();
        System.out.println("Index of target: " + converted.indexOf(target));
        System.out.println("Contains target: " + converted.contains(target));

        Collections.sort(converted, Comparator.comparing(Student::getStudentId));

        int index = Collections.binarySearch(converted, target, Comparator.comparing(Student::getStudentId));
        line();
        System.out.println("Binary search index: " + index);
    }

    public static void printAll(List<Student> s) {
        for (Student ss : s) {
            System.out.println(ss.toString());
        }
    }
    public static void printAll(ArrayList<Student> s) {
        for (Student ss : s) {
            System.out.println(ss.toString());
        }
    }
    public static ArrayList<Student> copyList(List<Student> l) {
        ArrayList<Student> newList = new ArrayList<>();
        for (Student s : l) {
            newList.add(s);
        }
        return newList;
    }
    public static void printAll(Student[] s) {
        for (Student ss : s) {
            System.out.println(ss.toString());
        }
    }
    public static void line() {
        System.out.println("----------------------------");
    }
}
