// [작성] 카지노 규칙 로직
// 결과는 숫자로 약속해요: 승 1, 무 0, 패 -1
//
// ▶ 필수 — 아래 선언 그대로 만드세요 (CasinoTest가 이 이름으로 채점해요)
//   static boolean validBet(int chips, int bet)                     0보다 크고 가진 칩 이하면 true
//   static int     judgeHighLow(Card current, Card next, String guess)
//                    같은 숫자면 0, "H"인데 더 높거나 "L"인데 더 낮으면 1, 나머지 -1
//   static int     settle(int chips, int bet, int result)          정산 후 칩 (이기면 +bet, 지면 -bet, 비기면 그대로)
//
// ▶ 도전·심화 — 이름, 받는 것, 돌려주는 것을 직접 설계하세요 (설계 시트에 먼저 적기)
//   도전 1  블랙잭 손패 점수: 숫자는 그대로, J·Q·K는 10, ACE는 11
//           단 21을 넘으면 ACE를 1로(10 빼기), ACE가 남아 있는 동안 반복
//   도전 2  블랙잭 승패: 내가 21 초과면 패, 딜러가 21 초과면 승, 아니면 큰 쪽 승 (같으면 무)
//   심화    명예의 전당: 높은 순으로 정렬된 기록 3개에 새 기록을 알맞은 자리에 끼워 넣기
public class Casino {

}
