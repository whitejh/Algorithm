import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// DFS
// 2025/2/21 금요일 오후 7시 15분
public class Main {

    static ArrayList<Integer>[] A; // 그래프 데이터 저장하는 인접 리스트
    static boolean visited[]; // 방문 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 개수 : 6
        int M = Integer.parseInt(st.nextToken()); // 에지 개수 : 5

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1]; // 0번 인덱스가 헷갈려서 사용 안하려고 N+1 선언

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<Integer>(); // 인접리스트 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 양방향 에지이므로 양쪽에 에지를 더하기
            A[start].add(end); // 시작점 -> 종료점
            A[end].add(start); // 종료점 -> 시작점
        }

        int cnt = 0; // 연결 요소의 개수
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) { // 방문하지 않은 노드가 없을 때까지 반복
                DFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    // DFS 구현
    private static void DFS(int v) {
        if (visited[v]) return;

        visited[v] = true; // 방문 배열에 현재 노드 기록

        for (int i : A[v]) {
            if (!visited[i]) { // 연결 노드 중 방문하지 않았던 노드만 탐색
                DFS(i); // 현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행 (재귀함수 형태)
            }
        }
    }
}
