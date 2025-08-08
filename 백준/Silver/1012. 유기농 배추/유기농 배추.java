import java.io.*;
import java.util.*;

// 2025/8/7 목요일 오후 2시
public class Main {

    final static int MAX = 100;
    static boolean[][] map;
    static boolean[][] visited;
    static int T, N, M, K;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if (map[newY][newX] && !visited[newY][newX])
                dfs(newY, newX);

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            // 1. map 정보 반영
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y + 1][x + 1] = true;
            }

            // 2. dfs 수행
            int answer = 0;
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= M; j++) {

                    if (map[i][j] && !visited[i][j]) {
                        answer++; // 지렁이 소진
                        dfs(i, j);
                    }

                }
            }

            // 3. 출력
            bw.write(String.valueOf(answer) + "\n");
        }

        bw.close();
        br.close();
    }
}
