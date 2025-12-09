import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

// 2025/12/9 화요일 오후 12시 30분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] D = new int[N + 1];
        D[0] = 0;
        D[1] = 0;

        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1; // 1 빼는 연산
            if (i % 2 == 0) D[i] = min(D[i], D[i / 2] + 1);
            if (i % 3 == 0) D[i] = min(D[i], D[i / 3] + 1);
        }

        System.out.println(D[N]);

        // D[i] : i에서 1로 만드는데 걸리는 회소 연산 횟수
    }
}
