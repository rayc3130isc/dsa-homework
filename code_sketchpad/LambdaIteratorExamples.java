package HW2_ArrayLists_Generics.code_sketchpad;

import java.util.*;
import java.util.function.*;

public class LambdaIteratorExamples {

    public static void main(String[] args) {
        /*
        =========================================================
        EXAMPLE 1: Basic lambda using forEach()
        =========================================================
        forEach() accepts a lambda expression that runs on every
        element in the list.
        Lambda syntax:
        (parameter) -> { code }
        Here:
        n -> System.out.println(n)
        means:
        "for each element n in the list, print it"
        */

        System.out.println("Example 1: Print numbers using lambda");
        List<Integer> nums = Arrays.asList(1,2,3,4,5);
        nums.forEach(n -> System.out.println(n));



        /*
        =========================================================
        EXAMPLE 2: Iterator with lambda-style Consumer
        =========================================================

        Instead of using forEach(), we manually iterate.

        Iterator is an object that moves through a collection
        one element at a time.

        Methods used:
        hasNext() -> checks if more elements exist
        next() -> returns next element

        Then we pass the value into a Consumer lambda.

        Consumer<T> represents a function that takes input
        and returns nothing.
        */

        System.out.println("\nExample 2: Iterator + Consumer");
        Iterator<Integer> it = nums.iterator();
        Consumer<Integer> printer = x -> System.out.println("Value: " + x);
        while(it.hasNext()){
            printer.accept(it.next());
        }

        /*
        =========================================================
        EXAMPLE 3: Lambda that doubles numbers
        =========================================================
        Function<T,R> represents a function that:
        takes input type T
        returns type R
        Here:
        Integer -> Integer
        x -> x*2
        */

        System.out.println("\nExample 3: Lambda function doubling numbers");
        Function<Integer,Integer> doubler = x -> x * 2;
        nums.forEach(n -> System.out.println(doubler.apply(n)));

        /*
        =========================================================
        EXAMPLE 4: Lambda filtering values
        =========================================================
        Predicate<T> represents a function returning boolean.
        Used for conditions.
        x -> x % 2 == 0
        means "is x even?"
        We iterate manually and test the predicate.
        */

        System.out.println("\nExample 4: Filter even numbers");
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Iterator<Integer> it2 = nums.iterator();
        while(it2.hasNext()){
            int val = it2.next();
            if(isEven.test(val)){
                System.out.println(val);
            }
        }

        /*
        =========================================================
        EXAMPLE 5: Lambda to sum numbers
        =========================================================
        We'll iterate through a list and accumulate values.
        The lambda performs addition.
        BinaryOperator<T> represents an operation
        that takes two values and returns one.
        (a,b) -> a+b
        */

        System.out.println("\nExample 5: Sum numbers using lambda");
        BinaryOperator<Integer> adder = (a,b) -> a + b;
        int sum = 0;
        Iterator<Integer> it3 = nums.iterator();
        while(it3.hasNext()){
            sum = adder.apply(sum, it3.next());
        }
        System.out.println("Sum = " + sum);

        /*
        =========================================================
        EXAMPLE 6: Lambda that converts to string
        =========================================================
        Function<Integer,String>
        Converts integers into text.
        */

        System.out.println("\nExample 6: Convert numbers to strings");
        Function<Integer,String> converter =
                x -> "Number: " + x;
        nums.forEach(n -> System.out.println(converter.apply(n)));

        /*
        =========================================================
        EXAMPLE 7: Removing elements using Iterator
        =========================================================
        Iterator allows safe removal while iterating.
        If we used a normal for loop removing elements,
        we'd get ConcurrentModificationException.
        remove() deletes the current element.
        */

        System.out.println("\nExample 7: Remove numbers < 3");
        List<Integer> modList = new ArrayList<>(nums);
        Iterator<Integer> it4 = modList.iterator();
        while(it4.hasNext()){
            int val = it4.next();
            if(val < 3){
                it4.remove();
            }
        }
        modList.forEach(n -> System.out.println(n));

        /*
        =========================================================
        EXAMPLE 8: Lambda comparator for sorting
        =========================================================
        Lambdas are commonly used for sorting.
        Comparator<T> defines ordering.
        (a,b) -> b-a
        sorts in descending order.
        */

        System.out.println("\nExample 8: Sort descending with lambda");
        List<Integer> sortList = new ArrayList<>(nums);
        sortList.sort((a,b) -> b - a);
        sortList.forEach(n -> System.out.println(n));

        /*
        =========================================================
        EXAMPLE 9: Custom functional interface
        =========================================================
        A functional interface has exactly ONE abstract method.
        Lambdas can implement it automatically.
        Here we define a simple greeting interface.
        */

        System.out.println("\nExample 9: Custom lambda interface");
        Greeting greet = name -> System.out.println("Hello " + name);
        greet.sayHello("Alice");
        greet.sayHello("Bob");

        /*
        =========================================================
        EXAMPLE 10: Iterator counting elements
        =========================================================
        We'll iterate through a list and count elements
        that satisfy a predicate condition.
        Here we count numbers greater than 2.
        */

        System.out.println("\nExample 10: Count numbers > 2");
        Predicate<Integer> greaterThanTwo = x -> x > 2;
        int count = 0;
        Iterator<Integer> it5 = nums.iterator();
        while(it5.hasNext()){
            int val = it5.next();
            if(greaterThanTwo.test(val)){
                count++;
            }
        }
        System.out.println("Count = " + count);
    }

}
