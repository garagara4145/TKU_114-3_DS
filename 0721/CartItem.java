public class CartItem {
    private String code;
    private String name;
    private double price;
    private int quantity;

    public CartItem(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return price * quantity;
    }

    public void addQuantity(int qty) {
        quantity += qty;
    }

    public boolean updateQuantity(int qty) {
        if (qty <= 0) {
            return false;
        }
        quantity = qty;
        return true;
    }

    @Override
    public String toString() {
        return code + " | " + name + " | $" + price
                + " | 數量=" + quantity
                + " | 小計=$" + getSubtotal();
    }
}