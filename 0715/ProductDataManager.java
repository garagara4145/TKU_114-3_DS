import java.util.Scanner;

public class ProductDataManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] records = {
                "Keyboard,890,12",
                "Mouse,490,20",
                "Monitor,5200,5",
                "USB Cable,250,30",
                "Headset,1290,8",
                "A,100,50",
                "B,80,999",
                "c,10,5"
        };
        String[] name = new String[records.length];
        int[] prices = new int[records.length];
        int[] stocks = new int[records.length];

        for (int i = 0; i < records.length; i++) {

            String[] parts = records[i].split(",");

            name[i] = parts[0].trim();
            prices[i] = Integer.parseInt(parts[1].trim());
            stocks[i] = Integer.parseInt(parts[2].trim());

        }

        System.out.println(" 商品 ");
        System.out.println("商品\t價格\t庫存");

        for (int i = 0; i < name.length; i++) {

        System.out.println(name[i] + "\t" + prices[i] + "\t" + stocks[i]);

        }
        System.out.print("\n請輸入商品名稱：");
            String keyword = sc.nextLine().trim().toLowerCase();

            boolean found = false;

            System.out.println("\n搜尋結果：");

            for (int i = 0; i < name.length; i++) {

                if (name[i].toLowerCase().contains(keyword)) {

                    System.out.println("商品：" + name[i]);
                    System.out.println("價格：" + prices[i]);
                    System.out.println("庫存：" + stocks[i]);
                    System.out.println();

                    found = true;
                }
            }

            if (!found) {
                System.out.println("找不到符合商品");
            }

        System.out.println("\n低庫存");

        for (int i = 0; i < name.length; i++) {

            if (stocks[i] < 10) {

                System.out.println(name[i] + " 庫存：" + stocks[i]);

            }

        }


        int totalValue = 0;
        for (int i = 0; i < name.length; i++) {

            totalValue += prices[i] * stocks[i];

        }

        System.out.println("\n庫存價值：" + totalValue);

        System.out.println("\n請輸入要新增商品資料");
        System.out.println("格式：商品名稱,價格,庫存");

        String input = sc.nextLine();

        try {

            String[] parts = input.split(",");

            if (parts.length != 3) {

                System.out.println("格式錯誤");
            } else {
                String newName = parts[0].trim();
                int newPrice = Integer.parseInt(parts[1].trim());
                int newStock = Integer.parseInt(parts[2].trim());

                String[] newNames = new String[name.length + 1];
                int[] newPrices = new int[prices.length + 1];
                int[] newStocks = new int[stocks.length + 1];
                
                    for (int i = 0; i < name.length; i++) {
                        newNames[i] = name[i];
                        newPrices[i] = prices[i];
                        newStocks[i] = stocks[i];
                    }
                        newNames[name.length] = newName;
                        newPrices[prices.length] = newPrice;
                        newStocks[stocks.length] = newStock;

                        name = newNames;
                        prices = newPrices;
                        stocks = newStocks;
    


                System.out.println("\n新增成功！");
                System.out.println("商品：" + newName);
                System.out.println("價格：" + newPrice);
                System.out.println("庫存：" + newStock);

                System.out.println("\n===== 全部商品資料 =====");
                System.out.println("商品\t價格\t庫存");

    for (int i = 0; i < name.length; i++) {
        System.out.println(name[i] + "\t" + prices[i] + "\t" + stocks[i]);



    }
            }

        } catch (NumberFormatException e) {

            System.out.println("格式錯誤");

        } catch (Exception e) {

            System.out.println("格式錯誤：" + e.getMessage());

        }

        sc.close();

    }

}