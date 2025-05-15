import java.io.*;
import java.util.StringTokenizer;

// 2025/5/15 목요일
// 이분탐색
public class Main {
    public static void main(String[] args) throws IOException {
        // 카운팅 소트, 해시, value -> index 다루기
        int[] arr = new int[20000001]; // arr[index] = index = 10000000의 value를 가진 숫자가 몇 개인지 나타내주는 배열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken()); // 현재값
            arr[now + 10000000]++; // value -> index로 표현
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int now = Integer.parseInt(st.nextToken()); // 현재값
            bw.write(arr[now + 10000000] + " ");
        }
        bw.flush();
    }
}
