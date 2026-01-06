import java.io.*;
import java.util.*;

// 병합정렬(Merge Sort)
// 2025/1/6 화요일
public class Main {

    static int[] arr;
    static int[] temp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 병합정렬 실행
        mergeSort(0, N - 1);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 병합 정렬 (분할)
    static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(left, mid);      // 왼쪽 정렬
            mergeSort(mid + 1, right); // 오른쪽 정렬

            merge(left, mid, right);   // 병합
        }
    }

    // 병합 과정
    static void merge(int left, int mid, int right) {
        int i = left;     // 왼쪽 배열 시작
        int j = mid + 1;  // 오른쪽 배열 시작
        int k = left;     // temp 배열 인덱스 시작

        // 작은 것부터 temp에 담기
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 왼쪽 배열이 남은 경우
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // 오른쪽 배열이 남은 경우
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // temp를 arr로 복사
        for (int t = left; t <= right; t++) {
            arr[t] = temp[t];
        }
    }
}
