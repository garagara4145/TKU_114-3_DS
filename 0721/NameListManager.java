import java.util.ArrayList;
import java.util.Scanner;

public class NameListManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== 姓名管理系統 =====");
            System.out.println("1. 新增姓名");
            System.out.println("2. 搜尋姓名");
            System.out.println("3. 修改姓名");
            System.out.println("4. 刪除姓名");
            System.out.println("5. 顯示全部");
            System.out.println("0. 離開");
            System.out.print("請選擇：");

            while (!sc.hasNextInt()) {
                System.out.println("請輸入數字！");
                sc.next();
                System.out.print("請選擇：");
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("輸入姓名：");
                    addName(names, sc.nextLine());
                    break;

                case 2:
                    System.out.print("搜尋姓名：");
                    String search = sc.nextLine();
                    if (findName(names, search) != -1) {
                        System.out.println("找到：" + names.get(findName(names, search)));
                    } else {
                        System.out.println("找不到！");
                    }
                    break;

                case 3:
                    System.out.print("欲修改姓名：");
                    String oldName = sc.nextLine();
                    System.out.print("新姓名：");
                    String newName = sc.nextLine();

                    if (updateName(names, oldName, newName)) {
                        System.out.println("修改成功！");
                    } else {
                        System.out.println("找不到姓名！");
                    }
                    break;

                case 4:
                    System.out.print("欲刪除姓名：");
                    String deleteName = sc.nextLine();

                    if (removeName(names, deleteName)) {
                        System.out.println("刪除成功！");
                    } else {
                        System.out.println("找不到姓名！");
                    }
                    break;

                case 5:
                    showAll(names);
                    break;

                case 0:
                    System.out.println("程式結束！");
                    break;

                default:
                    System.out.println("請輸入0~5！");
            }

        } while (choice != 0);

        sc.close();
    }

    public static void addName(ArrayList<String> names, String name) {
        if (name.trim().isEmpty()) {
            System.out.println("姓名不可空白！");
            return;
        }

        names.add(name);
        System.out.println("新增成功！");
    }
    public static int findName(ArrayList<String> names, String name) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean updateName(ArrayList<String> names, String oldName, String newName) {
        int index = findName(names, oldName);

        if (index == -1 || newName.trim().isEmpty()) {
            return false;
        }

        names.set(index, newName);
        return true;
    }

    public static boolean removeName(ArrayList<String> names, String name) {
        int index = findName(names, name);

        if (index == -1) {
            return false;
        }

        names.remove(index);
        return true;
    }
    public static void showAll(ArrayList<String> names) {
        if (names.isEmpty()) {
            System.out.println("目前沒有任何姓名！");
            return;
        }

        System.out.println("===== 姓名列表 =====");
        for (String name : names) {
            System.out.println(name);
        }
    }
}