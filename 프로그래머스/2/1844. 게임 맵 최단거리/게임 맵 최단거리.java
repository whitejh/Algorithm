import java.util.*;
import java.io.*;

class Solution {
    
    private static final int[] dx = {-1,1,0,0};
    private static final int[] dy = {0,0,-1,1};
    
    private static class Node {
        int r,c;
        
        public Node(int r, int c) {
            this.r=r;
            this.c=c;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int N = maps.length;
        int M = maps[0].length;
        
        Queue<Node> queue = new ArrayDeque<>(); // 큐
        boolean[][] visited = new boolean[N][M]; // 방문배열
        int[][] dist = new int[N][M]; // 최단거리 배열
        
        queue.add(new Node(0,0));
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!queue.isEmpty()) {
            Node now = queue.poll(); // 현재 위치한 정점
            
            for(int i = 0; i<4;i++) {
                int nr = now.r + dx[i];
                int nc = now.c + dy[i];
                
                if(nr<0 || nc < 0 || nr >= N || nc >= M) {
                    continue; // map 밖으로 나가는 경우, 예외처리
                }
                
                if(maps[nr][nc] == 0) // 벽
                    continue;
                
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true; // 방문처리
                    queue.add(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        
        if(dist[N-1][M-1] == 0) 
            return -1;
        else 
            return dist[N-1][M-1];
       
    }
}