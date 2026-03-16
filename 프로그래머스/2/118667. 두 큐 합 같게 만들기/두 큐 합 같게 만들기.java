import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        int n = queue1.length;
        long sum1 = 0;
        long sum2 = 0;
        
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        
        for(int num : queue1) {
            q1.addLast(num);
            sum1 += num;
        }
        
        for(int num : queue2) {
            q2.addLast(num);
            sum2 += num;
        }
        
        // 각 큐의 원소합을 같게 만들 수 없는 경우 -> 두 개의 합이 짝수가 아닐 때
        if((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        for(int cnt = 0; cnt < 3 * n; cnt++) {
            if(sum1 == sum2) {
                return cnt;
            } else if(sum1 > sum2) {
                int num = q1.pollFirst();
                q2.addLast(num);
                sum1 -= num;
                sum2 += num;
            } else {
                int num = q2.pollFirst();
                q1.addLast(num);
                sum1 += num;
                sum2 -= num;
            }
        }
        
        return -1;
    }
}