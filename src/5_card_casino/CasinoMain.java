import java.util.Scanner;

// [작성] 카지노 메뉴
//
// ▶ 필수 흐름
//   1. DeckApi deck = new DeckApi();   (새 덱을 섞어서 받아요)
//   2. 칩 100개로 시작
//   3. 메뉴 반복: 1.하이로우  0.종료
//      - 하이로우: 베팅 입력 → validBet 확인 → deck.draw(1)[0]로 현재 카드 → H/L 입력
//                  → 다음 카드 → judgeHighLow → settle → 결과 출력
//
// ▶ 도전·심화를 했다면 메뉴에 2.블랙잭, 3.명예의 전당 추가 (블랙잭 진행 순서는 가이드북 참고)
public class CasinoMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        DeckApi deck = new DeckApi();
        int chips = 100;

        while (true) {
            System.out.println("\n=== 카지노 (칩 " + chips + "개) ===");
            System.out.println("1. 하이로우");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            String menu = sc.nextLine().trim();

            if (menu.equals("0")) {
                System.out.println("게임을 종료합니다. 최종 칩: " + chips + "개");
                break;
            }
            if (!menu.equals("1")) {
                System.out.println("0 또는 1을 입력하세요.");
                continue;
            }
            if (chips <= 0) {
                System.out.println("칩이 없어요. 게임을 종료합니다.");
                break;
            }

            System.out.print("베팅할 칩 수: ");
            int bet;
            try {
                bet = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("숫자로 입력하세요.");
                continue;
            }
            if (!Casino.validBet(chips, bet)) {
                System.out.println("베팅은 1 이상, 가진 칩(" + chips + ") 이하여야 해요.");
                continue;
            }

            Card current = deck.draw(1)[0];
            System.out.println("현재 카드: " + current);
            System.out.print("다음 카드는 높을까요(H) 낮을까요(L)? ");
            String guess = sc.nextLine().trim().toUpperCase();
            if (!guess.equals("H") && !guess.equals("L")) {
                System.out.println("H 또는 L을 입력하세요.");
                continue;
            }

            Card next = deck.draw(1)[0];
            System.out.println("다음 카드: " + next);
            int result = Casino.judgeHighLow(current, next, guess);
            chips = Casino.settle(chips, bet, result);

            if (result > 0) System.out.println("승리! +" + bet);
            else if (result < 0) System.out.println("패배... -" + bet);
            else System.out.println("무승부! 칩은 그대로예요.");
        }
    }
}
