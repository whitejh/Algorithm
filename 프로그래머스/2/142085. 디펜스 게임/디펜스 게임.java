import java.util.*;

class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int e : enemy) {
                pq.add(-e); // 내림차순

                // 무적권을 사용하는 상황
                if (k > 0 && n < e) {
                    n += pq.poll() * -1;
                    k--; // 무적권 사용횟수 차감
                }
                n -= e;
                if (n < 0) {
                    break;
                }
                answer++;
            }

            return answer;
        }
    }