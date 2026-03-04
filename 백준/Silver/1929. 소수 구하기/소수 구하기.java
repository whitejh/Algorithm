import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2026.3.4 수요일 오후 3시 53분
// 9주차 시험 출제유형
// 실버3
// 풀이시간 20분
public class Main{

    public static boolean[] isPrime; // 소수를 체크하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isPrime = prime(N);

        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                System.out.println(i);
            }
        }
    }

    public static boolean[] prime(int N) {
        isPrime = new boolean[N + 1];

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true; // 모든 수를 소수로 가정
        }

        isPrime[0] = false;
        isPrime[1] = false;

        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
