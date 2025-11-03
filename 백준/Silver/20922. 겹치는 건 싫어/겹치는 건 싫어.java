import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/11/3 월요일 오후 2시 55분
// 투포인터
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 9
        int K = Integer.parseInt(st.nextToken()); // 2
        int[] arr = new int[N];
        int[] count = new int[100001];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 3 2 5 5 6 4 4 5 7
        }

        // 투포인터
        int left = 0, right = 0;
        int max = 0; // 최댓값

        for (right = 0; right < N; right++) {
            int v = arr[right];
            count[v]++;
            while (count[v] > K) {
                count[arr[left]]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);
    }
}
