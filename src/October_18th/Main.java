package October_18th;

public class Main {
    public static void main(String[] args) {
        String[] names = {"슬라임", "고블린", "오크", "드래곤", "해골병사"};
        int[] hps = {30, 50, 120, 500, 60};
        int[] attacks = {5, 12, 25, 80, 15};
        Monster[] book = new Monster[names.length];

        for (int i = 0; i < names.length; i++) {
            book[i] = new Monster();
            book[i].name = names[i];
            book[i].hp = hps[i];
            book[i].attack = attacks[i];
        }

        Monster maxAttack = book[0];
        int totalHp = 0;
        Monster[] up100 = new Monster[book.length];
        Monster maxHp = book[0];
        for (int i = 0; i < book.length; i++) {
            if(maxAttack.attack < book[i].attack) {
                maxAttack = book[i];
            }
            if(maxHp.hp < book[i].hp) {
                maxHp = book[i];
            }
            if(book[i].hp > 100) {
                up100[i] = book[i];
            }
            totalHp += book[i].hp;

        }

        System.out.println("공격력 최강: " + maxAttack.name + "(" + maxAttack.attack + ")");
        System.out.println("체력 합계: " + totalHp);
        System.out.print("체력 100 이상: ");
        for (int i = 0; i < up100.length; i++) {
            if(up100[i] != null) {
                System.out.print(up100[i].name + " ");
            }
        }
        System.out.println();
        System.out.println("최고의 탱커: " + maxHp.name + "(" + maxHp.hp + ")");
    }
}
