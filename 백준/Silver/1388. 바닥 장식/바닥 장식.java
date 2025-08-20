import java.util.*;
import java.io.*;

class Main {
    final static int MAX = 50 + 10;
    static char[][] map;
    static boolean[][] visited;

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        if (map[y][x] == '-' && map[y][x + 1] == '-') dfs(y, x + 1);
        else if (map[y][x] == '|' && map[y + 1][x] == '|') dfs(y + 1, x);
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        // 1. map 정보 반영
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++)
                map[i][j] = line.charAt(j - 1);
        }

        // 2. dfs 수행
        int answer = 0;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                if (!visited[i][j]) {
                    dfs(i, j);
                    answer++;
                }

        // 3. 출력
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }
}