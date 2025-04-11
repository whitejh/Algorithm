import java.io.*;
import java.util.*;

// 그리디
// 2025/4/11 금요일
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // N : 세로 길이
        int M = Integer.parseInt(st.nextToken()); // M : 가로 길이

        int answer = 0; // 방문할 수 있는 칸의 최댓값

        if (N == 1) {
            answer = 1;
        } else if (N == 2) {
            answer = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) { // M >= 3, M < 7 인 경우
                answer = Math.min(4, M);
            } else { // M >= 3, M >= 7 인 경우
                answer = M - 2;
            }
        }

        System.out.println(answer);
    }
}
