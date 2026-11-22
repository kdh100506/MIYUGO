package rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 전투 진행자: 누가 먼저 움직이고, 누구를 때리고, 언제 끝나는지 정해요.
// 여기서는 List<Character> 하나에 Warrior, Mage, Slime이 섞여 들어가요.
// 그런데도 c.act(...)를 부르면 각자 "자기 방식"대로 행동해요. 이것이 다형성!
public class Battle {

    // =====================================================================
    // [작성 5] 이번 라운드의 행동 순서를 정해요.
    //   - 살아 있는 캐릭터만 골라서
    //   - speed 높은 순, 같으면 name 가나다순으로 정렬한 새 리스트를 돌려주세요.
    //   - 원래 리스트(all)는 바꾸지 마세요.
    // =====================================================================
    static List<Character> turnOrder(List<Character> all) {
        List<Character> order = new ArrayList<>();
        for (Character c : all) {
            if (c.isAlive()) order.add(c);
        }
        order.sort((a, b) -> {
            if (a.speed != b.speed) return Integer.compare(b.speed, a.speed);
            return a.name.compareTo(b.name);
        });
        return order;
    }

    // =====================================================================
    // [작성 6] 공격할 대상을 골라요.
    //   - 살아 있는 적 중에서 hp가 가장 낮은 캐릭터 (약한 적부터 노리는 전략)
    //   - hp가 같으면 리스트에서 앞에 있는 캐릭터
    //   - 살아 있는 적이 없으면 null
    // =====================================================================
    static Character pickTarget(List<Character> enemies) {
        Character best = null;
        for (Character e : enemies) {
            if (!e.isAlive()) continue;
            if (best == null || e.hp < best.hp) best = e;
        }
        return best;
    }

    // =====================================================================
    // [작성 7] 팀이 전멸했는지 확인해요.  (한 명이라도 살아 있으면 false)
    // =====================================================================
    static boolean isDefeated(List<Character> team) {
        for (Character c : team) {
            if (c.isAlive()) return false;
        }
        return true;
    }

    // =====================================================================
    // [작성 8] 전투 전체를 진행해요. ★ 이 프로젝트의 핵심 ★
    //   - 결과로 "용사" / "몬스터" / "무승부" 중 하나를 돌려주세요.
    //   진행 규칙
    //     1. 라운드를 1부터 최대 30까지 반복 (30라운드가 지나도 안 끝나면 "무승부")
    //     2. 매 라운드 시작에 "--- 라운드 N ---" 출력
    //     3. turnOrder(용사 + 몬스터 전체)로 순서를 정하고, 그 순서대로 한 명씩:
    //        - 그 사이에 쓰러졌으면 건너뛰기
    //        - 내가 용사면 적은 몬스터 팀, 몬스터면 적은 용사 팀  (heroes.contains(c) 활용)
    //        - pickTarget으로 대상을 고르고, act 결과 메시지를 출력
    //        - 적 팀이 전멸했으면 그 즉시 승리 팀 이름을 돌려주기
    //   팁: 전체 리스트는  List<Character> all = new ArrayList<>(heroes); all.addAll(monsters);
    // =====================================================================
    static String fight(List<Character> heroes, List<Character> monsters, Random rand) {
        List<Character> all = new ArrayList<>(heroes);
        all.addAll(monsters);

        for (int round = 1; round <= 30; round++) {
            System.out.println("--- 라운드 " + round + " ---");
            for (Character c : turnOrder(all)) {
                if (!c.isAlive()) continue;
                boolean isHero = heroes.contains(c);
                List<Character> enemies = isHero ? monsters : heroes;
                Character target = pickTarget(enemies);
                if (target == null) continue;
                System.out.println("  " + c.act(target, rand));
                if (isDefeated(enemies)) {
                    return isHero ? "용사" : "몬스터";
                }
            }
        }
        return "무승부";
    }
}
