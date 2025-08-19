import java.util.*;
import java.io.*;

class Main {
    final static int MAX = 50 + 10;
    static boolean map[][];
    static boolean visited[][];
    static int dirY[] = { -1, -1, 0, 1, 1, 1, 0, -1};
    static int dirX[] = { 0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M;

    static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 8; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];
            if (map[newY][newX] && !visited[newY][newX])
                dfs(newY, newX);
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            map = new boolean[MAX][MAX];
            visited = new boolean[MAX][MAX];

            // 1. map 정보 반영
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= M; j++)
                    map[i][j] = (Integer.parseInt(st.nextToken()) == 1);
            }

            // 2. dfs 수행
            int answer = 0;
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= M; j++)
                    if (map[i][j] && !visited[i][j]) {
                        dfs(i, j);
                        answer++;
                    }
            
            // 3. 출력
            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}