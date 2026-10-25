package October_25th;

public class Main {
    public static double average(int kor, int eng, int math) {
        return (kor + eng + math) / 3;
    }

    public static void multiplicationTable() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "단");
            for (int j = 1; j < 10; j++) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(average(90, 80, 70));
        System.out.println(average(85, 95, 75));
        System.out.println(average(60, 70, 80));

        multiplicationTable();
    }
}
