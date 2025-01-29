// 2025/1/29 수요일 오후 10시 25분
// 수 정렬하기 3
// Counting Sort (계수 정렬)
// 만약 숫자의 범위가 10억이면 사용 x
// 숫자의 범위가 1만이면 사용 가능 (숫자의 범위가 적을 때만 사용)
// api를 사용하지 못할 때 counting sort 사용 고려하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int Max = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cnt = new int[Max + 1];

        for (int i = 0; i < N; i++) { 
            int x = Integer.parseInt(br.readLine());
            cnt[x]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= Max; i++) { // O(K) : 숫자의 범위 만큼
            for (int j = 0; j < cnt[i]; j++) { // O(N)
                sb.append(i).append("\n"); // O(N+K)
            }
        }

        System.out.println(sb);
    }
}
