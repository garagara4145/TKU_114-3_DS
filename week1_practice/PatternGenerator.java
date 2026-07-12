import java.util.Scanner;

public class PatternGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            printMenu();

            System.out.print("請輸入選項：");
            int option = sc.nextInt();

            switch (option) {

                case 1:
                    printMultiplicationTable();
                    break;

                case 2:
                    int h1 = readPositiveInt(sc, "請輸入高度：");
                    printTriangle(h1);
                    break;

                case 3:
                    int h2 = readPositiveInt(sc, "請輸入高度：");
                    printReverseTriangle(h2);
                    break;

                case 4:
                    int rows = readPositiveInt(sc, "請輸入列數：");
                    int cols = readPositiveInt(sc, "請輸入欄數：");
                    printNumberGrid(rows, cols);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    sc.close();
                    return;

                default:
                    System.out.println("選項錯誤！");
            }

            System.out.println();
        }
    }

    // 顯示選單
    public static void printMenu() {
        System.out.println("=== Pattern Menu ===");
        System.out.println("1. 九九乘法表");
        System.out.println("2. 正三角形");
        System.out.println("3. 倒三角形");
        System.out.println("4. 數字方格");
        System.out.println("0. 離開");
    }

    // 輸入正整數
    public static int readPositiveInt(Scanner sc, String message) {

        System.out.print(message);
        int num = sc.nextInt();

        while (num <= 0) {
            System.out.print("請重新輸入：");
            num = sc.nextInt();
        }

        return num;
    }

    // 九九乘法表
    public static void printMultiplicationTable() {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.print(i + "x" + j + "=" + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    // 正三角形
    public static void printTriangle(int height) {

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 倒三角形
    public static void printReverseTriangle(int height) {

        for (int i = height; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 數字方格
    public static void printNumberGrid(int rows, int cols) {

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}