package October_11st;

public class Exam4 {
    public static void main(String[] args) {
        int number = 50;
        int now = 1;

        while (now <= number) {
            int temp = now;
            int count = 0; // 3, 6, 9가 나온 횟수

            while (temp > 0) {
                int digit = temp % 10;
                if (digit == 3 || digit == 6 || digit == 9) {
                    count++;
                }
                temp /= 10;
            }

            if (count == 0) {
                System.out.print(now + " ");
            } else {
                for (int i = 0; i < count; i++) {
                    System.out.print("짝");
                }
                System.out.print(" ");
            }

            now++;
        }
    }
}