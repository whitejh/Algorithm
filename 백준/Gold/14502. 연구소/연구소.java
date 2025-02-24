import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 골드 4 - BFS
// 2025/2/24 월요일 오후 6시
// 어렵다. 어려워. 반복해서 풀어보자
public class Main {

    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static int[][] map;
    private static int N, M;
    private static ArrayDeque<Node> virus = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.addLast(new Node(i, j)); // 바이러스 있는 노드
                }
            }
        }

        ArrayDeque<Node> block = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue;
            block.addLast(new Node(i / M, i % M));

            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) continue;
                block.addLast(new Node(j / M, j % M));

                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue;
                    block.addLast(new Node(k / M, k % M));
                    BFS(block);
                    answer = Math.max(answer, BFS(block));
                    block.pollLast();
                }
                block.pollLast();
            }
            block.pollLast();
        }

        System.out.println(answer); // 정답
    }

    private static int BFS(ArrayDeque<Node> block) {
        // 새로 새울 벽을 매개변수로 받는다. 새로 새울 벽마다 BFS를 돌려야하기 때문

        int[][] map2 = new int[N][M];

        // 기존 맵은 복사해둔다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map2[i][j] = map[i][j];
            }
        }

        // 벽 3개를 세운다.
        for (Node node : block) {
            map2[node.r][node.c] = 1;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();

        for (Node node : virus) {
            queue.addLast(node);
        }

        while (!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for (int i = 0; i < 4; i++) { // 상하좌우 탐색
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                // 예외 처리
                if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                    continue; // 맵 밖으로 나가는 경우

                if (map2[nr][nc] == 1)
                    continue; //벽인 경우

                if (map2[nr][nc] == 0) {
                    map2[nr][nc] = 2; // 바이러스에 감염 시킴
                    queue.addLast(new Node(nr, nc));
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map2[i][j] == 0)
                    cnt++;
            }
        }

        return cnt;
    }
}
