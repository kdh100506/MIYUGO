package October_11st;
import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("세 숫자를 입력하세요: ");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();

        int max = number1;
        if (max < number2) {
            max = number2;
        }
        if (max < number3) {
            max = number3;
        }

        int min = number1;
        if (min > number2) {
            min = number2;
        }
        if (min > number3) {
            min = number3;
        }

        int mid = number1 + number2 + number3 - max - min;

        System.out.println(max);
        System.out.println(mid);
        System.out.println(min);
    }
}
