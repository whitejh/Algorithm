import java.io.*;
import java.util.*;

// 2025/7/31 목요일 오전 11시 20분
// 스택
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] answer = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= num[i]) { // 오큰수가 아닌 경우
                stack.pollLast(); // 스택에서 제거
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(num[i]);
        }

        for (int i : answer) bw.write(i + " ");

        bw.flush();
    }
}
