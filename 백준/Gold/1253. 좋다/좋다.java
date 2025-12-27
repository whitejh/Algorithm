import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 10
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 1 2 3 4 5 6 7 8 9 10
        }
        Arrays.sort(arr); // 정렬

        // 투포인터 알고리즘
        int count = 0; // 좋은 수 개수 : 자기 자신 포함 안해서 0부터 시작
        for (int j = 0; j < N; j++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                int sum = arr[start] + arr[end];

                if (sum == arr[j]) {  // 두 수의 합이 arr[j]와 같은 경우
                    if (start != j && end != j) { // 자기 자신 포함 x
                        count++; // arr[j]는 좋은 수
                        break;   // 더 이상 확인할 필요 없음 → 다음 j로 이동
                    }
                    if (start == j) start++; // 한 포인터가 j를 가리키면, 해당 포인터를 이동시켜야 한다.
                    else end--;
                }
                else if (sum < arr[j]) {  // 현재 합이 작으면 start를 오른쪽으로 이동 (값을 크게 만든다)
                    start++;
                }
                else {   // 현재 합이 크면 end를 왼쪽으로 이동 (값을 작게 만든다)
                    end--;
                }
            }

        }
        System.out.println(count);
    }
}

// 3,4,5,6,7,8,9,10은 좋다.
//        3 = 1 + 2
//
//        4 = 1 + 3
//
//        5 = 2 + 3
//
//        6 = 1 + 5 or 2 + 4
//
//        7 = 3 + 4
//
//        8 = 5 + 3
//
//        9 = 4 + 5
//
//        10 = 1 + 9 or 4 + 6 …
//
//즉 3, 4, 5, 6, 7, 8, 9, 10 (총 8개).