
import java.io.*;
import java.util.StringTokenizer;

// 펠린드롬 수
// 2024/12/16 월요일 오후 8시 30분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String num = br.readLine(); // 한 줄의 문자열을 입력받아 반환
            if (num.equals("0"))
                break;

            if (isP(num))
                bw.write("yes" + "\n");
            else
                bw.write("no" + "\n");
        }
        bw.flush();
    }

    // 펠린드롬수 판별 함수
    private static boolean isP(String num) {
        char[] number_text = num.toCharArray(); // char 배열 생성
        int start = 0;
        int end = number_text.length - 1;

        while (start <= end) {
            if (number_text[start] != number_text[end]) {
                return false; // 양 끝이 다르다면 false
            }
            // 같으면 중간으로 서로 위치이동
            start++;
            end--;
        }
        return true;
    }
}
