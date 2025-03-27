import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/3/27 목요일 오전 11시 25분
// 이진수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (X > 0) {
            if (X % 2 == 1) {
                cnt++;
            }
            X = X / 2;
        }
        System.out.println(cnt);
    }
}
