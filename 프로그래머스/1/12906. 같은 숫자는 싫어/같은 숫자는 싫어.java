import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int value : arr) {
            if (q.isEmpty()) {
                q.addLast(value);
            } else if (q.peekLast() != value) {
                q.addLast(value);
            }
        }
        
        int[] result = new int[q.size()];
        int index = 0;
        
        for(int value : q) {
            result[index++] = value;
        }
        return result;
    }
}