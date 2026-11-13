import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int num : arr) {
            if(deque.isEmpty()) {
                deque.addLast(num);
            } else if(deque.peekLast() != num) {
                deque.addLast(num);
            }
        }
        
        answer = new int[deque.size()];
        int index = 0;
        
        for(int num : deque) {
            answer[index++] = num;
        }
        return answer;
    }
}