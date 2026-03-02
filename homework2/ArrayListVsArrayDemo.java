package HW2_ArrayLists_Generics.homework2;

import java.util.*;

public class ArrayListVsArrayDemo {

    public static void main(String[] args) {
        Student[] studentArray = new Student[3];
        ArrayList<Student> studentList = new ArrayList<>();

        studentArray[0] = new Student("S001", "Alice", "Brown", "abrown23@gmail.com", 3.8, "English", 2);
        studentList.add(new Student("S001", "Alice", "Brown", "abrown23@gmail.com", 3.8, "English", 2));

        studentList.add(new Student("S002", "Bob", "Smith", "bs1244@gmail.com", 2.7, "Math", 3));
        studentList.remove(0);

        int size = 10000;
        long start = System.nanoTime();
        Student[] testArray = new Student[size];
        ArrayList<Student> testList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            testArray[i] = new Student("S" + i, "First" + i, "Last" + i, "dummyaccount" + i + "@gmail.com",Math.random() * 4.0, "Undeclared", (int) Math.round(Math.random() * 5.0));
        }
        long end = System.nanoTime();
        System.out.println("Time to add 10,000 students (Array): " +  (double)(end - start)/1000000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            testList.add(new Student("S" + i, "First" + i, "Last" + i, "dummyaccount" + i + "@gmail.com",Math.random() * 4.0, "Undeclared", (int) Math.round(Math.random() * 5.0)));
        }
        end = System.nanoTime();
        System.out.println("Time to add 10,000 students (ArrayList): " + (double)(end - start)/1000000 + " ms");

        Random rand = new Random();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            Student student = testArray[rand.nextInt(size)];
        }
        end = System.nanoTime();
        System.out.println("\nTime to access 1,000 random elements (Array): " + (double)(end - start)/1000000 + " ms");

        rand = new Random();
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            testList.get(rand.nextInt(size));
        }
        end = System.nanoTime();
        System.out.println("Time to access 1,000 random elements (ArrayList): " + (double)(end - start)/1000000 + " ms");
    }
}
