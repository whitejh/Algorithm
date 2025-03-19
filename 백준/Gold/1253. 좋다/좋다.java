import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2025/3/19 수요일 오후 11시 15분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 정렬

        // 투포인터 알고리즘
        int cnt = 0;
        for (int k = 0; k < N; k++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                if (start == k || end == k) {
                    if (start == k) start++;
                    else end--;
                } else {
                    int now = arr[start] + arr[end];
                    if(arr[k] == now) { // 찾은 경우
                        cnt++;
                        break;
                    } else if (now < arr[k]) { // 더 큰 숫자가 필요한 경우
                        start++;
                    } else { // 더 작은 숫자가 필요한 경우
                        end--;
                    }
                }
            }

        }
        System.out.println(cnt);
    }
}

