// 최단 거리 문제 - 특정 시작점에서 여러 위치까지의 최단 거리 계산
// 격자나 그래프에서 BFS를 활용하여 최단 거리 구하기
// BFS를 사용하면 가중치가 동일한 경우, 최단 거리를 쉽게 찾음

import java.util.*;

class Solution {
    
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    int n,m;
    boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{0,0,1}); // r 좌표, c 좌표, 이동한 거리 세팅
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            
            if(r == n - 1 && c == m - 1) { // 목적지인지 먼저 확인
                return dist;
            }
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if(visited[nr][nc] || maps[nr][nc] == 0) continue;
                
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, dist + 1});
            
            }
        }
        return -1;
    }
}