import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int n, m;
    static boolean[][] visited;
    static int[][] graph;
    static int count; // 그림의 개수
    static int maxWidth; // 최대 넓이
    static int curWidth; // 현재 탐색 중인 넓이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0; // 그림 개수
        maxWidth = 0; // 쵀대 넓이

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    count++;
                    curWidth = 0; // 넓이 초기화
                    dfs(i, j);
                    maxWidth = Math.max(maxWidth, curWidth);
                }
            }

        }
        System.out.println(count);
        System.out.println(maxWidth);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        curWidth++; // 방문할 때마다 넓이 1 증가

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (graph[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }

}
