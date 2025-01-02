import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나머지와 몫이 같은 수
// 2025/1/2 오후 3시
// 자료형의 표현범위 생각! 
// int -> long 변환
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long sum = 0;

        for (int i = 0; i < n; i++) {
            long temp = (long) n * i + i;
            sum += temp;

        }
        System.out.println(sum);
    }
}
