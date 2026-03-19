import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

// 2026.3.19 목요일 오후 4시 13분
// 풀이시간 30분
// 늘보코치 4주차 답참고 가능 문제
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		HashMap<Long, Integer> cards = new HashMap<>(); // 카드의 숫자가 크므로 Long 타입 사용

		int max = 0;
		long answer = 0;

		for (int i = 1; i <= N; i++) {
			long card = Long.parseLong(br.readLine());
			cards.put(card, cards.getOrDefault(card, 0) + 1);

			int current = cards.get(card);

			if (current > max) {
				max = cards.get(card);
				answer = card;
			} else if (current == max) {
				answer = Math.min(answer, card);
			}
		}

		bw.write(String.valueOf(answer));
		bw.close();

	}
}

// 해시에 key 에 수 저장 ,value 에 이 수가 나온 개수 저장
// getOrDefault(key, value) 함수 활용
// key가 존재할 경우, key에 매핑되는 value를 반환하고, key가 존재하지 않는다면 defalutValue를 반환한다.
