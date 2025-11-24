import java.io.*;
import java.util.*;

// 우선순위 큐
// 2025/11/24 월요일 오후 2시 35분
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // N번째 큰 수 : 내림차순 정렬
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num = Integer.parseInt(st.nextToken());
                pq.add(num);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}
