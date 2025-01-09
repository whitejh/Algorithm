import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0의 개수
// 2025/1/9 오후 4시 30분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count = 0;

            for (int j = N; j <= M; j++) {
                char[] temp = String.valueOf(j).toCharArray();

                for (int k = 0; k < temp.length; k++) {
                    if (temp[k] == '0') count++;
                }
            }
            System.out.println(count);
        }
    }
}
