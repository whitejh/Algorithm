import java.io.*;

// 2025/1/12 월요일 오후 2시 40분
// DFS 골드1
// 재귀함수를 이용한 DFS문제
// 재귀함수에 자릿수 개념을 붙여 구현
public class Main {

    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        DFS(2,1); // 일의 자리 소수는 2,3,5,7이므로 4개 수에서만 선택
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);

        // 모든 DFS가 끝난 뒤 한 번에 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void DFS(int num, int jarisu) {
        if (jarisu == N) {
            if (isPrime(num)) {
                sb.append(num).append('\n'); // println과 동일한 효과
                // System.out.println(num);
            }
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) { // 짝수
                continue;
            }
            if (isPrime(num * 10 + i)) { // 소수이면 재귀함수로 자릿수를 늘림
                DFS(num * 10 + i, jarisu + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        if(num < 2) return false;

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
