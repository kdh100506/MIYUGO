package October_25th;

public class Player {
    String name;
    int level;
    int exp;

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public void gainExp(int gainedExp) {
        int oldLevelUps = this.exp / 100;
        this.exp += gainedExp;
        int newLevelUps = this.exp / 100;
        int levelUps = newLevelUps - oldLevelUps;

        for (int i = 0; i < levelUps; i++) {
            System.out.print("레벨업! ");
        }

        this.level += levelUps;
        System.out.println("Lv." + this.level + " (" + this.exp % 100 + "/100)");
    }

    public static void main(String[] args) {
        Player p = new Player("A", 2);
        p.gainExp(494);
    }
}
