import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// 소트인사이드
// 2025/1/20 오후 11시 40분
// 배열의 index를 key로 활용
// 계수 정렬 알고리즘 (Counting Sort)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10]; // index 10개 : [0,1,2,3,4,5,6,7,8,9]
        char[] temp = br.readLine().toCharArray();

        for (char c : temp) {
            int num = Integer.parseInt(String.valueOf(c));
            arr[num]++;
        }

        for (int i = 9; i >= 0; ) {
            if (arr[i] != 0) {
                System.out.print(i);
                arr[i]--;
            } else {
                i--; // arr[i]가 0인 경우, i 감소
            }
        }
    }
}
