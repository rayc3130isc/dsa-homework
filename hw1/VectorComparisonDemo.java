import java.util.*;

public class VectorComparisonDemo {

    public static void main(String[] args) {

        Vector<Product> vector = new Vector<>();
        ArrayList<Product> arrayList = new ArrayList<>();

        // Measure add time
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            vector.add(new Product("P" + i, "Product" + i, "Category", 10.0, 100, "Supplier"
            ));
        }
        long vectorAddTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(new Product("P" + i, "Product" + i, "Category", 10.0, 100, "Supplier"
            ));
        }
        long arrayListAddTime = System.nanoTime() - start;

        // Random access test
        Random rand = new Random();

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            vector.get(rand.nextInt(10000));
        }
        long vectorAccessTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get(rand.nextInt(10000));
        }
        long arrayListAccessTime = System.nanoTime() - start;

        // Print results
        System.out.println("===== Performance Comparison =====");
        System.out.println("Add 10,000 elements:");
        System.out.println("Vector: " + vectorAddTime + " ns");
        System.out.println("ArrayList: " + arrayListAddTime + " ns");

        System.out.println("\nAccess 1,000 random elements:");
        System.out.println("Vector: " + vectorAccessTime + " ns");
        System.out.println("ArrayList: " + arrayListAccessTime + " ns");
    }

    // Summary:
    // Vectors take much longer adding the 10.000 elements, but seem to be on par with accessing 1.000 random elements
    // In fact, they seem to be more consistent than ArrayLists, where one instance reached 0.34ms whilst Vectors were more consistent with that time around 0.27ms up to 0.31ms
    // In short, while ArrayLists are more practical, Vectors seem to do better when accessing large amounts of random information.
}
