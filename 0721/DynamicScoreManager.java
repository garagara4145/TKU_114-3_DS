import java.util.ArrayList;
import java.util.Scanner;

public class DynamicScoreManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<>();

        inputScores(sc, scores);

        if (scores.isEmpty()) {
            System.out.println("沒有任何成績資料！");
            return;
        }

        System.out.println("筆數：" + scores.size());
        System.out.printf("平均：%.2f\n", calculateAverage(scores));
        System.out.println("最高：" + findMax(scores));
        System.out.println("最低：" + findMin(scores));

        System.out.println("及格名單：");
        printPassList(scores);

        sc.close();
    }

    public static void inputScores(Scanner sc, ArrayList<Integer> scores) {
        while (true) {
            System.out.print("請輸入成績(-1結束)：");
            int score = sc.nextInt();

            if (score == -1) {
                break;
            }

            if (score >= 0 && score <= 100) {
                scores.add(score);
            } else {
                System.out.println("錯誤：成績只能介於0~100！");
            }
        }
    }

    public static double calculateAverage(ArrayList<Integer> scores) {
        int sum = 0;

        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.size();
    }

    public static int findMax(ArrayList<Integer> scores) {
        int max = scores.get(0);

        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }

        return max;
    }

    public static int findMin(ArrayList<Integer> scores) {
        int min = scores.get(0);

        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }

        return min;
    }
    public static void printPassList(ArrayList<Integer> scores) {
        boolean found = false;

        for (int score : scores) {
            if (score >= 60) {
                System.out.println(score);
                found = true;
            }
        }

        if (!found) {
            System.out.println("沒有及格者！");
        }
    }
}