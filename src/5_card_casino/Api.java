import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// 웹 API를 부르는 코드를 한곳에 모아 둔 도우미 클래스
public class Api {
    private static final HttpClient client = HttpClient.newHttpClient();

    // url로 GET 요청을 보내고, 응답 본문(JSON 글자)을 돌려준다
    public static String get(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            System.out.println("요청 실패! 상태 코드: " + response.statusCode());
        }
        return response.body();
    }
}
