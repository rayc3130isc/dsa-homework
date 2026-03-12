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
            System.out.println("Is " + j + " even? ==> " + isEven.test(j));
        }
        border();
    }
    public static void lengthFilter(Set<String> strings) {
        // 5) Lambda - Checks if a word is over 3 letters long
        Predicate<String> isLong = strung -> strung.length() > 5;
        Iterator<String> s = strings.iterator();
        while(s.hasNext()) {
            String sting = s.next();
            System.out.println("\"" + sting + "\"" + " is long? => " + isLong.test(sting));
        }
        border();
    }
    public static void orderWords(List<String> words) {
        //6) Lambda - Sorting words in ABC order
        words.sort((a,b) -> a.compareTo(b));
        List<String> orderedWords = new ArrayList<>();

        words.forEach(n -> orderedWords.add(n));
        System.out.println("Sorted Words: " + orderedWords);
        border();
    }
    public static void removeBig(List<Integer> ints) {
        //7) Lambda - Removal
        Predicate<Integer> targetSize = x -> x > 10;
        Iterator<Integer> intit = ints.iterator();
        List<Integer> filtered = new ArrayList<>();

        while(intit.hasNext()) {
            int j = intit.next();
            if(targetSize.test(j)) {
                intit.remove();
            } else {filtered.add(j);}
        }
        System.out.println("Filtered List: " + filtered);
        border();
    }
    public static void makeUpper(List<String> words) {
        //8) Lambda - Uppercase all words
        words.replaceAll(w -> w.toUpperCase());
        System.out.println(words);
        border();
    }
    public static void removeSmall (List<String> words) {
        //9) Lambda - Removes short words using removeIf
        List<String> filtered = new ArrayList<>(words);

        filtered.removeIf(w -> w.length() <= 5);
        System.out.println("Long Words: " + filtered);
        border();
    }
    public static void getMax(List<Integer> nums) {
        //10) Iterator - prints out the highest value in a collection
        Integer max = Collections.max(nums, (a, b) -> a - b); //sorts

        System.out.println(nums);
        System.out.println("Maximum number: " + max);
        border();
    }

    public static void main(String [] args) {
        ArrayList<Integer> numbs = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        ArrayList<String> words = new ArrayList<>(Arrays.asList("choice", "refuse", "polite", "butterfly" , "spot"));
        Set<String> set = Set.of("first", "second", "third", "fourth");
        ArrayList<Integer> mess = new ArrayList<>(Arrays.asList(23, 21, 42, 7, 5, 29, 31, 9));

        printNums(numbs);       //demonstrate method1
        iterateSet(set);          //demonstrate method2
        doubleNums(numbs);    //demonstrate method3
        checkEven(numbs);      //demonstrate method4
        lengthFilter(set);        //demonstrate method5
        orderWords(words);    //demonstrate method6
        removeBig(numbs);       //demonstrate method7
        makeUpper(words);      //demonstrate method8
        removeSmall(words);   //demonstrate method9
        getMax(mess);            //demonstrate method10
    }
    public static void border() {System.out.println("===============");}
}
