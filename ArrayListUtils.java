package HW2_ArrayLists_Generics;

import java.util.*;

public class ArrayListUtils{
    public static <T> void swap(ArrayList<T> list, int index1, int index2) {
        T dummy = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, dummy);
    }

    public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
        T max = list.get(0);
        for (T t : list) {
            if (t.compareTo(max) > 0) {
                max = t;
            }
        }
        return max;
    }

    public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> condition) {
        ArrayList<T> filtered = new ArrayList<>();
        for (T item : list) {
            if (condition.test(item)) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    public static <T> void reverse(ArrayList<T> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            swap(list, i, list.size() - 1 - i);
        }
    }

    public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> merged = new ArrayList<>();
        for (T t1 : list1) {
            merged.add(t1);
        }
        for (T t2 : list2) {
            merged.add(t2);
        }
        return merged;
    }

    public static <T extends Number> double sum(ArrayList<T> numbers) {
        double sum = 0;
        for (Number i : numbers) {
            sum += i.doubleValue();
        }
        return sum;
    }

    public static <T extends Number> double average(ArrayList<T> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return sum(numbers) / numbers.size();
    }

    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold) {
        ArrayList<T> result = new ArrayList<>();
        for (T num : numbers) {
            if (num.compareTo(threshold) > 0) {
                result.add(num);
            }
        }
        return result;
    }
    public static double sumNumbers(ArrayList<? extends Number> numbers) {
        double total = 0;
        for (Number num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }
    public static void addNumbers(ArrayList<? super Integer> list) {
        list.add(1);
    }
    public static void printList(ArrayList<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
