package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// [제공] 필수 미션 채점기.  실행: java RpgTest
public class RpgTest {

    // 테스트용 가짜 주사위: nextInt가 항상 정해진 값을 돌려줘요.
    static class FixedRandom extends Random {
        int value;
        FixedRandom(int value) { this.value = value; }
        @Override public int nextInt(int bound) { return value; }
    }

    // 맞기만 하는 허수아비 (방어 0)
    static Slime dummy() { return new Slime("허수아비", 1000, 0, 0, 0); }

    public static void main(String[] args) {
        Check.run("작성1 takeDamage", () -> {
            Slime s = new Slime("시험용", 50, 0, 5, 0);
            Check.ok("작성1 power 12, 방어 5 → 7 피해", s.takeDamage(12) == 7);
            Check.ok("작성1 hp 50 → 43", s.hp == 43);
            Check.ok("작성1 방어보다 약해도 최소 1", s.takeDamage(3) == 1);
            s.takeDamage(999);
            Check.ok("작성1 hp는 0 아래로 안 내려감", s.hp == 0);
        });

        Check.run("작성1-2 takeTrueDamage", () -> {
            Slime s = new Slime("시험용", 50, 0, 100, 0);
            Check.ok("작성1-2 방어 무시 20 피해", s.takeTrueDamage(20) == 20 && s.hp == 30);
            s.takeTrueDamage(999);
            Check.ok("작성1-2 hp는 0 아래로 안 내려감", s.hp == 0);
        });

        Check.run("작성2 Warrior", () -> {
            Warrior w = new Warrior("전사");
            Slime d = dummy();
            w.act(d, new Random());
            w.act(d, new Random());
            Check.ok("작성2 두 번 베기 → 36 피해", d.hp == 1000 - 36);
            String msg = w.act(d, new Random());
            Check.ok("작성2 세 번째는 강타(36) → 총 72", d.hp == 1000 - 72);
            Check.ok("작성2 메시지가 비어 있지 않음", msg != null && !msg.isEmpty());
        });

        Check.run("작성3 Mage", () -> {
            Mage m = new Mage("마법사");
            Slime tank = new Slime("철벽", 1000, 0, 50, 0);
            m.act(tank, new Random());
            Check.ok("작성3 파이어볼은 방어 무시 33 피해", tank.hp == 1000 - 33);
            Check.ok("작성3 MP 30 → 20", m.mp == 20);
            m.act(tank, new Random());
            m.act(tank, new Random());
            Check.ok("작성3 MP 0", m.mp == 0);
            Slime d = dummy();
            m.act(d, new Random());
            Check.ok("작성3 MP 부족 → 지팡이 11 피해", d.hp == 1000 - 11);
            Check.ok("작성3 지팡이 후 MP 5 회복", m.mp == 5);
        });

        Check.run("작성4 Archer", () -> {
            Archer a = new Archer("궁수");
            Slime d1 = dummy();
            a.act(d1, new FixedRandom(10));
            Check.ok("작성4 주사위 10 → 치명타 32 피해", d1.hp == 1000 - 32);
            Slime d2 = dummy();
            a.act(d2, new FixedRandom(50));
            Check.ok("작성4 주사위 50 → 일반 16 피해", d2.hp == 1000 - 16);
            Slime d3 = dummy();
            a.act(d3, new FixedRandom(30));
            Check.ok("작성4 주사위 30 → 일반 (30 미만만 치명타)", d3.hp == 1000 - 16);
        });

        Check.run("작성5 turnOrder", () -> {
            List<Character> all = new ArrayList<>();
            Warrior w = new Warrior("전사");      // speed 5
            Archer a = new Archer("궁수");        // speed 9
            Slime s1 = new Slime("나슬라임", 10, 1, 0, 5);
            Slime s2 = new Slime("다슬라임", 10, 1, 0, 7);
            s2.hp = 0;                              // 쓰러진 상태
            all.add(w); all.add(a); all.add(s1); all.add(s2);
            List<Character> order = Battle.turnOrder(all);
            Check.ok("작성5 쓰러진 캐릭터 제외 → 3명", order.size() == 3);
            Check.ok("작성5 가장 빠른 궁수가 먼저", order.size() == 3 && order.get(0) == a);
            Check.ok("작성5 속도 같으면 이름순 (나슬라임 → 전사)",
                    order.size() == 3 && order.get(1) == s1 && order.get(2) == w);
            Check.ok("작성5 원래 리스트는 그대로", all.size() == 4 && all.get(0) == w);
        });

        Check.run("작성6 pickTarget", () -> {
            Slime a = new Slime("A", 50, 1, 0, 1);
            Slime b = new Slime("B", 20, 1, 0, 1);
            Slime c = new Slime("C", 5, 1, 0, 1);
            Slime d = new Slime("D", 20, 1, 0, 1);
            c.hp = 0;
            Check.ok("작성6 살아 있는 적 중 hp 최저 → B", Battle.pickTarget(List.of(a, b, c, d)) == b);
            Check.ok("작성6 전부 쓰러지면 null", Battle.pickTarget(List.of(c)) == null);
        });

        Check.run("작성7 isDefeated", () -> {
            Slime a = new Slime("A", 10, 1, 0, 1);
            Slime b = new Slime("B", 10, 1, 0, 1);
            b.hp = 0;
            Check.ok("작성7 한 명 살아 있음 → false", !Battle.isDefeated(List.of(a, b)));
            a.hp = 0;
            Check.ok("작성7 모두 쓰러짐 → true", Battle.isDefeated(List.of(a, b)));
        });

        Check.run("작성8 fight", () -> {
            List<Character> heroes = new ArrayList<>(List.of(new Warrior("전사")));
            List<Character> weak = new ArrayList<>(List.of(new Slime("약한슬라임", 30, 5, 0, 1)));
            Check.ok("작성8 전사 vs 약한 슬라임 → 용사", Battle.fight(heroes, weak, new Random(1)).equals("용사"));

            List<Character> weakHero = new ArrayList<>(List.of(new Slime("겁쟁이", 10, 1, 0, 1)));
            List<Character> boss = new ArrayList<>(List.of(new Slime("마왕", 999, 50, 0, 9)));
            Check.ok("작성8 약한 용사 vs 마왕 → 몬스터", Battle.fight(weakHero, boss, new Random(1)).equals("몬스터"));

            List<Character> wall1 = new ArrayList<>(List.of(new Slime("벽1", 9999, 1, 100, 1)));
            List<Character> wall2 = new ArrayList<>(List.of(new Slime("벽2", 9999, 1, 100, 2)));
            Check.ok("작성8 30라운드 넘으면 무승부", Battle.fight(wall1, wall2, new Random(1)).equals("무승부"));
        });

        Check.summary();
    }
}
