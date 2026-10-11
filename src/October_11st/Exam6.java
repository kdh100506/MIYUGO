package October_11st;

public class Exam6 {
    public static void main(String[] args) {
        System.out.println("SU MO TU WE TH FR SA");
        int next = 3;
        int a = 11;
        for (int i = 1; i <= 31; i++) {
            if(i == 1) {
                System.out.print("           ");
            }
            if(i < 10){
                if(i == 4){
                    System.out.print(" " + i);
                    continue;
                }
                System.out.print("  " + i);
            }
            if(i >= 10){
                if(i == a){
                    System.out.print(i);
                    a += 7;
                    continue;
                }
                System.out.print(" " + i);
            }
            if(i == next){
                System.out.println();
                next += 7;
            }
        }
    }
}
