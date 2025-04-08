import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 2025/4/8 화요일 오후 2시 15분
// 스택
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int t = 0; t < N; t++) {
            Stack<Character> st = new Stack<>();
            char[] text = br.readLine().toCharArray();
            st.push(text[0]); // 맨 앞에꺼 먼저 스택에 넣기

            for (int i = 1; i < text.length; i++) {
                char now = text[i];
                if(!st.empty() && st.peek().equals(now)) { // 스택이 비어있지 않고, 맨 위꺼가 now랑 같은 경우
                    st.pop();
                } else { // 스택이 비어있거나, 맨위꺼와 같이 다른 경우
                    st.add(now);
                }
            }
            if(st.empty()) { // 스택이 비어있는 경우, 좋은 단어!
                count++;
            }
        }
        System.out.println(count); // 좋은 단어 수 출력

    }
}
