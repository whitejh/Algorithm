import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 2026.3.4 수요일 오후 12시 - 풀이시간 30분
// 실버4
// 늘보코치 2주차 큐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                int temp = queue.poll();
                queue.offer(temp);
            }
            sb.append(queue.poll()).append(", ");
        }

        // 마지막 남은 하나 처리
        sb.append(queue.poll()).append(">");

        System.out.println(sb.toString());
    }
}
