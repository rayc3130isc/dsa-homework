package HW2_ArrayLists_Generics.code_sketchpad;
import java.util.*;
import java.util.function.*;

public class ten_things_hw {
    public static void printNums(List<Integer> arra1) {
        // 1) Basic Lambda Usage
        // .forEach(), print out everything in an array
        arra1.forEach(n -> System.out.print(n + " "));
        System.out.println();
        border();
    }
    public static void iterateSet(Set<String> s) {
        // 2) Basic Iterator Usage
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {System.out.print(it.next() + " ");}
        // Elements in set do not have indices, so an Iterator must be used to traverse it
        System.out.println();
        border();
    }
    public static void doubleNums(List<Integer> arra2) {
        // 3) Lambda - Double an array
        arra2.forEach(n -> System.out.println(n + " -> " + (n*2)));
        border();
    }
    public static void checkEven(List<Integer> ints) {
        // 4) Lambda  - Checks if an int is even or not
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Iterator<Integer> intit = ints.iterator();
        while(intit.hasNext()) {
            int j = intit.next();
            System.out.println(j + " is even? " + isEven.test(j));
        }
        border();
    }
    public static void lengthFilter(Set<String> strings) {
        // 5) Lambda - Checks if a word is over 3 letters long
        Predicate<String> isLong = strung -> strung.length() > 5;
        Iterator<String> s = strings.iterator();
        while(s.hasNext()) {
            String sting = s.next();
            System.out.println("\"" + sting + "\"" + " is long? " + isLong.test(sting));
        }
        border();
    }
    //6) Sorting
    //7) Removal
    //8)
    //9)
    //10)

    public static void main(String [] args) {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<String> set = Set.of("first", "second", "third", "fourth");
        printNums(numbs);
        iterateSet(set);
        doubleNums(numbs);
        checkEven(numbs);
        lengthFilter(set);
    }
    public static void border() {System.out.println("===============");}
}
