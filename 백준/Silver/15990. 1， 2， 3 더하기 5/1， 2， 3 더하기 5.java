import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/9/29 월요일 오후 8시 25분
// DP
public class Main {

    static int MAX = 100000;
    static int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] D = new int[100000 + 1][4]; // 1,2,3
        int T = Integer.parseInt(st.nextToken());
        D[1][1] = 1;
        D[2][2] = 1;
        D[3][1] = 1; // 2 + 1 = 3
        D[3][2] = 1; // 1 + 2 = 3
        D[3][3] = 1; // 3

        for (int i = 4; i <= MAX; i++) {
            D[i][1] = (D[i - 1][2] + D[i - 1][3]) % MOD;
            D[i][2] = (D[i - 2][1] + D[i - 2][3]) % MOD;
            D[i][3] = (D[i - 3][1] + D[i - 3][2]) % MOD;
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int answer = ((D[n][1] + D[n][2]) % MOD + D[n][3]) % MOD;
            System.out.println(answer);
        }

        // mod 연산
        // D[10][3] = D[7][2] + D[7][1]
        // D[N][3] = D[N-3][1] + D[N-3][2]

    }
}
