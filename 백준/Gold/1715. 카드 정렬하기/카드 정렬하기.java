import java.io.*;
import java.util.*;

// 우선순위 큐
// 2025/11/25 화요일 오후 4시 10분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int sum = 0;

        // 추가 요소의 개수가 1개라면 비교 횟수가 존재하지 않는다.
        // 누적합 과정 중 pq의 개수가 1개가 남으면 비교가 끝난다.
        while ((pq.size()) > 1) {
            int a = pq.poll();
            int b = pq.poll();
            sum += (a + b);
            pq.add(a + b);
        }
        System.out.println(sum);
    }
}
