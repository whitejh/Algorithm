import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 실버3
// 2025년 12월 12일 금요일 오전 12시
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] data = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[0] = 0; // 시작점

        if (n == 1) {
            dp[1] = data[1];
        } else if (n == 2) {
            dp[2] = data[1] + data[2];
        } else {
            dp[1] = data[1];
            dp[2] = data[1] + data[2];
            dp[3] = Math.max(dp[1] + data[3], dp[0] + data[2] + data[3]);

            // 1. 두 계단 + 한 계단 오른 경우
            // 2. 한 번에 두 계단 오른 경우
            for (int i = 4; i <= n; i++) {
                dp[i] = Math.max(dp[i - 2] + data[i], dp[i - 3] + data[i - 1] + data[i]);
            }
        }
        System.out.println(dp[n]);
    }
}
// 1. 한 계단 혹은 두 계단씩 오름
// 2. 연속된 세 개의 계단 x (시작점 포함 x, 시작점 0)
// 3. 마지막 계단 필수
