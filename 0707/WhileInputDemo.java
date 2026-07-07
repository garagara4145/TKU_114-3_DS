import java.util.Scanner;

public class WhileInputDemo {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in); 
         System.out.println("num");
         int A= sc.nextInt();
        
           while (A != 0) {
            System.out.println(A);

            System.out.print("next num: ");
            A = sc.nextInt();
        }

        System.out.println("end");

}
}