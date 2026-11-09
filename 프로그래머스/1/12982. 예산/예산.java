import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        
        Arrays.sort(d);
        for(int money : d) {
            if(sum + money > budget) {
                break;
            } 
            sum += money;
            answer++;
        }
        return answer;
    }
}