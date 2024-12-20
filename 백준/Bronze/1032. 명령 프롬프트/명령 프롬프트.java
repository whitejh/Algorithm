import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 명령 프롬프트
// 2024/12/20 오후 6시
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] text = new char[N][]; // 2차원 배열

        for (int i = 0; i < N; i++) {
            text[i] = br.readLine().toCharArray(); // String 문자열(br.readLine())을 char형 배열로 반환

        }

        for (int i = 0; i < text[0].length; i++) {
            char now = text[0][i];
            boolean same = true;
            for (int j = 0; j < N; j++) {
                if (now != text[j][i]) {
                    same = false;
                    break;
                }
            }
            if (same) System.out.print(now);
            else System.out.print("?");
        }
    }
}
