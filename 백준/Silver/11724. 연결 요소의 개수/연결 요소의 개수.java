import java.io.*;
import java.util.*;

// DFS
// 2025.5.21 수요일 오전 12시 11분
public class Main {

    final static int MAX = 1000 + 10; // N이 가질 수 있는 최댓값
    static boolean[][] graph;
    static boolean[] visited; // 재방문 방지 배열
    static int N, M;
    static int answer;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int idx) {
        visited[idx] = true;
        for (int i = 1; i <= N ; i++) {
            if(!visited[i] && graph[idx][i])
                dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. graph에 연결 정보 채우기
        graph = new boolean[MAX][MAX];
        visited = new boolean[MAX];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = true;
            graph[v][u] = true;
        }

        // 2. dfs(재귀함수 호출)
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        // 3. 출력
        bw.write(String.valueOf(answer));

        bw.close();
        br.close();

    }

}
