import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2025/10/23 목요일 오후 4시 20분
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지방의 수
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int right = -1; // 예산의 최대 금액

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }
        int M = Integer.parseInt(br.readLine()); // 총 예산

        while (left <= right) {
            int mid = (left + right) / 2;
            int budget = 0;

            for (int i = 0; i < N; i++) {
                budget += Math.min(arr[i], mid);
            }
            if (budget <= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}
