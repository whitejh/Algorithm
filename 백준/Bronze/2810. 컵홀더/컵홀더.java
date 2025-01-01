import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 컵홀더
// 2025/1/1 오후 11시 20분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int cCnt = 1; // 컵홀더 수 초기화

        for (int i = 0; i < n; ) {
            cCnt++; // 컵홀더 수 1씩 증가
            char now = arr[i];
            if (now == 'S') i++;
            else i += 2;
        }
        System.out.println(Math.min(cCnt, n)); // 컵홀더랑 사람의 개수 중 작은 거 출력
    }
}
