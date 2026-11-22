package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// [제공] 전투 시작!  모든 [작성]을 마치면 전투 로그가 출력돼요.
public class Main {
    public static void main(String[] args) {
        List<Character> heroes = new ArrayList<>();
        heroes.add(new Warrior("전사"));
        heroes.add(new Mage("마법사"));
        heroes.add(new Archer("궁수"));

        List<Character> monsters = new ArrayList<>();
        monsters.add(new Slime("미니슬라임", 40, 12, 2, 10));
        monsters.add(new Slime("슬라임", 80, 16, 4, 6));
        monsters.add(new Slime("킹슬라임", 210, 26, 10, 3));

        System.out.println("=== 용사 파티 vs 슬라임 군단 ===");
        String winner = Battle.fight(heroes, monsters, new Random());

        String result = winner.equals("무승부") ? "무승부!" : winner + " 승리!";
        System.out.println("\n=== 결과: " + result + " ===");
        for (Character c : heroes) System.out.println("  " + c.status());
        for (Character c : monsters) System.out.println("  " + c.status());
    }
}
