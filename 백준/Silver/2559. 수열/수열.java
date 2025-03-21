import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/3/21 금요일 오후 4시 35분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0; i < K; i++) {
            sum += nums[i];
        }

        int answer = sum;
        int left = 0;
        int right = K;

        while (right < N) {
            sum += nums[right];
            sum -= nums[left];
            right += 1;
            left += 1;
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);

    }
}

// 2중 for문으로 풀면 시간초과 (최악의 케이스 5만(10만의 절반) * 5만 = 25억)
// 2중 for문 안 돌리고 슬라이딩 윈도우로 풀면 O(N)

