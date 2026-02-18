import java.util.Vector;

public class ProductInventory {
    private Vector<Product> products;

    public ProductInventory () {
        products = new Vector<>();
    }

    public void addProduct(Product product) {
        for (Product n : products) {
            if (n.equals(product)) {
                System.out.println("Product with ID " + n.getProductId() + "already exists.");
                return;
            }
        }
        products.add(product);
    }

    public boolean removeProduct(String productId) {
        for (Product n : products) {
            if (n.getProductId().equals(productId)) {
                products.remove(n);
                return true;
            }
        }
        return false;
    }

    public Product findProduct(String productId) {
        for (Product n : products) {
            if (n.getProductId().equals(productId)) {
                return n;
            }
        }
        return null;
    }

    public Vector<Product> getProductsByCategory(String category) {
        Vector<Product> filtered = new Vector<>();
        for (Product n : products) {
            if (category.equals(n.getCategory())) {
                filtered.add(n);
            }
        }
        return filtered;
    }

    public Vector<Product> getLowStockProducts(int threshold) {
        Vector<Product> filtered = new Vector<>();
        for (Product n : products) {
            if (n.getQuantityInStock() < threshold) {
                filtered.add(n);
            }
        }
        return filtered;
    }

   public double getTotalInventoryValue() {
        double totalValue = 0;
        for (Product n : products) {
            totalValue += n.getQuantityInStock() * n.getPrice();
        }
        return totalValue;
   }

   public void updateStock(String productId, int quantityChange) {
        for (Product n : products) {
            if (n.getProductId().equals(productId)) {
                n.setQuantityInStock(n.getQuantityInStock() + quantityChange);
            }
        }
   }

   public void printAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("ID\tName\tCategory\tPrice\tStock\tSupplier");
        for (Product p : products) {
            System.out.println(p);
       }
   }

    public int getTotalProducts() {
        return products.size();
   }

   public void printCapacityInfo() {
        System.out.println("Current size: " + products.size());
        System.out.println("Current capacity: " + products.capacity());
   }
}
