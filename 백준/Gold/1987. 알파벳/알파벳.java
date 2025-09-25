import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹
public class Main {

    private static boolean[] used;
    private static int R, C;
    private static int answer;

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static final int[] rx = {0, 0, -1, 1}; // 상하좌우
    private static final int[] ry = {-1, 1, 0, 0}; // 상하좌우
    private static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        answer = 0;

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        used = new boolean['Z' - 'A' + 1];

        used[map[0][0] - 'A'] = true;
        backtrack(new Node(0, 0), 1);

        System.out.println(answer);
    }

    private static void backtrack(Node now, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < 4; i++) {
            int nr = now.r + rx[i];
            int nc = now.c + ry[i];

            if(nr < 0 || nc < 0 || nr >= R || nc >= C)
                continue;

            if(used[map[nr][nc] - 'A'])
                continue;

            used[map[nr][nc] - 'A'] = true;
            backtrack(new Node(nr, nc), cnt + 1);
            used[map[nr][nc] - 'A'] = false;
        }
    }
}