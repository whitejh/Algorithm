import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] list; // 인접 리스트
    static boolean[] visited;
    static int N, M, V;

    public static void dfs(int idx) {
        visited[idx] = true;
        System.out.print(idx + " ");

        // 연결된 노드들만 탐색
        for (int next : list[idx]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>(); // Queue 인터페이스 권장
        visited = new boolean[N + 1];

        queue.add(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(idx + " ");

            for (int next : list[idx]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 1. 인접 리스트 초기화
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        // 2. 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        // 3. 작은 번호부터 방문하기 위해 정렬 
        for (int i = 1; i <= N; i++) {
            Collections.sort(list[i]);
        }

        // DFS 실행
        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();

        // BFS 실행
        bfs();
    }
}