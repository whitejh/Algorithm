import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 뒤집힌 덧셈
// 2024/12/26 오후 3시 50분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String X = st.nextToken();
        String Y = st.nextToken();
        String answer = Rev(String.valueOf(Integer.parseInt(Rev(X)) + Integer.parseInt(Rev(Y))));
        System.out.println(answer);
    }

    static String Rev(String num) {
        char[] temp = num.toCharArray();
        String result = "";
        boolean firstZero = true;
        for (int i = temp.length - 1; i >= 0; i--) {
            char now = temp[i];
            if (now == '0' && firstZero) continue;

            firstZero = false;
            result += String.valueOf(now);
        }
        return result;
    }
}
