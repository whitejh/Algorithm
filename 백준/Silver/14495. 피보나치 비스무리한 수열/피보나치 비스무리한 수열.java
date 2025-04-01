import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/4/1 화요일 오후 11시 43분
// 99클럽 코딩스터디 Day2
public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1]; // n까지 저장할 배열
        System.out.println(pivo(n));
    }

    public static long pivo(int n) {
        if (n == 1 || n == 2 || n == 3) return 1; // 기본값

        if (dp[n] != 0) return dp[n]; // 이미 계산된 값이면 반환

        return dp[n] = pivo(n - 1) + pivo(n - 3); // 값 저장 후 반환
    }
}
