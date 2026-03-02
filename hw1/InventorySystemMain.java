import java.util.Vector;

public class InventorySystemMain {

    public static void main(String[] args) {

        System.out.println("<<< Inventory System Demo >>>");

        ProductInventory inventory = new ProductInventory();

        Product p1 = new Product("P001", "Water Bottles", "Drinks", 1.00, 1000, "Poland Spring");
        Product p2 = new Product("P010", "Lawn Chair", "Seating", 15.00, 200, "Home Depot");
        Product p3 = new Product("P100", "Plastic Plant", "Decoration", 2.00, 105, "Generic Company Name");

        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);

        System.out.println("\n--- All Products ---");
        inventory.printAllProducts(); // or whatever your method is

        System.out.println("\n--- Capacity Report ---");
        inventory.printCapacityReport();
        inventory.optimizeCapacity();
        inventory.printCapacityReport();

        OrderManager orderManager = new OrderManager();

        Order order1 = new Order("O1", "John Doe", "2026-11-11");
        order1.addItem(new OrderItem("P010", "Lawn Chair", 300, 15.00));
        order1.addItem(new OrderItem("P020", "Wooden Bench", 12, 100.00));

        orderManager.addOrder(order1);
        order1.updateStatus("Delivered");

        System.out.println("\n--- Orders ---");
        orderManager.printAllOrders();

        System.out.println("\nTotal Revenue:");
        System.out.println(orderManager.getTotalRevenue());

        System.out.println("\n--- Generic Utilities Demo ---");

        Vector<Integer> numbers = new Vector<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(5);

        System.out.println("Max number: " + VectorUtils.findMax(numbers));
        System.out.println("Sum: " + VectorUtils.sumNumbers(numbers));
        System.out.println("Average: " + VectorUtils.averageNumbers(numbers));

        VectorUtils.swap(numbers, 0, 2);
        System.out.println("After swap: " + numbers);

        System.out.println("\n<<< END >>>");
    }
}

