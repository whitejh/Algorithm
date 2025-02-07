import java.util.Stack;


    class Solution {
        public int[] solution(int[] prices) {
            int n = prices.length;
            int[] answer = new int[n]; // 가격이 떨어지지 않은 기간을 저장할 배열

            // 스택을 사용해 이전 가격과 현재 가격 비교
            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            for (int i = 1; i < n; i++) {
                while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                    // 가격이 떨어졌으므로 이전 가격의 기간 계산
                    int pop = stack.pop();
                    answer[pop] = i - pop;
                }
                stack.push(i);
            }

            // 스택에 남아있는 가격들은 가격이 떨어지지 않은 경우
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                answer[pop] = n - 1 - pop;
            }

            return answer;
        }
    }
