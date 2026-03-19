import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 2026.3.19 목요일 오후 5시 13분
// 풀이시간 30분
// 늘보코치 4주차 답참고가능 문제
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		HashMap<String, Integer> books = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String book = br.readLine();
			books.put(book, books.getOrDefault(book, 0) + 1);
		}

		String answer = "";
		int maxCount = 0;

		for (Map.Entry<String, Integer> entry : books.entrySet()) {
			String name = entry.getKey();
			int count = entry.getValue();

			// 1. 현재 책의 판매량이 더 많거나
			// 2. 판매량은 같은데 제목이 사전 순으로 더 앞선 경우 (compareTo < 0)
			if (count > maxCount) {
				maxCount = count;
				answer = name;
			} else if (count == maxCount) {
				if (name.compareTo(answer) < 0) {
					answer = name;
				}
			}
		}

		System.out.println(answer);

		// books.forEach((key, value) -> {
		// 	System.out.println(key);
		// 	System.out.println(value);
		// });
	}
}

// 첫째 줄에 가장 많이 팔린 책의 제목을 출력한다.
// 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.
