package October_25th;

public class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    void introduce() {
        System.out.println(name + ": " + score + "점");
    }
}
