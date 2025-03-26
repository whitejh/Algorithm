import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        long N = 1; // S가 최초로 넘을 때까지 최대한 작은 자연수부터 더해가는게 유리하다 -> 그리디 느낌

        while(sum <= S) {
            sum+=N;
            N++;
        }
        System.out.println(N-2); // 끝처리만 조금 데이터를 돌려보면서 처리해주기

    }
}
