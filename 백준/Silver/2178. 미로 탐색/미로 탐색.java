import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M;
    static boolean[][] visited; // 방문 체크 2차원 배열
    static int[][] graph; // 0과 1로만 이루어졌으므로 boolean

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        // 미로 데이터
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j) - '0'; // 문자열을 숫자로 변환
            }
        }

        bfs(0, 0);
        System.out.println(graph[N - 1][M - 1]); // (N,M) 좌표에 저장된 최단 거리값 출력
    }

    private static void bfs(int startR, int startC) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (graph[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;

                        graph[nr][nc] = graph[r][c] + 1;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

    }
}
