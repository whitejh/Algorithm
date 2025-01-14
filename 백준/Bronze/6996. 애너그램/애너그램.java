import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 애너그램
// 2025/1/14 오전 10시
// 문자열 Sorting
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String textA = st.nextToken();
            String textB = st.nextToken();

            if (textA.length() != textB.length()) { // 길이가 다르면 탈락
                System.out.println(textA + " & " + textB + " are NOT anagrams.");
            } else {
                char[] charA = textA.toCharArray();
                char[] charB = textB.toCharArray();
                Arrays.sort(charA);
                Arrays.sort(charB);
                String sortA = String.valueOf(charA);
                String sortB = String.valueOf(charB);

                if (sortA.equals(sortB)) {
                    System.out.println(textA + " & " + textB + " are anagrams.");
                } else {
                    System.out.println(textA + " & " + textB + " are NOT anagrams.");
                }
            }
        }
    }
}
