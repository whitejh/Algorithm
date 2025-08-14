import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/8/14 목요일
// DP
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] A = new int[N+1][2];
            int[][] D = new int[N+1][2];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[j][i] = Integer.parseInt(st.nextToken());
                }
            }
            D[0][0] = A[0][0];
            D[0][1] = A[0][1];
            D[1][0] = D[0][1] + A[1][0];
            D[1][1] = D[0][0] + A[1][1];

            for (int i = 2; i < N; i++) {
                D[i][0] = Math.max(D[i-1][1], D[i-2][1]) + A[i][0];
                D[i][1] = Math.max(D[i-1][0], D[i-2][0]) + A[i][1];
            }

            System.out.println(Math.max(D[N-1][0], D[N-1][1]));
        }
    }
}
