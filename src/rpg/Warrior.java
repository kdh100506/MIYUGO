package rpg;

import java.util.Random;

// 전사: 튼튼하고, 세 번째 행동마다 강타를 날려요.
public class Warrior extends Character {

    int actionCount = 0;   // 지금까지 행동한 횟수

    // [제공] 생성자
    Warrior(String name) {
        super(name, 120, 18, 8, 5);
    }

    // =====================================================================
    // [작성 2] 전사의 행동
    //   - 행동할 때마다 actionCount를 1 늘려요.
    //   - actionCount가 3의 배수(3, 6, 9...)면 "강타": attack × 2 의 힘으로 takeDamage
    //   - 아니면 "베기": attack 의 힘으로 takeDamage
    //   - 메시지 예: "전사의 강타! 슬라임에게 32 피해"
    // =====================================================================
    @Override
    String act(Character target, Random rand) {
        actionCount++;
        if (actionCount % 3 == 0) {
            int dmg = target.takeDamage(attack * 2);
            return name + "의 강타! " + target.name + "에게 " + dmg + " 피해";
        }
        int dmg = target.takeDamage(attack);
        return name + "의 베기! " + target.name + "에게 " + dmg + " 피해";
    }
}
