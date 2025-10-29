import java.io.*;
import java.util.*;

// 2025/10/29 수요일 오전 10시 40분
// 그리디
// 우선순위 큐 (가장 작은 갑을 뽑아낼 수 있다.)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 3
        int m = Integer.parseInt(st.nextToken()); //1

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            long a = Integer.parseInt(st.nextToken());
            pq.add(a);
        }

        for (int j = 0; j < m; j++) {
            long b = pq.poll();
            long c = pq.poll();
            long sum = b + c;
            pq.add(sum);
            pq.add(sum);
        }

        long result = 0;
        for (long k : pq) {
            result += k;
        }

        System.out.println(result);

    }
}

// 주어진 데이터에서 가장 작은 수를 찾아서, 더한다음에 다시 넣어주기
