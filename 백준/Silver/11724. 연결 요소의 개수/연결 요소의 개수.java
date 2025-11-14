import java.io.*;
import java.util.*;

// 2025/11/14 금요일 복습
public class Main {
    static int N, M;
    static int answer;
    static boolean[][] graph;
    static boolean[] visited;

    public static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[i][idx]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            graph[x][y] = true;
            graph[y][x] = true;
        }

            // dfs (중요!)
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++; // 새로운 연결 요소 발견 (DFS를 시작한 횟수 = 연결 요소의 개수)
            }
        }


        bw.write(String.valueOf(answer));

        bw.close();

    }
}
