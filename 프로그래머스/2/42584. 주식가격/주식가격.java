import java.util.*;

class Solution {
    
    // 0 1 2
    // 1 2 3
    // 
    public int[] solution(int[] prices) {
        int size = prices.length;
        int[] answer = new int[size];
        
        Stack<Integer> stack = new Stack();
        
        for (int i = 0 ; i < size; i++) {
            //스택의 최상단의 가격이 현재 가격보다 크면, 최상단에 있는 값은 현재 시점에 가격이 떨어진 것이다.
            //=> 스택의 최상단의 가격이 떨어지지 않은 시간 = 현재 시간 - push한 시간
            //    또한 스택에는 밑부터 위로 가격이 떨어지지 않도록 저장되어 있음.
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {  
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) { // 스택에 남은 것들은 마지막까지 가격이 떨어지지 않은 것
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        
        
        return answer;
    }
}
