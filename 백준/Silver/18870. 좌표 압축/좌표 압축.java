import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 2025/10/20 월요일 오후 5시
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];

        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
            S[i] = A[i];
        }
        Arrays.sort(S);
        Map<Integer, Integer> myMap=new HashMap<>();
        int index=0;
        for(int i=0; i<N; i++) {
            int now = S[i];
            if(!myMap.containsKey(now)) {
                myMap.put(now, index++);
            }
        }

        for(int i=0; i<N; i++) {
            int now = A[i];
            bw.write(myMap.get(now) + " ");
        }
        bw.flush();
    }
}
