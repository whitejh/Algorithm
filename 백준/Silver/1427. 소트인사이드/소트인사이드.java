import java.util.*;
import java.io.*;

// 2025.12.29
// 선택정렬 - 내림차순으로 자릿수 정렬하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sArr = br.readLine();
        char[] num = sArr.toCharArray();

        // 선택정렬 - 내림차순
        for (int i = 0; i < num.length - 1; i++) {
            int maxIdx = i;  // 현재 i 위치에서 가장 큰 값을 찾는다

            for (int j = i + 1; j < num.length; j++) {
                if (num[j] > num[maxIdx]) {
                    maxIdx = j;
                }
            }

            // swap
            char temp = num[i];
            num[i] = num[maxIdx];
            num[maxIdx] = temp;
        }

        // 출력
        for (char c : num) {
            System.out.print(c);
        }
    }
}
