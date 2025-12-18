import java.io.*;
import java.util.Stack;

// 2025.12.18 목요일 오전 9시 58분
// 실버2
// 분류는 연결리스트지만 스택으로 풀어야 시간 초과 안 남
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            s.push(line.charAt(i));
        }
        int m = Integer.parseInt(br.readLine());

        Stack<Character> ds = new Stack<>();
        for (int i = 0; i < m; i++) {
            String op = br.readLine();
            char o = op.charAt(0);

            if (o == 'L') {
                if (!s.empty()) {
                    ds.push(s.pop());
                }
            } else if (o == 'D') {
                if (!ds.empty()) {
                    s.push(ds.pop());
                }
            } else if (o == 'B') {
                if (!s.empty()) {
                    s.pop();
                }
            } else {
                s.push(op.charAt(2));
            }
        }

        while (!ds.empty()) {
            s.push(ds.pop());
        }

        for (Character character : s) {
            bw.write(character);
        }
        bw.close();
    }

}

