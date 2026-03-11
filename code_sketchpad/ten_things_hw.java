package HW2_ArrayLists_Generics.code_sketchpad;

import java.util.*;

public class ten_things_hw {
    public static void main (String [] args) {

        // 1) Basic Lambda Usage
        // .forEach(), print out everything in an array
        ArrayList<Integer> arra1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        arra1.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // 2) Basic Iterator Usage
        Set<String> set = Set.of("first", "second", "third", "fourth");

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {System.out.print(it.next() + " ");}
        // Elements in set do not have indices, so an Iteraor must be used to traverse it
    }
}
