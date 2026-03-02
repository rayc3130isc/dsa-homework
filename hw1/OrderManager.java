import java.util.Vector;

public class OrderManager {
    private Vector<Order> orders;
    public OrderManager() {
        orders = new Vector<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order findOrder(String orderId) {
        for(Order o : orders) {
            if (o.getOrderId().equals(orderId)) {
                return o;
            }
        }
        return null;
    }

    public Vector<Order> getOrdersByStatus(String status) {
        Vector<Order> filtered = new Vector<>();
        for (Order o : orders) {
            if (o.getOrderStatus().equals(status)) {
                filtered.add(o);
            }
        }
        return filtered;
    }

    public Vector<Order> getOrdersByCustomer(String customerName) {
        Vector<Order> filtered = new Vector<>();
        for (Order o : orders) {
            if (o.getCustomerName().equals(customerName)) {
                filtered.add(o);
            }
        }
        return filtered;
    }

    public double getTotalRevenue() {
        double total = 0;
        for (Order o : orders) {
            if ("Delivered".equals(o.getOrderStatus())) {
                total += o.calculateTotal();
            }
        }

        return total;
    }

    public void cancelOrder(String orderId) {
        findOrder(orderId).updateStatus("Cancelled");
    }

    public void printAllOrders() {
        for (Order o : orders) {
            o.printOrder();
        }
    }

    public Vector<Order> getPendingOrders() {
        Vector<Order> filtered = new Vector<>();
        for (Order o : orders) {
            if (o.getOrderStatus().equals("Pending")) {
                filtered.add(o);
            }
        }
        return filtered;
    }

    public int getOrderCount() {
        return orders.size();
    }
}

