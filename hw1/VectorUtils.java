import java.util.Vector;

public class VectorUtils {
    public static <T> void swap(Vector<T> vec, int index1, int index2) {
        T buffer = vec.get(index1);
        vec.set(index1, vec.get(index2));
        vec.set(index2, buffer);
    }

    public static <T extends Comparable<T>> T findMax(Vector<T> vec) {
        if (vec.isEmpty()) {
            return null;
        }
        T max = vec.get(0);
        for (T n : vec) {
            if (n.compareTo(max) > 0) {
                max = n;
            }
        }
        return max;
    }

    public static <T> int countMatches(Vector<T> vec, T target) {
        int count = 0;
        for (T n : vec) {
            if (n.equals(target)) {
                count++;
            }
        }
        return count;
    }

    public static Vector<Product> filterProducts(Vector<Product> vec, String category) {
        Vector<Product> result = new Vector<>();

        for (Product p : vec) {
            if (p.getCategory().equals(category)) {
                result.add(p);
            }
        }

        return result;
    }

    public static <T extends Number> double sumNumbers(Vector<T> numbers) {
        double sum = 0.0;

        for (T number : numbers) {
            sum += number.doubleValue();
        }

        return sum;
    }

    public static <T extends Number> double averageNumbers(Vector<T> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }

        return sumNumbers(numbers) / numbers.size();
    }
}
