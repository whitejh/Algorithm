import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 성지키기
// 2024/12/31 오후 5시 10분
// 2024년 마지막 백준 코테 공부
// 2025년도 화이팅!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] rCnt = new int[n];
        int[] cCnt = new int[m];

        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray(); // 공백이 없어서 st.nexttoken() 안 씀
            for (int j = 0; j < m; j++) {
                char now = temp[j];
                if (now == 'X') {
                    rCnt[i]++;
                    cCnt[j]++;
                }
            }
        }
        int rResult = 0;
        int cResult = 0;
        for (int i = 0; i < n; i++) {
            if (rCnt[i] == 0) rResult++;
        }
        for (int j = 0; j < m; j++) {
            if (cCnt[j] == 0) cResult++;
        }
        System.out.println(Math.max(rResult, cResult)); // 둘 중 큰 거 출력
    }
}
