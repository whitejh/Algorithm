import java.io.*;
import java.util.*;

// 2025/2/25 화요일 오전 9시 30분
// 늘보코치 1주차
// 풀이시간 : 10분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                stack.push(num);
            } else {
                stack.pop();
            }
        }
        int total = 0;
//        for (int sNum : stack) {
//            total += sNum;
//        }

        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        System.out.println(total);

    }
}
