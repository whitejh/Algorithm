import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 크로아티아 알파벳
// 2025/1/17 오후 5시 10분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        String check1 = "dz="; // 세글자 단어
        String[] check2 = {"c=", "c-", "d-", "lj", "nj", "s=", "z="}; //  두글자 단어
        int count = 0;

        for (int i = 0; i < text.length() - 1; ) {
            if (i < text.length() - 2 && check1.equals(text.substring(i, i + 3))) {
                count += 2;
                i += 3;
            } // dz= 맞았을 때 (세글자 단어)
            else {
                boolean match = false; // check2 배열에 여러 단어가 있어서 체크해줘야됨
                String now = text.substring(i, i + 2);

                for (String s : check2) {
                    if (s.equals(now)) {
                        count += 1;
                        i += 2;
                        match = true; // check2 배열에 여러 단어가 있어서 체크해줘야됨
                        break;
                    } // 두글자 단어랑 맞았을 때
                }
                if (!match) {
                    i += 1;
                } // 안 맞았을 때
            }
        }

        System.out.println(text.length() - count); // 크로아티아 알파벳 수 출력
    }
}
