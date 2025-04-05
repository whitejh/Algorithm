import java.io.*;
import java.util.StringTokenizer;

// 투포인터
// 2025/4/5 토요일 오후 7시 30분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int pointer_A = 0;
        int pointer_B = 0;
        while (pointer_A < N && pointer_B < M) { // A,B 배열을 비교해서 작은 수 출력해가기
            if (A[pointer_A] > B[pointer_B]) { // A 배열에 있는 수가 B 배열에 있는 수보다 클 때
                bw.write(B[pointer_B] + " "); // B 배열에 있는 수 출력
                pointer_B++;
            } else {
                bw.write(A[pointer_A] + " ");
                pointer_A++;
            }
        }

        if (pointer_A == N) { // A 배열이 출력되었을 때, B 배열 나머지 출력하기
            for (int i = pointer_B; i < M; i++) {
                bw.write(B[i] + " ");
            }
        }

        if (pointer_B == M) { // B 배열이 출력되었을 때, A 배열 나머지 출력하기
            for (int i = pointer_A; i < N; i++) {
                bw.write(A[i] + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}
