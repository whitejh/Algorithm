import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2025/2/22 토요일 오후 9시 40분
// 배열에다가 1 넣는 것을 색칠한다고 생각!
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] D = new int[101][101];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) { // N개의 색종이 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    D[j][k] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (D[i][j] == 1) sum++;
            }
        }
        System.out.println(sum);
    }
}
