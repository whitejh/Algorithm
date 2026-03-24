import java.io.*;
import java.util.*;

// TreeSet은 처음 써봄
// 2026.3.24 화요일 오후 9시
// 풀이시간 30분
// 늘보코치 4주차 답참고가능 문제 - 해시
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<Integer> set = new TreeSet<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			set.remove(Integer.parseInt(st.nextToken()));
		}

		sb.append(set.size()).append("\n");
		for(int n : set) {
			sb.append(n).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}
