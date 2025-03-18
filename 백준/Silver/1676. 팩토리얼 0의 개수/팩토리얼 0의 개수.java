import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/3/18 화요일 오후 5시 20분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        // 5의 배수 개수 세기 (5, 25, 125, ...)
        for (int i = 5; i <= N; i *= 5) {
            count += N / i;
        }

        System.out.println(count);
        
    }
}
