import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        Stack<String> st = new Stack<>();
        int sum = 0;

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '(') { // 1. ( 그러면 스택에 넣기
                st.push("(");
            } else { // 2. ) 앞에 있는 값을 비교해서 ( 레이저니깐 스택 길이만큼 더한다
                if (n.charAt(i - 1) == '(') {
                    st.pop();
                    sum += st.size();
                } else {  // 3. ) 앞에 있는 값을 비교해서 ) 막대기니깐 +1
                    st.pop();
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
