import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/09/15 월요일 오후 6시
// 재귀함수로 순열 구현
public class Main {

    static int N;
    static int[] A;
    static int[] B;
    static boolean[] V;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        V = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int index) {
        if (index == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(B[i] - B[i + 1]);
            }
            max = Math.max(max, sum);
        }
        for (int i = 0; i < N; i++) {
            if (!V[i]) {
                V[i] = true;
                B[index] = A[i];
                dfs(index + 1);
                V[i] = false;
            }
        }
    }
}
