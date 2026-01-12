import java.io.*;


public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        DFS(0, N);
    }

    static void DFS(int num, int n) {
        if (n == 0) {
            System.out.println(num);
        }
        for (int i = 0; i < 10; i++) {
            int tmp = 10 * num + i;
            if (n > 0 && isPrime(tmp)) {
                DFS(tmp, n - 1);
            }
        }

    }

    static boolean isPrime(int num) {
        if (num < 2) return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
