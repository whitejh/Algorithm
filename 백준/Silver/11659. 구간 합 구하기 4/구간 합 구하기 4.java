import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] input = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        input[1] = Integer.parseInt(st.nextToken());

        for (int i = 2; i <= N; i++) {
            input[i] = input[i - 1] + Integer.parseInt(st.nextToken());
        } // 누적합

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write((input[b] - input[a - 1] + "\n"));
        }
        bw.flush();
    }
}