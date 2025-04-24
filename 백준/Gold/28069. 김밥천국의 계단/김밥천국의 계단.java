import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 계단 수
        int K = Integer.parseInt(st.nextToken()); // 최대 허용 단계 수

        int[] visited = new int[N + 1]; // 방문 배열
        Queue<Integer> q = new LinkedList<>();

        visited[0] = 1; // 0번 계단에서 시작
        q.offer(0);

        while (!q.isEmpty()) {
            int u = q.poll();

            // 1. 한 칸 올라가기
            int v_up = u + 1;
            if (v_up <= N && visited[v_up] == 0) {
                visited[v_up] = visited[u] + 1;
                q.offer(v_up);
            }

            // 2. 지팡이 두드리기 (순간이동)
            int v_staff = u + (u / 2);
            if (v_staff <= N && visited[v_staff] == 0) {
                visited[v_staff] = visited[u] + 1;
                q.offer(v_staff);
            }
        }

        // 결과 출력
        if (visited[N] != 0 && visited[N] - 1 <= K) {
            System.out.println("minigimbob");
        } else {
            System.out.println("water");
        }
    }
}
