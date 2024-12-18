import java.io.*;
import java.util.StringTokenizer;

// 2024/12/18 수요일 오후 3시
// 진법 변환 2
// 한 번에 이해를 못했음
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 10진수 숫자
        int B = Integer.parseInt(st.nextToken()); // 몇진법

        if (N < B) {
            if (N > 9) {
                System.out.println((char) (N + 55));
            } else {
                System.out.println(N);
            }
        } else {
            int cnt = 0;
            double temp = B;
            while (N >= temp) {
                temp = Math.pow(B, ++cnt);
            } // B진법으로 표현하였을 때, 몇자리 수로 표현되는지 계산하기

            while (cnt > 0) {
                temp = Math.pow(B, --cnt);
                int now = (int) (N / temp);
                if (now > 9) {
                    System.out.print((char) (now + 55));
                } else {
                    System.out.print(now);
                }
                N = (int) (N % temp);
            }
        }
    }
}
