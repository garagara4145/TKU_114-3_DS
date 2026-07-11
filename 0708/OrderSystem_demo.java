import java.util.Scanner;

public class OrderSystem_demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        int quantity;
        int totalItems = 0;
        int totalAmount = 0;

        while (true) {
            System.out.println("=== Order Menu ===");
            System.out.println("1. Black tea  $30");
            System.out.println("2. Green tea  $35");
            System.out.println("3. Coffee     $50");
            System.out.println("0. Checkout");

            System.out.print("請輸入選項：");
            choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            int price = 0;

            switch (choice) {
                case 1:
                    price = 30;
                    break;
                case 2:
                    price = 35;
                    break;
                case 3:
                    price = 50;
                    break;
                default:
                    System.out.println("商品選項錯誤！");
                    continue;
            }

            System.out.print("請輸入數量：");
            quantity = sc.nextInt();

            while (quantity <= 0) {
                System.out.print("數量不合法，請重新輸入：");
                quantity = sc.nextInt();
            }

            int subtotal = price * quantity;
            totalAmount += subtotal;
            totalItems += quantity;

            System.out.println("Subtotal: " + subtotal);
            System.out.println();
        }

        System.out.println("=== Receipt ===");
        System.out.println("Total items: " + totalItems);
        System.out.println("Total amount: " + totalAmount);

        sc.close();
    }
}