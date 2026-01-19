import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        
        List<Integer>[] list = new ArrayList[n + 1];
        int diff = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        // 전선들을 하나씩 끊어보면서 각각의 경우들 확인하기
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            // 전선 끊고
            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
            
            // bfs, dfs 
            int treeA = bfs(a, n, list);
            int treeB = n - treeA;
            int tempDiff = Math.abs(treeA - treeB);
            diff = Math.min(diff, tempDiff);
            
            // 전선을 다시 이어붙이기
            list[a].add(Integer.valueOf(b));
            list[b].add(Integer.valueOf(a));
         
        }
        
        return diff;
    }
    
    private int bfs(int start, int n, List<Integer>[] list) {
        
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        
        int cnt = 1;
        q.offer(start);
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for(int next : list[now]) {
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