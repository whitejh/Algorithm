import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/2/27 금요일 오전 11시 30분
// 늘보코치 8주차 문제
// 문자열 + 구현
// 풀이시간 : 50분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        String A = br.readLine();
        String B = br.readLine();

        int[] arr = new int[A.length() + B.length()];

        for (int i = 0; i < arr.length / 2; i++) {
            arr[2 * i] = alphabet[A.charAt(i) - 'A'];
            arr[2 * i + 1] = alphabet[B.charAt(i) - 'A'];
        }

        while (arr.length > 2) {
            int[] next = new int[arr.length - 1];
            for (int i = 0; i < next.length; i++) {
                next[i] = (arr[i] + arr[i + 1]) % 10;
            }
            arr = next;
        }

        // System.out.println("" + arr[0] + arr[1]); // ""를 사용하면 문자열 연결
        System.out.println(String.valueOf(arr[0]) + String.valueOf(arr[1])); // 숫자 문자열 연결
    }
}
