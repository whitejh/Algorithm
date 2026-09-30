import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : road) {        
            graph.get(edge[0]).add(new Node(edge[1], edge[2])); // 출발 마을, 도착 마을, 이동 시간
            graph.get(edge[1]).add(new Node(edge[0], edge[2]));
        } // 양방향 그래프
        
        int[] dist = new int[N + 1];            // 1번 마을에서 각 마을까지의 최소 시간을 저장하는 배열
        Arrays.fill(dist, Integer.MAX_VALUE);  // 아직 가는 방법을 모르므로 매우 큰 값으로 초기화
        dist[1] = 0;                           // 1번 마을 → 1번 마을은 이동 시간이 0
        
        PriorityQueue<Node> pq = new PriorityQueue<>();//현재까지 이동 시간이 가장 짧은 노드부터 꺼내기 위한 우선순위 큐
        pq.offer(new Node(1,0)); // 1번 마을에서 시작, 현재까지 이동 시간은 0
        
        // 다익스트라 시작
        while(!pq.isEmpty()) {
            Node cur = pq.poll(); // 현재 후보들 중 이동 시간이 가장 짧은 노드를 꺼냄
            
            if(dist[cur.node] < cur.time) continue;

            for(Node next : graph.get(cur.node)) { // 현재 마을과 연결되어 있는 모든 도로 확인
                int newTime = cur.time + next.time; // (1번 → 현재 마을까지 시간) + (현재 마을 → 다음 마을까지 도로 시간)
                if(newTime < dist[next.node]) { // 더 짧은 경로를 발견했다면
                    dist[next.node] = newTime; // 거리 갱신
                    pq.offer(new Node(next.node, newTime)); // pq에 추가
                }
            }
            
         
        }
        
        for(int i = 1; i <= N; i++) { // 최소 시간이 K 이하인 마을 개수 세기
             if(dist[i] <= K) answer++;
        }
        return answer; // dist[마을번호] = 1번 마을에서 그 마을까지의 최소 시간
    }
    
    class Node implements Comparable<Node> {
        int node; // 마을 번호
        int time; // 해당 마을까지 이동하는데 걸리는 시간
        
        public Node(int node, int time) {
            this.node = node;
            this.time = time;
        }
        
        @Override // PriorityQueue가 time이 작은 Node를 먼저 꺼내도록 설정
        public int compareTo(Node other) {
            return Integer.compare(this.time, other.time);
        }
        
    }
}