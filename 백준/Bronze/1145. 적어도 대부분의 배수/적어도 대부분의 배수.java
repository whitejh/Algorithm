import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[5];

        for (int i = 0; i < 5; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int start = A[2];
        while (true) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (start % A[i] == 0) count++;
            }
            if (count > 2) break;
            start++;
        }
        System.out.println(start);
    }
}
