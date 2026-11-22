// [제공] 인터넷 없이 Card와 Casino의 필수 기능을 확인하는 테스트
// 처음엔 빨간 줄이 생겨요. Card와 Casino를 명세대로 만들면 사라집니다.
public class CasinoTest {
    static Card c(String value) { return new Card(value, "HEARTS"); }

    public static void main(String[] args) {
        Check.ok("Card score: 7 → 7, KING → 13, ACE → 14",
                c("7").score() == 7 && c("KING").score() == 13 && c("ACE").score() == 14);
        Check.ok("Card toString: ♥KING", c("KING").toString().equals("♥KING"));

        Check.ok("필수 validBet: 칩 100, 베팅 50 → true", Casino.validBet(100, 50));
        Check.ok("필수 validBet: 칩 100, 베팅 150 → false", !Casino.validBet(100, 150));
        Check.ok("필수 validBet: 베팅 0 → false", !Casino.validBet(100, 0));

        Check.ok("필수 judgeHighLow: 5 → KING, H → 승(1)", Casino.judgeHighLow(c("5"), c("KING"), "H") == 1);
        Check.ok("필수 judgeHighLow: 5 → 3, L → 승(1)", Casino.judgeHighLow(c("5"), c("3"), "L") == 1);
        Check.ok("필수 judgeHighLow: 5 → 3, H → 패(-1)", Casino.judgeHighLow(c("5"), c("3"), "H") == -1);
        Check.ok("필수 judgeHighLow: 7 → 7 → 무(0)", Casino.judgeHighLow(c("7"), c("7"), "H") == 0);

        Check.ok("필수 settle: 100칩, 30 걸고 승 → 130", Casino.settle(100, 30, 1) == 130);
        Check.ok("필수 settle: 100칩, 30 걸고 패 → 70", Casino.settle(100, 30, -1) == 70);
        Check.ok("필수 settle: 무승부 → 100", Casino.settle(100, 30, 0) == 100);

        Check.summary();
    }
}
