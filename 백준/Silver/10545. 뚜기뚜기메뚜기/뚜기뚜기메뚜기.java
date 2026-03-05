import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2026.3.5 목요일 
// 9주차 시험 출제유형
// 실버5
// 풀이시간 1시간 - 결국 못 품
// 구현, 문자열
public class Main {

    private static final String[] KEYS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] wetToOriginal = new int[10]; // 첫째줄에 9개의 정수
        for (int i = 1; i <= 9; i++) {
            wetToOriginal[i] = Integer.parseInt(st.nextToken());
        }

        int[] originalToWet = new int[10];
        for (int i = 1; i <= 9; i++) {
            originalToWet[wetToOriginal[i]] = i;
        }

        int[] keyOf = new int[26];
        int[] pressOf = new int[26];

//        keyOf['a'] = 원래 키 번호
//        pressOf['a'] = 눌러야 하는 횟수

        for (int i = 2; i <= 9; i++) {
            String letters = KEYS[i];

            for (int j = 0; j < letters.length(); j++) {
                int idx = letters.charAt(j) - 'a';
                keyOf[idx] = i;
                pressOf[idx] = j + 1;
            }

        }

        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        int prevWet = -1; // 이전에 누른 실제키 (첫 문자 처리 시 이전 키가 없음을 표시하기 위한 초기값)

        for (int i = 0; i < line.length(); i++) {
            int c = line.charAt(i) - 'a';

            int originalKey = keyOf[c];
            int presses = pressOf[c];

            int wetKey = originalToWet[originalKey]; // 실제로 눌러야 하는 키

            if(wetKey == prevWet) {
                sb.append('#');
            }

            for (int j = 0; j < presses; j++) {
                sb.append(wetKey);
            }
            prevWet = wetKey;
        }

        System.out.println(sb);
    }

}
