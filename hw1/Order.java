import java.util.Vector;

public class Order {
    private String orderId, customerName, orderDate;
    private Vector<OrderItem> items;
    private String orderStatus;

    public Order(String orderId, String customerName, String orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        items = new Vector<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public boolean removeItem(String productId) {
        for (OrderItem o : items) {
            if (o.getProductId().equals(productId)) {
                items.remove(o);
                return true;
            }
        }
        return false;
    }

    public OrderItem findItem(String productId) {
        for (OrderItem o : items) {
            if (o.getProductId().equals(productId)) {
                return o;
            }
        }
        return null;
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem o : items) {
            total += o.calculateSubtotal();
        }
        return total;
    }

    public int getTotalItems() {
        int total = 0;
        for (OrderItem o : items) {
            total += o.getQuantity();
        }
        return total;
    }

    public void updateStatus(String newStatus) {
        orderStatus = newStatus;
    }

    public void printOrder() {
        System.out.println("Order ID: " + orderId + "\nCustomer Name: " + customerName + "\nOrder Date: " + orderDate + "\nOrders:");
        for (OrderItem o : items) {
            System.out.println(o.toString());
        }
        System.out.println("Order Status: " + orderStatus);
    }

    public Vector<OrderItem> getItems() {
        return new Vector<>(items);
    }

    public String getOrderId() {return orderId;}
    public String getOrderStatus() {return orderStatus;}
    public String getCustomerName() {return customerName;}
}

