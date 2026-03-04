import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isPrime = prime(N);

        // 출력을 모으기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append("\n"); // 결과 저장
            }
        }
        // 마지막에 한 번만 출력!
        System.out.print(sb);
    }

    public static boolean[] prime(int N) {
        isPrime = new boolean[N + 1];

        // 0부터 N까지 초기화할 때 Arrays.fill을 쓰면 코드가 더 간결해집니다.
        // java.util.Arrays 임포트 필요
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }

        // 0과 1은 소수가 아님 (기본값이 false라면 생략 가능)
        // isPrime[0] = false; isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                // i*i가 int 범위를 넘을 수 있지만 N이 100만이라서 i*i는 안전합니다.
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}