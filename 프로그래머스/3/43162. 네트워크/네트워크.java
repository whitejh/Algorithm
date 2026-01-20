class Solution {
    static int[][] computer;
    static boolean[] visited; // 방문배열
    
    private static void dfs(int now) {
        if (visited[now]) return;

        visited[now] = true;

        for (int i = 0; i < computer.length; i++) {
            if (computer[now][i] == 1)
                dfs(i);
        }
    }    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        computer = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
    
}