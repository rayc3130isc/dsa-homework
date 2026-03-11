package HW2_ArrayLists_Generics.code_sketchpad;

import java.util.function.*;

public class mar05_walkthrough {
    public static void main(String [] args) {

        // ------------------------------------------------------------
        // STEP 1: Identify the single abstract method in the interface
        // ------------------------------------------------------------
        // Consumer<T> has ONE abstract method:
        //      void accept(T t)
        // This means a Consumer "takes a value and returns nothing".
        // Because it has only ONE method, it is a FUNCTIONAL INTERFACE.
        // Functional interfaces can be implemented using lambdas.

        // ------------------------------------------------------------
        // STEP 2: Anonymous class (long traditional way)
        // ------------------------------------------------------------
        Consumer<String> printer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                // "s" is the input parameter
                System.out.println(s);
            }
        };

        printer1.accept("<1> Hello from anonymous class");


        // ------------------------------------------------------------
        // STEP 3: Replace anonymous class with a lambda
        // ------------------------------------------------------------
        // Since Consumer has method:
        //      void accept(String s)
        //
        // Lambda syntax:
        //      (parameters) -> { body }
        //
        // Because there is only ONE parameter, parentheses are optional.

        Consumer<String> printer2 = s -> System.out.println(s);
        printer2.accept("<2> Hello from lambda");

        // ------------------------------------------------------------
        // STEP 4: Method reference (cleaner version)
        // ------------------------------------------------------------
        // If a lambda ONLY calls an existing method,
        // we can replace it with a method reference.

        // Lambda version:
        // s -> System.out.println(s)

        // Method reference version:
        Consumer<String> printer3 = System.out::println;
        printer3.accept("<3> Hello from method reference");


        // ------------------------------------------------------------
        // Example with Predicate (very common in streams)
        // ------------------------------------------------------------
        // Predicate<T> has method:
        //      boolean test(T t)
        //
        // It returns true or false and is commonly used for filtering.

        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5));   // true
        System.out.println(isPositive.test(-2));  // false

        // ------------------------------------------------------------
        // How lambdas are used with collections
        // ------------------------------------------------------------
        // Lambdas are frequently used with Streams for filtering.

        java.util.List<Integer> nums = java.util.List.of(3, -2, 5, -7, 10);

        // stream() → converts collection to a stream pipeline
        // filter() → keeps elements where predicate is true
        // toList() → collects results into a new list
        java.util.List<Integer> positives =
                nums.stream()
                        .filter(x -> x > 0)
                        .toList();

        // forEach() runs a lambda for every element
        positives.forEach(System.out::println);
    }
}
