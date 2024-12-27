import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int A[] = new int[10];
            for (int j = 0; j < 10; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            System.out.println(A[7]); // 오름차순 정렬해서 7번째 수 출력
        }
    }
}
