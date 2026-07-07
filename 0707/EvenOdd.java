import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] number ){

        Scanner sc = new Scanner(System.in);
        System.out.print("nu: ");
        int Anumber = sc.nextInt();

        if (Anumber % 2 == 0) {
             System.out.println("even");
        }else{
             System.out.println("odd");
        }

    }
}
