import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/7/21 월요일 오후 8시 30분
// DP 경우의 수 구할때도 쓴다.
public class Main {

    static int A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(POW(A, B) % C);
    }

    private static long POW(long a, long b) {

        if (b == 1) {
            return a % C;
        }

        long half = POW(a, b / 2);
        long result = half * half % C;
        if (b % 2 == 1) {
            result = result * a % C;
        }

        return result;

    }
}
