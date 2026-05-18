class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }
    
    int dfs(int[] numbers, int target, int idx, int cur) {
        if(idx == numbers.length) {
            if(cur == target) return 1;
            else return 0;
        }
        
        int sum = 0;
        sum += dfs(numbers, target, idx+1, cur + numbers[idx]);
        sum += dfs(numbers, target, idx+1, cur - numbers[idx]);
        
        return sum;
        
        
    }
}