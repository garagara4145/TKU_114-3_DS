import java.util.Scanner;

public class ScoreMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入姓名: ");
        String name = scanner.nextLine();

        System.out.print("請輸入 Java 成績: ");
        int javaScore = scanner.nextInt();

        System.out.print("請輸入英文成績: ");
        int englishScore = scanner.nextInt();

        System.out.print("請輸入數學成績: ");
        int mathScore = scanner.nextInt();

        double average = (javaScore + englishScore + mathScore) / 3.0;

        String status;
        if (average >= 60) {
            status = "及格";
        } else {
            status = "不及格";
        }

        char grade;
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n--- 學生功能選單 (" + name + ") ---");
            System.out.println("1：顯示平均分數");
            System.out.println("2：顯示及格狀態");
            System.out.println("3：顯示等第");
            System.out.println("0：離開");
            System.out.print("請選擇操作項目: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("平均分數為: %.2f 分\n", average);
                    break;
                case 2:
                    System.out.println("及格狀態為: " + status);
                    break;
                case 3:
                    System.out.println("分數等第為: " + grade);
                    break;
                case 0:
                    System.out.println("感謝使用，程式已結束。");
                    break;
                default:
                    System.out.println("無效的選項，請重新輸入！");
                    break;
            }
        }

      
    }
}
