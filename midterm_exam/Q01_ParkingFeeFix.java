public class Q01_ParkingFeeFix {
    public static void main(String[] args) {
        int[] testMinutes = {-20,0,1,29, 30, 31,32,59, 60, 61,119, 120,122, 121,179,180,181,360,361, 420};

        for (int minutes : testMinutes) {
            int fee = calculateFee(minutes);
            System.out.println("停車 " + minutes + " 分鐘，費用：" + fee + " 元");
        }
    }

    public static int calculateFee(int minutes) {
        if (minutes < 0) {
            return -1;
        }else if (minutes <= 30){
            return 0 ; 
          
        }else if (minutes <=120){
              return ((minutes - 31) / 30 + 1) * 20;
        }else {
             int fee = 60 + ((minutes - 121) / 60 + 1) * 30;
            
              if (fee > 180) {
                fee = 180;
        }
            return fee ; 
             }
           
        }
    
        
    }

