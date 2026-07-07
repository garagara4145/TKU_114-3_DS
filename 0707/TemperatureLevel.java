import java.util.Scanner;

public class TemperatureLevel {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("溫度: ");
        int temperature = sc.nextInt();

        if (temperature < 15) {
            System.out.println("Cold");
        } 
        else if (temperature < 28) { 
            // 走到這裡，代表溫度一定已經「大於等於 15」，所以只要判斷有沒有「小於 28」即可
            System.out.println("Comfortable");
        } 
        else {
            // 走到這裡，代表前面的條件都不符合，也就是溫度「28以上」
            System.out.println("Hot");
        }
      



    }
}
