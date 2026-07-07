import java.util.Scanner;

public class DrinkMenu {
 public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         System.out.println("drink");
         int A = sc.nextInt();
        
        switch (A) {
            case 1:
                System.out.println("Black tea");
                break;
            case 2:
                System.out.println("Green tea");
                break;
            case 3:
                System.out.println("Coffeel");
                break;
            default:
                System.out.println("Unknown option");
        }
    }
}
    

