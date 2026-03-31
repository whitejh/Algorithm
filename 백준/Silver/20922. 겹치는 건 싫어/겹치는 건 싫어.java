import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2026.3.31 화요일 오후 4시 46분
// 풀이시간 40분
// 늘보코치 13주차 기출 유사 문제
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] count = new int[100001]; // k개 겹치는 거
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 투포인터
		int left = 0, right = 0;
		int max = 0; // 최댓값

		for (right = 0; right < N; right++) {
			int v = arr[right]; // 현재값
			count[v]++;

			while (count[v] > K) {
				count[arr[left]]--;
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		System.out.println(max);
	}
}
