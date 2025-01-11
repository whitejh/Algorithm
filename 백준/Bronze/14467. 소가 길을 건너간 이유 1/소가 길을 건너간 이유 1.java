import java.util.Scanner;

// 소가 길을 건너간 이유 1
//2025/1/11 오후 11시

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int count = 0;

        for (int i = 0; i < N; i++) { // 관찰 이력을 탐색
            int num = sc.nextInt();
            int s = sc.nextInt();
            // 처음 관찰된 소가 아닌데, 이전 위치와  관찰된 위치가 다르면
            // 소가 이동한 것이기 때문에 이동횟수를 1 늘려준다.
            if (A[num] != -1 && A[num] != s) {
                count++;
            }
            A[num] = s; // 마지막에는 관찰된 소의 위치를 업데이트
        }
        System.out.println(count);
    }
}
