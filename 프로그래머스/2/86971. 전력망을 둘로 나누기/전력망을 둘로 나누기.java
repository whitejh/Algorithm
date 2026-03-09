import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static int diff;
    
    public int solution(int n, int[][] wires) {
        
        graph = new ArrayList[n + 1]; // 노드 번호가 1부터 시작해서 n+1 , graph[1] ~ graph[n]
        diff = Integer.MAX_VALUE; // 송전탑 개수 차이의 최소값
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            int v1 = wire[0]; // v1번 송전탑
            int v2 = wire[1]; // v2번 송전탑
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        } // 그래프 세팅
        
        // 전선들을 하나씩 끊어보면서 각각의 경우들 확인하기
        for(int[] wire : wires) {
            int v1 = wire[0]; // v1번 송전탑
            int v2 = wire[1]; // v2번 송전탑
            
            // 그래프에서 전선 끊기
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            // bfs, dfs 
            int treeA = bfs(v1, n); // a가 속한 쪽의 크기를 bfs(a, n)으로 구하기
            int treeB = n - treeA; // 나머지 크기는 전체에서 빼기
            int tempDiff = Math.abs(treeA - treeB);
            diff = Math.min(diff, tempDiff);
            
            // 전선을 다시 이어붙이기(한 전선에 대한 계산이 끝났으면 원래 그래프로 되돌려야 다음 전선도 계산 가능)
            graph[v1].add(Integer.valueOf(v2));
            graph[v2].add(Integer.valueOf(v1));
        }
        
        return diff;
    }
    
    private int bfs(int start, int n) {
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        
        int cnt = 1;
        q.offer(start); // 시작점 예약
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int now = q.poll(); // 방문
            
            for(int next : graph[now]) {
                if(!visited[next]) {
                    q.offer(next);
                    visited[next] = true;
                    cnt++;
                }
            }
        }
        return cnt;
        
    }
}