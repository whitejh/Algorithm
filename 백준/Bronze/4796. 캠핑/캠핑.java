import java.io.*;
import java.util.StringTokenizer;

// 캠핑
// 2024/12/25 오후 10시
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            // 5 8 20 => Case 1: 14
            int n1 = c / b;
            int n2 = c % b;
            cnt++;

            int answer = (a * n1) + Math.min(n2, a);
            bw.write("Case " + cnt + ": " + answer + "\n");
        }
        bw.flush();
        bw.close();
    }
}
