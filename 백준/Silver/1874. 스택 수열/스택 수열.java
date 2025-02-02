import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

// 스택 수열
// 2025/2/2 오후 9시
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int num = 1; // 오름차순 수
        boolean result = true;
        for (int i = 0; i < arr.length; i++) {
            int su = arr[i]; // 현재 수열의 수
            if (su >= num) { // 현재 수열 값 >= 오름차순 자연수 : 값이 같아질 때까지 push() 수행
                while (su >= num) {
                    stack.push(num++); // push()
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else { // 현재 수열 값 < 오름차순 자연수 : pop()을 수행해 수열 원소를 꺼냄
                int n = stack.pop();
                // 스택의 가장 위의 수가 만들어야 하는 수열의 수보다 크면 수열을 출력할 수 없음
                if (n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }
        }
        if (result)
            System.out.println(sb.toString());
    }
}
