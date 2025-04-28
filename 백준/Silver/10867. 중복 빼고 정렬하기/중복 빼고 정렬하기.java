import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int A[] = new int[2001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            A[temp + 1000] = 1;
        }
        
        for (int i = 0; i < 2001; i++) {
            if (A[i] != 0) {
                System.out.print((i - 1000) + " ");
            }
        }
    }
}
