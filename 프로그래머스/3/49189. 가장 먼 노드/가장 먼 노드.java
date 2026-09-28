import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {  
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] line : edge) {
            int a = line[0];
            int b = line[1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] distance = new int[n+1];
        Arrays.fill(distance, -1);
        distance[1] = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.add(1); // 1부터 시작
        
        while(!queue.isEmpty()) {
            int cur = queue.remove(); // 현재 노드 방문
            
            // 다음 노드 예약
            for(int next : graph.get(cur)) {
                if(distance[next] == -1) {
                    distance[next] = distance[cur] + 1;
                    queue.add(next);
                }
            }
        }
            
        int maxDistance = 0;
        for(int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }
            
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(distance[i] == maxDistance) count++;
        }
        
        return count;
    }
}