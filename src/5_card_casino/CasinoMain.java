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

    }
}
