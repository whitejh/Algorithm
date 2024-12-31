import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오르막길
// 2024/12/31 오후 5시 
// 2024년 마지막 백준 코테 공부
// 2025년도 화이팅!
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int temp = 0;
        for (int i = 1; i < N; i++) {
            if (A[i] > A[i - 1]) { // 오르막길
                temp += A[i] - A[i - 1];
                if (max < temp) { 
                    max = temp; // 가장 큰 오르막길 크기 최신화
                }
            } else { // 내리막길
                temp = 0; // 내리막길이면 초기화
            }
        }
        System.out.println(max);
    }
}
