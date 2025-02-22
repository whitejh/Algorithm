import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덩치
// 2025/1/23 오후 10시
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int D[][] = new int[N][2]; // 각 사람의 몸무게와 키를 담는 2차원 배열
        int S[] = new int[N]; // 등수 담는 배열

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D[i][0] = Integer.parseInt(st.nextToken());
            D[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int now_m = D[i][0];
            int now_h = D[i][1];
            int count = 1; // 1등부터 시작

            for (int j = 0; j < N; j++) {
                if (i != j) { // 내 자신 빼기
                    if (now_m < D[j][0] && now_h < D[j][1]) {
                        count++;
                    }
                }
            }
            S[i] = count;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(S[i] + " ");
        }


    }
}
