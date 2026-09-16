class Solution {
    int n;
    int[][] computers;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        
        int count = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
        
            dfs(visited, i);
            count++;
        }
        return count;
    }
    
    void dfs(boolean[] visited, int cur) {
        visited[cur] = true;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i] && computers[cur][i] == 1) {
                dfs(visited, i);
            }
        }
    }
}