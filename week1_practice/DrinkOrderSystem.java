import java.util.Scanner;

public class DrinkOrderSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int blackTea = 0;
        int greenTea = 0;
        int milkTea = 0;
        int coffee = 0;

        int totalItems = 0;
        int totalAmount = 0;

        while (true) {

            printMenu();

            System.out.print("請輸入選項：");
            int option = sc.nextInt();

            if (option == 0)
                break;

            int price = getPrice(option);

            if (price == 0) {
                System.out.println("選項錯誤！");
                continue;
            }

            int quantity = readValidQuantity(sc);

            int subtotal = calculateSubtotal(price, quantity);

            System.out.println("小計：" + subtotal);

            totalItems += quantity;
            totalAmount += subtotal;

            if (option == 1)
                blackTea += quantity;
            else if (option == 2)
                greenTea += quantity;
            else if (option == 3)
                milkTea += quantity;
            else if (option == 4)
                coffee += quantity;

            System.out.println();
        }

        int finalAmount = calculateDiscountedTotal(totalAmount);

        printReceipt(blackTea, greenTea, milkTea, coffee,
                totalItems, totalAmount, finalAmount);

        sc.close();
    }

    public static void printMenu() {
        System.out.println("==== Drink Menu ====");
        System.out.println("1. Black Tea 30");
        System.out.println("2. Green Tea 35");
        System.out.println("3. Milk Tea 45");
        System.out.println("4. Coffee 50");
        System.out.println("0. Checkout");
    }

    public static int getPrice(int option) {

        switch (option) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 45;
            case 4:
                return 50;
            default:
                return 0;
        }
    }

    public static int readValidQuantity(Scanner sc) {

        System.out.print("請輸入數量：");
        int quantity = sc.nextInt();

        while (quantity <= 0) {
            System.out.print("請重新輸入：");
            quantity = sc.nextInt();
        }

        return quantity;
    }

    public static int calculateSubtotal(int price, int quantity) {
        return price * quantity;
    }

    public static int calculateDiscountedTotal(int totalAmount) {

        if (totalAmount >= 300)
            return totalAmount * 9 / 10;
        else
            return totalAmount;
    }

    public static String getItemName(int option) {

        if (option == 1)
            return "Black Tea";
        else if (option == 2)
            return "Green Tea";
        else if (option == 3)
            return "Milk Tea";
        else if (option == 4)
            return "Coffee";
        else
            return "";
    }

    public static void printReceipt(int blackTea, int greenTea,
            int milkTea, int coffee,
            int totalItems, int totalAmount,
            int finalAmount) {

        System.out.println("==== Receipt ====");
        System.out.println("Black Tea : " + blackTea);
        System.out.println("Green Tea : " + greenTea);
        System.out.println("Milk Tea  : " + milkTea);
        System.out.println("Coffee    : " + coffee);
        System.out.println("Total Items : " + totalItems);
        System.out.println("Original Amount : " + totalAmount);

        if (totalAmount >= 300)
            System.out.println("Discount : Yes");
        else
            System.out.println("Discount : No");

        System.out.println("Final Amount : " + finalAmount);
    }
}