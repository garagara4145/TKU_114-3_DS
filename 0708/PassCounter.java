public class PassCounter {

    public static void main(String[] args) {
        int[] scores = {80, 55, 70};
        int count = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 60) {
                count++;
            }
        }

        System.out.println("Pass Count: " + count);
    }
}