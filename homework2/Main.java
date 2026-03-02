package HW2_ArrayLists_Generics.homework2;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        ints.add(30);
        System.out.println("Sum: " + ArrayListUtils.sum(ints));
        System.out.println("Average: " + ArrayListUtils.average(ints));
    }
}
