import java.util.ArrayList;

public class ShoppingCartSystem {

    public static void main(String[] args) {

        ArrayList<CartItem> cart = new ArrayList<>();

        addItem(cart, new CartItem("P01", "Keyboard", 890, 1));
        addItem(cart, new CartItem("P02", "Mouse", 490, 2));
        addItem(cart, new CartItem("P01", "Keyboard", 890, 3)); // 增加數量

        updateQuantity(cart, "P02", 5);

        updateQuantity(cart, "P01", 0); // 測試錯誤

        System.out.println("===== 購物車 =====");
        showCart(cart);

        System.out.println("總金額：$" + calculateTotal(cart));
    }

    // 新增商品
    public static void addItem(ArrayList<CartItem> cart, CartItem item) {

        CartItem found = findItem(cart, item.getCode());

        if (found == null) {
            cart.add(item);
        } else {
            found.addQuantity(item.getQuantity());
        }
    }

    // 搜尋商品
    public static CartItem findItem(ArrayList<CartItem> cart, String code) {

        for (CartItem item : cart) {
            if (item.getCode().equalsIgnoreCase(code)) {
                return item;
            }
        }

        return null;
    }

    // 修改數量
    public static boolean updateQuantity(ArrayList<CartItem> cart, String code, int qty) {

        CartItem found = findItem(cart, code);

        if (found == null) {
            System.out.println("找不到商品！");
            return false;
        }

        if (!found.updateQuantity(qty)) {
            System.out.println("數量必須大於0！");
            return false;
        }

        return true;
    }

    // 計算總金額
    public static double calculateTotal(ArrayList<CartItem> cart) {

        double total = 0;

        for (CartItem item : cart) {
            total += item.getSubtotal();
        }

        return total;
    }

    // 顯示購物車
    public static void showCart(ArrayList<CartItem> cart) {

        if (cart.isEmpty()) {
            System.out.println("購物車沒有商品！");
            return;
        }

        for (CartItem item : cart) {
            System.out.println(item);
        }
    }
}