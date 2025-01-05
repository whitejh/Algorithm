import java.util.ArrayDeque;

class Solution {
    // 올바른 괄호가 아닌 판단 조건
    // 1. 닫히는 괄호가 들어왔는데, 스택이 비어있다.
    // 2. 마지막에 스택에 데이터가 남아있다.
        boolean solution(String s) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for(int i = 0; i< s.length(); i++) {
                char now = s.charAt(i); // O(1) : 배열의 i번째에 접근

                if(now == '(') {
                    stack.addLast(now);
                }
                else {
                    if(stack.isEmpty()) {
                        return false; // 1
                    }
                    else {
                        stack.pollLast();
                    }
                }
            }

            if(stack.isEmpty()) return true; // 2
            else return false; // 2
        }
}