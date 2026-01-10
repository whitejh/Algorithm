import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // K번째 수

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N - 1, K - 1); // 퀵정렬 후 K번째 원소 찾기
        System.out.println(arr[K - 1]);
    }

    // Quick Select
    public static void quickSort(int[] arr, int start, int end, int K) {
        while (start <= end) {

            int pivot = (start + end) / 2; // 중간 위치를 pivot으로 설정
            int pivotValue = arr[pivot];

            int left = start;
            int right = end;

            while (left <= right) {
                while (arr[left] < pivotValue) left++;
                while (arr[right] > pivotValue) right--;

                if (left <= right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }
            }

            // K가 포함된 구간만 다시 탐색
            if (K <= right) { // K번째 수가 왼쪽 구간에 있는 경우
                end = right;
            } else if (K >= left) {  // K번째 수가 오른쪽 구간에 있는 경우
                start = left;
            } else {
                return; // K가 pivot 구간에 있음
            }
        }
    }
}
