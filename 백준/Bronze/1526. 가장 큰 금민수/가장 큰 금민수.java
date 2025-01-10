import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 가장 큰 금민수
// 2025/1/10 오전 9시 30분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = N; i >= 4; i--) {
            char[] temp = String.valueOf(i).toCharArray();
            boolean check = true; // 금민수 체크

            for (int j = 0; j < temp.length; j++) {
                if (temp[j] != '4' && temp[j] != '7') {
                    check = false; // 금민수가 아닌 경우
                    break;
                }
            }

            if(check) {
                System.out.println(i); // 금민수 출력
                break;
            }
        }

    }
}
