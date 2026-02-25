import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 2025/2/25 화요일 오전 10시
// 늘보코치 1주차
// 풀이시간 : 30분
// 바로 접근법이 생각 안 나서 시간 오래 걸릴 것 같아 괄호 유형이라 판단하고 풀이 참고함
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;

        while (true) {
            s = br.readLine();
            if (s.equals(".")) {
                break;
            }
            sb.append(solve(s)).append('\n');
        }
        System.out.println(sb);

    }

    public static String solve(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 여는 괄호일 경우 스택에 push
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            else if (c == ')') {
                // 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                } else {
                    stack.pop();
                }
            }
            else if (c == ']') {
                // 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                } else {
                    stack.pop();
                }
            }

            // 그 외의 경우에는 불필요한 문자들이기에 skip한다.
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }

    }
}
