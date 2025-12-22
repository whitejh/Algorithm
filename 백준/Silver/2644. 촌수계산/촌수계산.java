import java.util.*;
import java.io.*;

// 2025/12/22 월요일 오전 10시
public class Main {

    static boolean[][] graph; // 인접행렬
    static boolean[] visited;
    static int N, M;
    static int start, end;
    static int answer;

    public static void dfs(int idx, int count) {
        visited[idx] = true;
        if (idx == end) {
            answer = count;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[idx][i]){
                dfs(i, count + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 전체 사람의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()); // 촌수 계산 사람1
        end = Integer.parseInt(st.nextToken()); // 촌수 계산 사람2
        M = Integer.parseInt(br.readLine()); // 부모 자식들간의 관계 개수

        // 1. graph에 연결 정보 채우기
        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        answer = -1;

        // 2. dfs(재귀함수 호출)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }

        // 3. 출력
        dfs(start, 0);

        bw.write(String.valueOf(answer));

        bw.close();
        br.close();
    }
}