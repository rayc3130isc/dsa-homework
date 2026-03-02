import java.util.Objects;

public class Product{
    String productId, name, category, supplier;
    double price;
    int quantityInStock;
    public Product (String productId, String name, String category, double price, int quantityInStock, String supplier) {
        this.productId = productId; this.name = name; this.category = category; this.price = price; this.quantityInStock = quantityInStock; this.supplier = supplier;
    }
    public String getProductId() {return productId;}
    public String getName() {return name;}
    public String getCategory() {return category;}
    public double getPrice() {return price;}
    public int getQuantityInStock() {return quantityInStock;}
    public String getSupplier() {return supplier;}

    public void setProductId(String productId) { this.productId = productId;}
    public void setName(String name) {this.name = name;}
    public void setCategory(String category) {this.category = category;}
    public void setPrice(double price) {this.price = price;}
    public void setQuantityInStock(int quantityInStock) {this.quantityInStock = quantityInStock;}
    public void setSupplier(String supplier) {this.supplier = supplier;}

    public String toString() {
        return productId + ", " + name + ", " + category + ", " + price + ", " + quantityInStock + ", " + supplier;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product other = (Product) obj;
        return (this.productId.equals(other.productId));
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

}
