import java.util.Scanner;

public class PersonalProfileApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("請輸入姓名：");
        String name = sc.nextLine();

        int age = readPositiveInt(sc, "請輸入年齡：");
        double height = readPositiveDouble(sc, "請輸入身高(公尺)：");
        double weight = readPositiveDouble(sc, "請輸入體重(公斤)：");

        double bmi = calculateBmi(height, weight);
        String level = getBmiLevel(bmi);
        boolean adult = isAdult(age);

        printReport(name, age, adult, height, weight, bmi, level);

        sc.close();
    }

    public static int readPositiveInt(Scanner sc, String message) {
        System.out.print(message);
        int num = sc.nextInt();

        while (num <= 0) {
            System.out.print("請重新輸入：");
            num = sc.nextInt();
        }

        return num;
    }

    public static double readPositiveDouble(Scanner sc, String message) {
        System.out.print(message);
        double num = sc.nextDouble();

        while (num <= 0) {
            System.out.print("請重新輸入：");
            num = sc.nextDouble();
        }

        return num;
    }

    public static double calculateBmi(double h, double w) {
        return w / (h * h);
    }

    public static String getBmiLevel(double bmi) {
        if (bmi < 18.5)
            return "體重過輕";
        else if (bmi < 24)
            return "普通";
        else if (bmi < 27)
            return "過重";
        else
            return "肥胖";
    }

    public static boolean isAdult(int age) {
        return age >= 18;
    }

    public static void printReport(String name, int age, boolean adult,
                                   double height, double weight,
                                   double bmi, String level) {

        System.out.println();
        System.out.println("=== Personal Health Report ===");
        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("是否成年：" + adult);
        System.out.println("身高：" + height);
        System.out.println("體重：" + weight);
        System.out.println("BMI：" + bmi);
        System.out.println("BMI分級：" + level);
    }
}