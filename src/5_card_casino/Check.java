// 테스트 도우미: 결과가 맞으면 [통과], 틀리면 [실패]를 찍는다
public class Check {
    static int pass = 0, fail = 0;

    static void ok(String name, boolean result) {
        if (result) { pass++; System.out.println("[통과] " + name); }
        else        { fail++; System.out.println("[실패] " + name); }
    }

    static void summary() {
        System.out.println("------------------------------");
        System.out.println("통과 " + pass + "개 / 실패 " + fail + "개");
    }
}
