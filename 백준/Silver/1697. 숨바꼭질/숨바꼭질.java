
import java.io.*;
import java.util.*;

// 2025/8/18 월요일 오후 5시 15분
// BFS
public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001]; // i 위치에 몇 초만에 방문했나요?
        visited[N] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        // BFS 탐색
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == K) { // 지금 위치가 동생의 위치이면
                bw.write(String.valueOf(visited[now]));
                break;
            }
            int[] nextList = {now - 1, now + 1, now * 2};

            for (int next : nextList) {
                if (0 <= next && next <= 100000 && visited[next] == 0) { // next는 아직 방문하지 않은 노드
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }

            }
        }
        bw.close();
    }

}
