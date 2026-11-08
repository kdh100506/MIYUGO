package Nobember_8th;

import java.util.Random;

public class Exam1 {
    public static void main(String[] args) {
        Random random = new Random();

        int dice = random.nextInt(6) + 1;
        System.out.println("주사위: " + dice);

        System.out.println("더 큰 값: " + Math.max(17, 42));
        System.out.println("절댓값: " + Math.abs(-9));
        System.out.println("반올림: " + Math.round(3.6));
    }
}
