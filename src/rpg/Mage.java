package rpg;

import java.util.Random;

// 마법사: 약하지만 방어를 무시하는 파이어볼을 쏴요. 대신 마나(mp)가 필요해요.
public class Mage extends Character {

    int mp = 30;   // 마나

    // [제공] 생성자
    Mage(String name) {
        super(name, 70, 22, 3, 7);
    }

    // =====================================================================
    // [작성 3] 마법사의 행동
    //   - mp가 10 이상이면 "파이어볼": mp를 10 쓰고, attack × 3 / 2 만큼 takeTrueDamage (방어 무시)
    //   - mp가 모자라면 "지팡이 치기": attack / 2 의 힘으로 takeDamage 하고, mp를 5 회복
    //   - 메시지 예: "마법사의 파이어볼! 킹슬라임에게 33 피해 (MP 20)"
    // =====================================================================
    @Override
    String act(Character target, Random rand) {
        if (mp >= 10) {
            mp -= 10;
            int dmg = target.takeTrueDamage(attack * 3 / 2);
            return name + "의 파이어볼! " + target.name + "에게 " + dmg + " 피해 (MP " + mp + ")";
        }
        int dmg = target.takeDamage(attack / 2);
        mp += 5;
        return name + "의 지팡이 치기! " + target.name + "에게 " + dmg + " 피해 (MP " + mp + ")";
    }
}
