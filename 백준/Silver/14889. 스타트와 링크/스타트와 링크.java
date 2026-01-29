import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2026/1/29/목
public class Main {

    static int N;
    static int[][] map;
    static boolean[] visited; // 팀을 나누기 위한 체크 배열
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0); // 1번 사람부터 시작, 현재까지 뽑은 인원 0명

        System.out.println(minDiff);
    }


     // idx : 조합을 뽑을 때 탐색을 시작할 인덱스
     // cnt : 현재까지 스타트 팀으로 선택된 인원 수
    private static void dfs(int idx, int cnt) {

        // 1. 종료 조건: N/2 명을 모두 뽑았을 때
        if (cnt == N / 2) {
            diff();
            return;
        }

        // 2. 재귀 조건 : 아직 N/2 명을 다 못 뽑았을 떄
        for (int i = idx; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;          // i번 사람을 스타트팀으로 선택
                dfs(i + 1, cnt + 1);  // 다음 사람 선택하러 이동
                visited[i] = false;        // 백트래킹
            }
        }
    }

    // 두 팀의 능력치 차이를 계산
    private static void diff() {
        int startTeamScore = 0;
        int linkTeamScore = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    startTeamScore += map[i][j];
                    startTeamScore += map[j][i];
                } else if(!visited[i] && !visited[j]) {
                    linkTeamScore += map[i][j];
                    linkTeamScore += map[j][i];
                }
            }
        }

        int diff = Math.abs(startTeamScore - linkTeamScore); // 투 팀의 능력치 차이 계산(절대값)
        if(diff == 0) {
            minDiff = 0;
            return;
        }

        minDiff = Math.min(diff, minDiff);
    }

}
