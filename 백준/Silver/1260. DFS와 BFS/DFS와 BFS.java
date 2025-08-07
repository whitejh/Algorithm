import java.util.*;
import java.io.*;

// 2025/8/7 목요일 오후 2시 15분
public class Main {

    final static int MAX = 1000 + 1;
    static boolean[][] graph;
    static boolean[] visited;
    static ArrayList<Integer> queue; // bfs
    static int N, M, V;

    public static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[idx][i])
                dfs(i);
        }
    }

    public static void bfs() {
        queue = new ArrayList<>();
        visited = new boolean[MAX];

        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int idx = queue.remove(0);
            System.out.print(idx + " ");

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && graph[idx][i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 1. graph에 연결 정보 채우기
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs(재귀함수 호출)
        dfs(V);
        System.out.println();

        // 3. bfs (큐로 구현)
        bfs();
    }
}
