import java.util.*;
import java.io.*;

// 백준 13023
// 2026/1/15 오후 1시 20분
// DFS
public class Main {

    static ArrayList<Integer>[] graph; // 연결리스트
    static boolean[] visited;
    static boolean arrive;
    static int N, M; // 노드, 엣지

    public static void dfs(int idx, int depth) {
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[idx] = true;
        
        // for (int i: graph[idx])
        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i); // graph[idx]는 idx와 연결된 이웃 노드 번호들을 담은 ArrayList<Integer>
            if (!visited[next]) {
                dfs(next, depth + 1); // 재귀호출할 때마다 depth 1씩 증가
            }
        }
        visited[idx] = false; // 백트래킹
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // graph에 연결정보 채우기
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        arrive = false;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1); // idx, depth

            if (arrive)
                break;
        }

        if (arrive) bw.write("1");
        else bw.write("0");

        bw.flush();
        bw.close();
    }
}
