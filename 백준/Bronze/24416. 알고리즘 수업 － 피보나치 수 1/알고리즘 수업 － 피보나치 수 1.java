import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 수
// 2024/12/24 오후 9시
// DP
public class Main {
    static int count1, count2;
    static int f[] = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        count1 = 0;
        count2 = 0;
        fib(n);
        fibonacci(n);
        System.out.println(count1 + " " + count2);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1; //코드1
        } else return (fib(n - 1) + fib(n - 2));
    }
    static int fibonacci(int n) {
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            count2++;
            f[1] = f[i - 1] + f[i - 2]; // 코드2
        }
        return f[n];
    }
}
