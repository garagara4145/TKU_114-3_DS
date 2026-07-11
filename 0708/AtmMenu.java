import java.util.Scanner;

public class AtmMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int balance = 1000;
        int choice;
        int money;

        while (true) {
            System.out.println("=== ATM Menu ===");
            System.out.println("1. 查詢餘額");
            System.out.println("2. 存款");
            System.out.println("3. 提款");
            System.out.println("0. 離開");
            System.out.print("請輸入選項：");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("目前餘額：" + balance);
                    break;

                case 2:
                    System.out.print("請輸入存款金額：");
                    money = sc.nextInt();

                    while (money <= 0) {
                        System.out.print("金額必須大於 0，請重新輸入：");
                        money = sc.nextInt();
                    }

                    balance += money;
                    System.out.println("存款成功，目前餘額：" + balance);
                    break;

                case 3:
                    System.out.print("請輸入提款金額：");
                    money = sc.nextInt();

                    while (money <= 0) {
                        System.out.print("金額必須大於 0，請重新輸入：");
                        money = sc.nextInt();
                    }

                    if (money > balance) {
                        System.out.println("餘額不足！");
                    } else {
                        balance -= money;
                        System.out.println("提款成功，目前餘額：" + balance);
                    }
                    break;

                case 0:
                    System.out.println("謝謝使用，再見！");
                    sc.close();
                    return;

                default:
                    System.out.println("選項錯誤，請重新輸入！");
            }

            System.out.println();
        }
    }
}