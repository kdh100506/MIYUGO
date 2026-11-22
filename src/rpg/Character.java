package rpg;

import java.util.Random;

// 모든 캐릭터(용사, 몬스터)의 "부모" 클래스예요.
// abstract(추상) 클래스라서 new Character(...)로 직접 만들 수는 없고,
// 반드시 Warrior, Slime 처럼 자식 클래스를 만들어(extends) 써야 해요.
//
// 왜 이렇게 할까?  모든 캐릭터에게 공통인 것(체력, 공격력, 피해 받기)은 여기 한 번만 쓰고,
// 직업마다 다른 것(행동 방식 act)만 자식이 각자 정하게 하기 위해서예요.
public abstract class Character {

    // ===== [제공] 공통 필드 =====
    String name;
    int maxHp;
    int hp;
    int attack;    // 공격력
    int defense;   // 방어력: 받는 피해를 이만큼 줄여 줘요
    int speed;     // 속도: 높을수록 먼저 행동해요

    // ===== [제공] 생성자 =====
    Character(String name, int hp, int attack, int defense, int speed) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    // ===== [제공] =====
    boolean isAlive() {
        return hp > 0;
    }

    // ===== [제공] 예: 전사 [95/120] =====
    String status() {
        return name + " [" + hp + "/" + maxHp + "]";
    }

    // =====================================================================
    // [작성 1] 일반 피해를 받아요.
    //   - 실제 피해 = power - defense    단, 최소 1  (Math.max 활용)
    //   - hp를 실제 피해만큼 줄이되 0 아래로는 내려가지 않게
    //   - 실제로 받은 피해를 돌려주세요.
    //   예: defense 5인 캐릭터가 power 12를 받으면 → 7 피해
    // =====================================================================
    int takeDamage(int power) {
        int actual = Math.max(1, power - defense);
        hp = Math.max(0, hp - actual);
        return actual;
    }

    // =====================================================================
    // [작성 1-2] 방어를 무시하는 피해를 받아요. (마법 공격용)
    //   - 방어력을 빼지 않고 amount 그대로 hp를 줄여요. (0 아래로는 X)
    //   - 실제로 받은 피해(amount)를 돌려주세요.
    // =====================================================================
    int takeTrueDamage(int amount) {
        hp = Math.max(0, hp - amount);
        return amount;
    }

    // ===== [제공] 자식 클래스가 "반드시" 만들어야 하는 메서드 =====
    // target을 공격하고, 무슨 일이 있었는지 한 줄 메시지로 돌려줘요.
    // rand는 확률(치명타 등)이 필요할 때 쓰세요. (테스트에서 결과를 고정하려고 밖에서 받아요)
    abstract String act(Character target, Random rand);
}
