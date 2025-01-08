import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 딱지놀이
// 2025/1/8 오후 5시 30분
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {
            StringTokenizer st_A = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st_A.nextToken());
            int[] A = new int[aSize];
            for (int i = 0; i < aSize; i++) {
                A[i] = Integer.parseInt(st_A.nextToken());
            }

            StringTokenizer st_B = new StringTokenizer(br.readLine());
            int bSize = Integer.parseInt(st_B.nextToken());
            int[] B = new int[bSize];
            for (int i = 0; i < bSize; i++) {
                B[i] = Integer.parseInt(st_B.nextToken());
            }

            Arrays.sort(A); // Sorting A
            Arrays.sort(B); // Sorting B

            boolean check = false; // check

            for (int i = 1; aSize - i >= 0 && bSize - i >= 0; i++) {
                if (A[aSize - i] > B[bSize - i]) {
                    System.out.println("A");
                    check = true;
                    break;
                } else if (A[aSize - i] < B[bSize - i]) {
                    System.out.println("B");
                    check = true;
                    break;
                }
            }

            if (!check) {
                if (aSize > bSize) {
                    System.out.println("A");
                } else if (aSize < bSize) {
                    System.out.println("B");
                } else {
                    System.out.println("D");
                }
            }
        }
    }
}
