import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백트래킹
public class Main {

    static int[] A;
    static int N; // 체스판의 크기
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        backtracking(0);
        System.out.println(cnt);
    }

    private static void backtracking(int row) {
        if (row == N) { // 정답 출력
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) { // 모든 경우의 수 탐색
            A[row] = i;
            if (check(row)) { // 가지치기 유효성 검사
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            if (A[i] == A[row]) {
                return false; // 일직선 공격
            }

            if (Math.abs(row - i) == Math.abs(A[row] - A[i])) {
                return false;
            }
        }
        return true;
    }
}
