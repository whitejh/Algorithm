import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/5/14 수요일
// 브루트포스
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int x = 0; x <= N - 8; x++) { // 체스판이 시작될 수 있는 x,y 전체 탐색
            for (int y = 0; y <= M - 8; y++) { // 오른쪽 아래
                int w_cnt = 0;
                for (int i = x; i < x + 8; i++) { // 체스판 탐색하면서 검토
                    for (int j = y; j < y + 8; j++) {
                        if ((i + j) % 2 == 1 && map[i][j] == 'W') {
                            w_cnt++;
                        } else if ((i + j) % 2 == 0 && map[i][j] == 'B') {
                            w_cnt++;
                        }
                    }
                }
                min = Math.min(min, Math.min(w_cnt, 64 - w_cnt));
            }
        }
        System.out.println(min);
    }
}
