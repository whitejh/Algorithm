class Solution {
    
    static boolean[] visited; // i번 노드 방문 배열
    static int maxSheep;  // 양의 최대 수
    
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length]; // 전체 노드의 개수
        visited[0] = true; // 루트 노드(양)
        maxSheep = 0;

        dfs(info, edges, 1, 0); // 양 1마리, 늑대 1마리 시작

        return maxSheep;
    }
    
    public void dfs(int[] info, int[][] edges, int sheep, int wolf) {
        
        if (wolf >= sheep) {
            return; // 늑대가 양보다 많거나 같으면 종료 
        }
        
        maxSheep = Math.max(maxSheep, sheep); // 최대 양의 개수
        
        for(int[] edge: edges) {
            int parent = edge[0]; // 부모 노드
            int child = edge[1];  // 자식 노드 
        
        
            // 부모는 방문했고, 자식은 미방문인 경우 (지금 방문 가능한 자식 노드를 찾기)
            if (visited[parent] && !visited[child]) {
                visited[child] = true;

                if(info[child] == 0) { // 양인 경우
                    dfs(info, edges, sheep + 1, wolf);
                } else { // 늑대인 경우
                    dfs(info, edges, sheep, wolf + 1);
                }

                visited[child] = false; // 백트래킹
            }
        }
    }
}