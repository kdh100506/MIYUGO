package October_11st;

public class Exam1 {
    public static void main(String[] args) {
        int year = 1;
        String yearType = "";

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            yearType = "윤년";
        } else {
            yearType = "평년";
        }

        System.out.println(yearType);
    }
}
