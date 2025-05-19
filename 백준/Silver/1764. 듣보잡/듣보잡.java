import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2025.5.19 월 오후 1시 23분
// 듣보잡
// 투포인터 (N^2 을 2N으로 바꾸기 위해)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] A = new String[N];
        String[] B = new String[M];

        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        for (int j = 0; j < M; j++) {
            B[j] = br.readLine();
        }

        // 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        // 투포인터 알고리즘 적용
        int A_index = 0;
        int B_index = 0;
        int count = 0;

        while (A_index != N && B_index != M) {
            String A_str = A[A_index];
            String B_str = B[B_index];

            // 2개의 이름이 같으면?
            if (A_str.equals(B_str)) {
                count++;
                sb.append(A_str + "\n");
                A_index++;
                B_index++;
            } else if (A_str.compareTo(B_str) < 0) { // 사전순으로 A가 더 작을 때
                A_index++;
            } else {
                B_index++;
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}

