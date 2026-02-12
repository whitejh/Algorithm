import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();

        // 1. a의 총 개수(윈도우 크기) 구하기
        int aCount = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a') aCount++;
        }

        // a가 아예 없거나 전체가 a라면 교환할 필요가 없음
        if (aCount == 0 || aCount == n) {
            System.out.println(0);
            return;
        }

        // 2. 첫 번째 윈도우(0 ~ aCount-1)에서의 b 개수 초기 설정
        int currentBCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (str.charAt(i) == 'b') currentBCount++;
        }

        int minBCount = currentBCount;

        // 3. 슬라이딩 윈도우 시작
        // 원형 처리를 위해 % 연산자를 사용하면 doubled 문자열 없이도 가능
        for (int i = 1; i < n; i++) {
            // (1) 윈도우에서 빠지는 이전의 첫 글자가 'b'였다면 count 감소
            if (str.charAt(i - 1) == 'b') {
                currentBCount--;
            }
            // (2) 새롭게 들어오는 끝 글자가 'b'라면 count 증가
            // 원형 연결을 위해 (i + aCount - 1) % n 인덱스 사용
            if (str.charAt((i + aCount - 1) % n) == 'b') {
                currentBCount++;
            }
            
            minBCount = Math.min(minBCount, currentBCount);
        }

        System.out.println(minBCount);
    }
}