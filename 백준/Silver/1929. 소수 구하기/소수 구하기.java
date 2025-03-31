import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/3/31 월요일 오후 5시 50분
// 항해 코딩테스트 스터디 Day1 - 자바/미들러
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        boolean[] isPrime = isPrime_check(N);

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i); // 소수인 경우, 출력
            }
        }
    }

    public static boolean[] isPrime_check(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true; // 모든 수를 소수로 가정
        }

        isPrime[0] = false; // 0은 소수가 아님
        isPrime[1] = false; // 1은 소수가 아님

        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) { // i가 소수인 경우
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false; // i의 배수들은 소수가 아님
                }
            }
        }

        return isPrime;
    }
}
