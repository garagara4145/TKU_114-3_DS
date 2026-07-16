import java.util.Scanner;

public class SalesMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] sales = new int[3][4];

        inputSales(sc, sales);

        System.out.println("\n銷售資料：");
        displaySales(sales);

        System.out.println("\n每項商品總銷售：");
        for (int i = 0; i < sales.length; i++) {
            System.out.println("商品 " + (i + 1) + "：" + rowTotal(sales, i));
        }

        System.out.println("\n每分區總銷售：");
        for (int i = 0; i < sales[0].length; i++) {
            System.out.println("分區 " + (i + 1) + "：" + columnTotal(sales, i));
        }

        int maxRow = findBestProduct(sales);

        System.out.println("\n總銷售量最高的商品：商品 " + (maxRow + 1));

        sc.close();
    }
    public static void inputSales(Scanner sc, int[][] sales) {

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {

                while (true) {

                    System.out.print("請輸入商品 " + (i + 1)
                            + " 分區 " + (j + 1) + " 的銷售量：");

                    int value = sc.nextInt();

                    if (value >= 0) {
                        sales[i][j] = value;
                        break;
                    }

                    System.out.println("銷售量不可小於0，請重新輸入！");
                }
            }
        }
    }

    public static void displaySales(int[][] sales) {

        for (int i = 0; i < sales.length; i++) {
            for (int j = 0; j < sales[i].length; j++) {
                System.out.print(sales[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static int rowTotal(int[][] sales, int row) {

        int total = 0;

        for (int i = 0; i < sales[row].length; i++) {
            total += sales[row][i];
        }

        return total;
    }
    public static int columnTotal(int[][] sales, int column) {

        int total = 0;

        for (int i = 0; i < sales.length; i++) {
            total += sales[i][column];
        }

        return total;
    }
    public static int findBestProduct(int[][] sales) {

        int bestRow = 0;
        int max = rowTotal(sales, 0);

        for (int i = 1; i < sales.length; i++) {

            int total = rowTotal(sales, i);

            if (total > max) {
                max = total;
                bestRow = i;
            }
        }

        return bestRow;
    }
}