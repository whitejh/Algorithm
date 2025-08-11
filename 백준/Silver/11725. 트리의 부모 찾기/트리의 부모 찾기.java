import java.util.*;
import java.io.*;

public class Main {
    
    final static int MAX = 100000 + 1;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N;
    static int[] answer;
    
    public static void dfs(int idx) {
        visited[idx] = true;
        
        for(int i = 0; i < graph[idx].size(); i++) {
            int next = graph[idx].get(i);
            
            if(!visited[next]) {
                answer[next] = idx; // 문제조건 : 방문하려는 노드 = 현재 노드의 자식
                dfs(next);
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        // 1. graph에 연결 정보 채우기
        graph = new ArrayList[MAX];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[MAX];
        answer = new int[MAX];
        
        int x,y;
        for(int i = 0;i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        
        // 2. dfs(재귀함수 호출)
        dfs(1); // 트리 루트 1번부터 시작
        
        // 3. 출력
        for(int i = 2; i <= N; i++) {
             // 각 노드의 부모 노드 번호를 2번 노드부터 출력
            bw.write(String.valueOf(answer[i]));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}