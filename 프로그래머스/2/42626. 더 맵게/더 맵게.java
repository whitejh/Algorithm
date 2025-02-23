import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        for(int s : scoville) {
            min.add(s);
        }
        
        while(min.size() > 1 && min.peek() < K) {
            int first = min.poll();
            int second = min.poll();
            int mix = first + (second * 2);
            
            min.add(mix);
            answer++;
        }
        
        if(min.peek() < K)
            answer = -1;
        
        return answer;
    }
}