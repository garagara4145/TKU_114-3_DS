import java.util.Scanner;

public class ProductManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];

        products[0] = new Product("Keyboard", 890, 12);
        products[1] = new Product("Mouse", 490, 20);
        products[2] = new Product("Monitor", 5200, 5);
        products[3] = new Product("USB Cable", 250, 30);
        products[4] = new Product("Headset", 1290, 8);

        int addCount = 0;
        int sellCount = 0;
        int restockCount = 0;
        int changeCount = 0;

        int choice;

        do {

            System.out.println("\n 商品管理");
            System.out.println("1. 顯示全部商品");
            System.out.println("2. 依完整名稱搜尋");
            System.out.println("3. 新增商品");
            System.out.println("4. 出售商品");
            System.out.println("5. 補充庫存");
            System.out.println("6. 修改商品價格");
            System.out.println("7. 顯示低庫存商品");
            System.out.println("8. 顯示全部庫存總價值");
            System.out.println("9. 結束");

            System.out.print("請輸入選項：");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println("\n商品\t價格\t庫存");

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null) {
                            System.out.println(products[i]);
                        }

                    }

                    break;

                case 2:

                    System.out.print("請輸入商品名稱：");
                    String keyword = sc.nextLine().trim();

                    boolean found = false;

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null &&
                                products[i].getName().trim().equalsIgnoreCase(keyword)) {

                            System.out.println(products[i]);
                            found = true;
                            break;

                        }

                    }

                    if (!found) {
                        System.out.println("找不到商品");
                    }

                    break;

                case 3:

                    System.out.print("商品名稱：");
                    String newName = sc.nextLine().trim();

                    boolean repeat = false;

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null &&
                                products[i].getName().equalsIgnoreCase(newName)) {

                            repeat = true;
                            break;

                        }

                    }

                    if (repeat) {

                        System.out.println("商品名稱重複！");
                        break;

                    }

                    int index = -1;

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] == null) {

                            index = i;
                            break;

                        }

                    }

                    if (index == -1) {

                        System.out.println("商品已滿！");
                        break;

                    }

                    System.out.print("價格：");
                    int price = Integer.parseInt(sc.nextLine());

                    System.out.print("庫存：");
                    int stock = Integer.parseInt(sc.nextLine());

                    products[index] = new Product(newName, price, stock);

                    addCount++;

                    System.out.println("新增成功！");

                    break;
                                    case 4:

                    System.out.print("商品名稱：");
                    String sellName = sc.nextLine().trim();

                    Product sellProduct = null;

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null &&
                                products[i].getName().equalsIgnoreCase(sellName)) {

                            sellProduct = products[i];
                            break;

                        }

                    }

                    if (sellProduct == null) {

                        System.out.println("找不到商品！");
                        break;

                    }

                    System.out.print("出售數量：");
                    int sellQty = Integer.parseInt(sc.nextLine());

                    if (sellProduct.sell(sellQty)) {

                        sellCount++;
                        System.out.println("出售成功！");

                    } else {

                        System.out.println("出售失敗！");

                    }

                    break;

                case 5:

                    System.out.print("商品名稱：");
                    String restockName = sc.nextLine().trim();

                    Product restockProduct = null;

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null &&
                                products[i].getName().equalsIgnoreCase(restockName)) {

                            restockProduct = products[i];
                            break;

                        }

                    }

                    if (restockProduct == null) {

                        System.out.println("找不到商品！");
                        break;

                    }

                    System.out.print("補貨數量：");
                    int qty = Integer.parseInt(sc.nextLine());

                    if (restockProduct.restock(qty)) {

                        restockCount++;
                        System.out.println("補貨成功！");

                    } else {

                        System.out.println("補貨失敗！");

                    }

                    break;

                case 6:

                    System.out.print("商品名稱：");
                    String priceName = sc.nextLine().trim();

                    Product priceProduct = null;

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null &&
                                products[i].getName().equalsIgnoreCase(priceName)) {

                            priceProduct = products[i];
                            break;

                        }

                    }

                    if (priceProduct == null) {

                        System.out.println("找不到商品！");
                        break;

                    }

                    System.out.print("新價格：");
                    int newPrice = Integer.parseInt(sc.nextLine());

                    if (priceProduct.setPrice(newPrice)) {

                        changeCount++;
                        System.out.println("修改成功！");

                    } else {

                        System.out.println("修改失敗！");

                    }

                    break;

                case 7:

                    System.out.println("\n低庫存商品：");

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null &&
                                products[i].isLowStock()) {

                            System.out.println(products[i]);

                        }

                    }

                    break;

                case 8:

                    long total = 0;

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null) {

                            total += products[i].getInventoryValue();

                        }

                    }

                    System.out.println("全部庫存總價值：" + total);

                    break;

                case 9:

                    int count = 0;

                    for (int i = 0; i < products.length; i++) {

                        if (products[i] != null) {

                            count++;

                        }

                    }

                    System.out.println("\n===== 操作摘要 =====");
                    System.out.println("目前商品數：" + count);
                    System.out.println("新增商品：" + addCount);
                    System.out.println("出售商品：" + sellCount);
                    System.out.println("補充庫存：" + restockCount);
                    System.out.println("修改價格：" + changeCount);
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("輸入錯誤！");
            }

        } while (choice != 9);

        sc.close();

    }

}