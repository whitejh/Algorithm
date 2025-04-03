import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2025/4/3 목요일 오전 10시 40분
// 99클럽 코테스터디 Day4
public class Main {

    static int N; // 지도 크기
    static int[][] arr; // 지도 정보
    static boolean[][] visited; // 방문 여부 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        int maxHeight = 0; // 최대 높이 저장 변수
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // 지도 정보 입력
                maxHeight = Math.max(maxHeight, arr[i][j]); // 최대 높이 갱신
            }
        }

        int ans = 0; // 안전 영역의 최대 개수 저장 변수
        for (int h = 0; h <= maxHeight; h++) { // 가능한 모든 높이에 대해 반복
            visited = new boolean[N][N]; // 방문 배열 초기화
            ans = Math.max(ans, solve(h)); // 현재 높이에서의 안전 영역 개수 비교 후 최대값 저장
        }

        System.out.println(ans); // 결과 출력

    }

    static void bfs(int si, int sj, int h) {
        Queue<int[]> q = new LinkedList<>(); // BFS를 위한 큐
        q.add(new int[]{si, sj}); // 시작 지점 삽입
        visited[si][sj] = true; // 방문 처리

        int[] dRow = {-1, 1, 0, 0}; // 상, 하, 좌, 우 이동 배열
        int[] dCol = {0, 0, -1, 1};

        while (!q.isEmpty()) { // 큐가 빌 떄까지 반복
            int[] current = q.poll(); // 현재 위치 꺼내기
            int ci = current[0];
            int cj = current[1];

            for (int d = 0; d < 4; d++) { // 네 방향 탐색
                int ni = ci + dRow[d];
                int nj = cj + dCol[d];

                // 범위 내, 방문하지 않았으며, 물에 잠기지 않은 지역이라면 탐색 진행
                if ((ni >= 0 && ni < N) && (nj >= 0 && nj < N) && !visited[ni][nj] && arr[ni][nj] > h) {
                    q.add(new int[]{ni, nj}); // 큐에 추가
                    visited[ni][nj] = true; // 방문 처리
                }
            }
        }
    }

    // 특정 높이 h에서 안전 영역 개수 계산 함수
    static int solve(int h) {
        int cnt = 0; // 안전 영역 개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문하지 않았고, 물에 잠기지 않은 지역이면 BFS 실행
                if (!visited[i][j] && arr[i][j] > h) {
                    bfs(i, j, h);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
