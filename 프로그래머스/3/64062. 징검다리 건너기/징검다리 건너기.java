import java.util.PriorityQueue; 


class Solution {

        private static class Stone {
            int idx, val;

            public Stone(int idx, int val) {
                this.idx = idx;
                this.val = val;
            }
        }

        public int solution(int[] stones, int k) {
            int answer = 0;

            PriorityQueue<Stone> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.val, o1.val));

            int i;
            for (i = 0; i < k; i++) {
                pq.add(new Stone(i, stones[i]));
            }

            answer = pq.peek().val;

            while (i < stones.length) {
                pq.add(new Stone(i, stones[i])); // O(NlogN)
                i++;

                while (pq.peek().idx < i - k) {
                    pq.poll(); // O(NlogN)
                }

                answer = Math.min(answer, pq.peek().val);
            }

            return answer;
        }
    }