package rpg;

// [제공] 테스트 도우미: 결과가 맞으면 [통과], 틀리면 [실패]를 찍어요. 고치지 않아도 돼요.
public class Check {
    static int pass = 0, fail = 0;

    static void ok(String name, boolean result) {
        if (result) { pass++; System.out.println("[통과] " + name); }
        else        { fail++; System.out.println("[실패] " + name); }
    }

    // 예외가 나도 테스트 전체가 멈추지 않도록 감싸 주는 도우미
    static void run(String name, Runnable test) {
        try {
            test.run();
        } catch (Exception e) {
            fail++;
            System.out.println("[실패] " + name + "  → 예외 발생: " + e);
        }
    }

    static void summary() {
        System.out.println("------------------------------");
        System.out.println("통과 " + pass + "개 / 실패 " + fail + "개");
        if (fail == 0) System.out.println("필수 미션 완료! 이제 도전 미션으로 가 보세요.");
    }
}
