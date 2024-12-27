import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Yangjojang of The Year
// 2024/12/27 오후 2시 10분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int max = -1;
            String max_name = "";
            StringTokenizer st;

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String temp = st.nextToken();
                int temp_value = Integer.parseInt(st.nextToken());
                
                if (max < temp_value) {
                    max = temp_value; // 최댓값
                    max_name = temp;
                }
            }
            System.out.println(max_name);
        }
    }
}
