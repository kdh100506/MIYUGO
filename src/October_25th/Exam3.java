package October_25th;

public class Exam3 {
    public static void stars(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("*****");
        }
    }

    public static void stars(int n, char c) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void stars(int w, int h) {
        System.out.println("사각형의 넓이: " + w*h);
    }

    public static void main(String[] args) {
        stars(2);
        stars(3, '#');
        stars(5, 6);
    }
}
