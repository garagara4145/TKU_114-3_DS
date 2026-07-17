/*
1.  system.out.println("系統結束，年齡：" + age)
    編譯錯誤 
    程式後沒加分號;
    在最後加上分號(;)

2.  for (int i = 0; i <= scores.length; i++)
    執行錯誤
    超出陣列索引範圍
    改成 i < scores.length

3.  if (command == "exit")
    邏輯錯誤
    不是字串內容
    if (command.equals("exit")) {
            System.out.println("系統結束，年齡：" + age);
        }

4.  double average = total / scores.length;
    邏輯錯誤
    兩個int小數會衝突
    double average = (double) total / scores.length;

5.   nextInt() 後直接使用 nextLine()
    換行問題
    nextLine() 讀到空字串
    在 nextInt() 後加入 sc.nextLine();


*/
import java.util.Scanner;

public class DebuggingChallenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = {80, 75, 92};
        int total = 0;

        // for (int i = 0; i < scores.length; i++) {}
        
        for (int i = 0; i < scores.length; i++) {
            total += scores[i];
        }

        //double average = total / scores.length;
        double average = (double) total / scores.length;
        System.out.printf("平均：%.2f%n", average);

        System.out.print("請輸入年齡：");
        int age = sc.nextInt();

        //空白
        sc.nextLine();

        System.out.print("請輸入指令：");
        String command = sc.nextLine();

        // if (command == "exit")
        if (command.equals("exit")) {
            //System.out.println("系統結束，年齡：" + age)
            System.out.println("系統結束，年齡：" + age);
        }

        sc.close();
    }
}