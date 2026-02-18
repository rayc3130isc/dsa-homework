import java.util.Vector;

public class ProductInventory {
    private Vector<Product> products;

    public ProductInventory () {
        products = new Vector<>();
    }

    public void addProduct(Product product) {
        for (Product n : products) {
            if (n.equals(product)) {
                System.out.println("Product with ID " + n.productId + "already exists.");
                return;
            }
        }
        products.add(product);
    }
}
