import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/5/9 금요일
// 그리디
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = N / 5;
        N %= 5;

        if (N == 0) {
            System.out.println(count);
            return;
        }

        for (int i = 0; i < 3 && count - i >= 0; i++) {
            int temp = N + 5 * i;
            if (temp % 3 == 0) {
                count -= i;
                count += temp / 3;
                System.out.println(count);
                return;
            }
        }
        System.out.println(-1);
    }
}
