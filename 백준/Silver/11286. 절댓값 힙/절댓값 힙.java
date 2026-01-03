import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 속도 최적화를 위한 StringBuilder 사용

        int N = Integer.parseInt(br.readLine()); // 연산 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (Math.abs(a) == Math.abs(b)) return a - b; // 절댓값이 같다면 더 작은 값이 우선
            return Math.abs(a) - Math.abs(b); // 절댓값 기준 오름차순 정렬
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                pq.offer(x); // 힙에 추가
            } else {
                sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n"); // 최소 절댓값 출력
            }
        }

        System.out.print(sb); // 한 번에 출력하여 시간 최적화
    }
}
