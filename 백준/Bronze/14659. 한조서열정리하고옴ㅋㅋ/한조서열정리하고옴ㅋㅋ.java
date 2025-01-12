import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int maxCnt = 0; // 현재까지 최고의 활잡이가 처치한 수
        int cnt = 0; // 현재 활잡이가 처치한 수
        int nowH = A[0]; // 현재 활잡이 높이

        for (int i = 1; i < N; i++) {
            if (A[i] < nowH) {
                cnt++;
            } else {
                nowH = A[i];
                if (maxCnt < cnt) {
                    maxCnt = cnt;
                }
                cnt = 0;
            }
        }
        if (maxCnt < cnt) {
            maxCnt = cnt;
        }
        System.out.println(maxCnt);
    }
}
