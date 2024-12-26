import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 단어의 개수
// 2024/12/26 오후 4시 30분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        StringTokenizer st = new StringTokenizer(sentence, " ");

        System.out.println(st.countTokens()); // 띄어쓰기 단위로 끊어서 문장 속 단어의 개수 카운트
    }
}
