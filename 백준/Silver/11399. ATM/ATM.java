import java.util.*;
import java.io.*;

// 2025/1/6 화요일 오후 3시 30분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer += sum[i];
        }
        System.out.println(answer);
    }
}
