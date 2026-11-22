package rpg;

import java.util.Random;

// 궁수: 가장 빠르고, 30% 확률로 치명타(2배)가 터져요.
public class Archer extends Character {

    // [제공] 생성자
    Archer(String name) {
        super(name, 85, 16, 5, 9);
    }

    // =====================================================================
    // [작성 4] 궁수의 행동
    //   - rand.nextInt(100) 은 0 ~ 99 중 하나를 뽑아요. 이 값이 30 미만이면 치명타 (30% 확률)
    //   - 치명타: attack × 2 의 힘으로 takeDamage,  아니면 attack 의 힘으로 takeDamage
    //   - rand.nextInt(100)은 행동마다 "딱 한 번만" 부르세요. (테스트가 그 값을 고정해요)
    //   - 메시지 예: "궁수의 치명타 화살!! 슬라임에게 28 피해"
    // =====================================================================
    @Override
    String act(Character target, Random rand) {
        int roll = rand.nextInt(100);
        if (roll < 30) {
            int dmg = target.takeDamage(attack * 2);
            return name + "의 치명타 화살!! " + target.name + "에게 " + dmg + " 피해";
        }
        int dmg = target.takeDamage(attack);
        return name + "의 화살! " + target.name + "에게 " + dmg + " 피해";
    }
}
