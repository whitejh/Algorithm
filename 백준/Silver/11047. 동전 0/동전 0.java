import java.io.*;
import java.util.*;

// 2025/4/10 목요일 오후 4시 40분
// 그리디 : 현재 상태에서 항상 최선의 수를 선택
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전 종류
        int K = Integer.parseInt(st.nextToken()); // 동전 가치 합

        int[] arr = new int[N + 1];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0; // 동전 수
        // 그리디 알고리즘 : 가치가 큰 동전부터 선택해야 필요한 동전의 개수가 최소
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] <= K) { // 현재 동전의 가치가 K보다 작거나 같은 경우
                count += K / arr[i];
                K = K % arr[i]; // 현재 동전을 사용하고 남은 금액으로 갱신
            }
        }

        System.out.println(count);
    }
}

// 최대한 큰 금액의 동전으로 거스르기
// 동전을 최소로 사용하여 K를 만들기 위해서는 가장 가격이 큰 동전부터 차례대로 사용

// 그리디 알고리즘은 잘 따져보지 않으면 반례가 생길 수 있다.
// 그리디 알고리즘으로 풀 수 있도록 동전 가격이 앞에 나오는 동전 가격의 배수가 된다는 조건
