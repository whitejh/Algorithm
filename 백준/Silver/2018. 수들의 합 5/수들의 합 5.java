import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/3/15 토요일 오후 12시 15분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 15

        // 투 포인터
        int count = 1;
        int left = 1;
        int right = 1;
        int sum = 1;

        while (right != N) {
            if (sum == N) {
                count++;
                right++;
                sum += right;
            } else if (sum > N) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }
        System.out.println(count);
    }
}
