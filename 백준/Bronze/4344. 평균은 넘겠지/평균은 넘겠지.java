import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 5명
            int S = 0; // 전체 합
            int P[] = new int[N]; // 학생들 점수 담는 배열

            // N개의 점수를 받음
            for (int j = 0; j < N; j++) {
                P[j] = Integer.parseInt(st.nextToken());
                S += P[j];
            }

            double Avg = S / (double) N; // 평균 점수
            int over_Avg = 0; // 평균 점수 넘은 사람 수

            for (int k = 0; k < N; k++) {
                if (Avg < P[k])
                    over_Avg++;
            }
            System.out.println(Math.round(over_Avg / (double) N * 100 * 1000) / 1000.0 + "%");
        }
    }
}
