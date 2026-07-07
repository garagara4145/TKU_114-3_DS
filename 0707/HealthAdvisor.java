import java.util.Scanner;

public class HealthAdvisor {
    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            System.out.print("name：");
            String name = sc.next();
   
            System.out.print("請輸入身高（m）：");
            double height = sc.nextDouble(); 
            
            System.out.print("請輸入體重（kg）：");
            double weight = sc.nextDouble();
            double bmi = weight / (height * height);
            
            String body = "";
            if (bmi < 18.5) {
               body = "體重過輕";
            } else if (bmi < 24) {
                body = "普通";
            } else if (bmi < 27) {
                body = "超重";
            } else {
                body = "肥胖";
            }
    
            System.out.println("\n=== BMI Report ===");
            System.out.println("Name: " + name);
            System.out.println("BMI: " + bmi);
            System.out.println("Level: " + body);
            System.out.println("==================\n");

            System.out.print("是否繼續輸入下一筆？(y/n)：");
            String choice = sc.next();
  
            if (!choice.equalsIgnoreCase("y")) {
                keepRunning = false;
            }
        }
        
        
    }
}