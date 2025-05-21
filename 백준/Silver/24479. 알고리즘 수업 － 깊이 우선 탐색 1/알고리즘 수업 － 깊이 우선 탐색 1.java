import java.io.*;
import java.util.*;

// 2025/5/21 수요일 오전 11시
// 시작점을 변수로 제공
// N이 10만이라서 2차원 배열 말고 ArrayList 사용
public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static int N, M, R;
    static int[] answer;
    static int order; // 순서를 담고 있는 변수

    public static void dfs(int idx) {
        visited[idx] = true;
        answer[idx] = order; // 이 노드를 몇번째로 방문했는지 기록
        order++; // 순서 증가

        // dfs : idx 번으로 들어왔다면 내가 방문했다라고 기록하고 내가 몇등으로 들어왔는지 담아주고
        // 나랑 연결되어있는 애들을 ArrayList에서 찾아서 방문한다.
        // 방문하는 기준 : 아직 방문하지 않은 노드들만 방문하겠다.

        for (int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i); // idx 기준으로 i번째 연결되어있는 요소(다음에 방문할 노드)
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 1. graph에 연결 정보 채우기
        graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];
        answer = new int[N+1];
        order = 1; // 순서

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        // 2. 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 3. dfs(재귀함수 호출)
        dfs(R);

        // 4. 출력
        for (int i = 1; i <= N; i++) {
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }

        bw.close();
        br.close();
    }
}
