import java.io.*;
import java.util.*;

// 2025/12/26 금요일 오후 12시
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int start = 0;

        while(n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if(num > start) {
                // start + 1부터 입력받은 value까지 push를 한다.
                for(int i = start + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append('+').append('\n');
                }
                start= num; // 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
            }
            // top에 있는 원소가 입력받은 값과 같지 않은 경우
            else if(stack.peek() != num) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }

        System.out.println(sb);
    }

}
