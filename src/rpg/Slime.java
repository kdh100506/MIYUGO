package rpg;

import java.util.Random;

// [제공] ★ 상속 예시 ★  Warrior, Mage, Archer를 만들 때 이 파일을 참고하세요.
// 슬라임은 특별한 기술 없이 기본 공격만 해요.
public class Slime extends Character {          // extends: Character의 모든 것을 물려받기

    Slime(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed);  // super(...): 부모 생성자 호출
    }

    @Override                                     // 부모의 act를 "내 방식"으로 다시 정의
    String act(Character target, Random rand) {
        int dmg = target.takeDamage(attack);
        return name + "의 몸통 박치기! " + target.name + "에게 " + dmg + " 피해";
    }
}
