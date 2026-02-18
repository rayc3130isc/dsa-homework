public class OrderItem {
    private String productId, productName;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    public OrderItem(String productId, String productName, int quantity, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        subtotal = unitPrice * quantity;
    }

    public String getProductId() {return productId;}
    public String getProductName() {return productName;}
    public int getQuantity() {return quantity;}
    public double getUnitPrice() {return unitPrice;}
    public double getSubtotal() {return subtotal;}

    public void setProductId(String productId) {this.productId = productId;}
    public void setProductName(String productName) {this.productName = productName;}
    public void setQuantity(int quantity) {this.quantity = quantity;}
    public void setUnitPrice(double unitPrice) {this.unitPrice = unitPrice;}

    public String toString(){ return productId + ", " + productName + ", " + quantity + ", " + unitPrice + ", " + subtotal;}

    public double calculateSubtotal() {
        subtotal = unitPrice * quantity;
        return quantity * unitPrice;
    }
}

