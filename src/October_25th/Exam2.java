package October_25th;

public class Exam2 {
    public static int roll() {
        return roll(6);
    }

    public static int roll(int sides) {
        return (int)(Math.random() * sides) + 1;
    }

    public static int roll(int sides, int count) {
        int sum = 0;
        for (int i = 0; i < count; i++) sum += roll(sides);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(roll());
        System.out.println(roll(20));
        System.out.println(roll(10, 3));
    }
}
