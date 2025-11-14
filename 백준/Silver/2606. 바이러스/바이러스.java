import java.io.*;
import java.util.*;

// 복습
// 2025/11/14 금요일
public class Main {

    static int N, M;
    static int answer; // 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수
    static boolean[][] graph;
    static boolean[] visited;

    public static void dfs(int idx) {
        visited[idx] = true;
        answer += 1;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[i][idx]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // graph에 연결 정보 채우기
        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            // 그래프에 양방향으로 저장 (무방향 그래프)
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // dfs
        dfs(1); // 1번 컴퓨터부터 시작

        bw.write(String.valueOf(answer - 1)); // 1번 컴퓨터 제외

        bw.close();
    }
}
