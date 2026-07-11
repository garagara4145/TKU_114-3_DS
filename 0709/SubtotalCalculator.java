public class SubtotalCalculator {
    public static void main(String[] args) {
        int subtotal = calculateSubtotal(120, 3);

     
        System.out.println("商品小計：" + subtotal);
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }
}