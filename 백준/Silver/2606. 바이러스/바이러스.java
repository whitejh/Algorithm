import java.io.*;
import java.util.*;

// 2025/5/19 월요일 오후 2시 30분
public class Main {

    static boolean[][] graph;
    static boolean[] visited; // 재방문 방지 배열
    static int N, M;
    static int answer;

    public static void dfs(int idx) {
        visited[idx] = true;
        answer++; // dfs 호출되는 횟수만큼 몇개의 컴퓨터가 연결되어있는지 의미

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[idx][i]) {
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

        // 1. graph에 연결 정보 채우기
        int x, y;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 2. dfs(재귀함수) 호출
        dfs(1);


        // 3. 출력
        bw.write(String.valueOf(answer - 1)); // 1번 컴퓨터를 제외한 값이므로 1 뺌

        br.close();
        bw.close();
    }
}
