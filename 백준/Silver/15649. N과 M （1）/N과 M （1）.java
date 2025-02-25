import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/2/24 월요일 오후 11시
// 백트래킹
// 실버 3
public class Main {

    private static boolean[] used;
    private static int N, M;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        used = new boolean[N + 1];

        backtrack(0, "");
        
         System.out.println(sb);
    }

    private static void backtrack(int cnt, String s) {
        if (cnt == M) {
            sb.append(s.trim() + "\n"); // trim()은 문자열의 앞뒤 공백 제거
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(cnt + 1, s + " " + i);
                used[i] = false;
            }
        }
    }
}
