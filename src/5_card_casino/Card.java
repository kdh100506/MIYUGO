// [작성] 카드 한 장 (데이터 담당)
// ▶ 아래 명세(약속)대로 만드세요. 제공된 DeckApi가 이 약속을 그대로 써요.
//
// 필드
//   String value   "2"~"10", "JACK", "QUEEN", "KING", "ACE"
//   String suit    "HEARTS", "SPADES", "DIAMONDS", "CLUBS"
//
// 생성자  Card(String value, String suit)
//
// 메서드
//   int score()                하이로우용 숫자: ACE 14, KING 13, QUEEN 12, JACK 11, 나머지는 숫자 그대로
//   public String toString()   예: ♥KING  (HEARTS ♥, DIAMONDS ◆, SPADES ♠, CLUBS ♣)
//                              이 메서드가 있으면 System.out.println(card) 만으로 예쁘게 찍혀요
public class Card {
    String value;
    String suit;

    Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    int score() {
        switch (value) {
            case "ACE":   return 14;
            case "KING":  return 13;
            case "QUEEN": return 12;
            case "JACK":  return 11;
            default:      return Integer.parseInt(value);
        }
    }

    @Override
    public String toString() {
        String symbol;
        switch (suit) {
            case "HEARTS":   symbol = "♥"; break;
            case "DIAMONDS": symbol = "◆"; break;
            case "SPADES":   symbol = "♠"; break;
            case "CLUBS":    symbol = "♣"; break;
            default:         symbol = "?";
        }
        return symbol + value;
    }
}
