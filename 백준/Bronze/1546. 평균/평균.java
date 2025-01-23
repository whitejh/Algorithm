import java.util.Scanner;

// 평균
// 브론즈 1
// 2025/1/23 오후 10시 30분
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            if (arr[i] > max) max = arr[i];
            sum = sum + arr[i];
        }
        // 한 과목과 관련된 수식을 총합한 후 관련된 수식으로 변환해 로직이 간단해짐
        System.out.println(sum * 100.0 / max / N);


    }
}
