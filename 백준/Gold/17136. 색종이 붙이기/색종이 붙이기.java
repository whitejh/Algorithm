import java.util.*;
import java.io.*;

// 골드2
// 1/25 일요일 스터디
public class Main {

    static int[][] map = new int[10][10];
    static int[] cp = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        backtracking(0, 0); // 좌표, 몇 개의 색종이를 썼는지'
        
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void backtracking(int rc, int num) {

        if (rc == 100) {
            result = Math.min(result, num);
            return;
        }
        
        // 좌표값
        int c = rc % 10; // 열 (x)
        int r = rc / 10; // 행 (y)

        // 가지치기
        if (result <= num) {
            return;
        }
        if (map[r][c] == 1) { // 1인 경우
            for (int i = 5; i > 0; i--) {
                if (cp[i] > 0 && check(r, c, i)) {
                    cp[i]--;
                    fill(r, c, i, 0); // 색종이 붙이기
                    backtracking(rc + 1, num + 1);
                    fill(r, c, i, 1); // 색종이 떼기
                    cp[i]++;

                }
            }
        } else { // 0인 경우
            backtracking(rc + 1, num);
        }

    }

    private static boolean check(int r, int c, int size) {
        if (c + size > 10 || r + size > 10) {
            return false;
        }
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(map[i][j] != 1) // 색종이를 붙일 수 없는 구역이면
                    return false;
            }
        }
        return true; // 색종이 붙일 수 있다.
    }

    private static void fill(int r, int c, int size, int num) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = num; // size(크기)만큼 색종이를 붙였다가 뗀다.
            }
        }
    }

}
