// [제공] Deck of Cards API와 대화하는 클래스 (번역 담당) — 고치지 않아도 돼요
// 서버가 덱 번호를 기억하므로, 이 클래스도 객체로 만들어 deckId를 기억한다
public class DeckApi {
    String deckId;

    // 새 덱을 섞어서 받는다
    DeckApi() throws Exception {
        String json = Api.get("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");
        deckId = JsonUtil.getValue(json, "deck_id");
    }

    // count장 뽑아서 Card 배열로
    Card[] draw(int count) throws Exception {
        String json = Api.get("https://deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=" + count);
        Card[] cards = new Card[count];
        int from = 0;
        for (int i = 0; i < count; i++) {
            from = json.indexOf("\"value\":", from);
            cards[i] = new Card(JsonUtil.getValue(json, "value", from),
                                JsonUtil.getValue(json, "suit", from));
            from++;
        }
        return cards;
    }
}
