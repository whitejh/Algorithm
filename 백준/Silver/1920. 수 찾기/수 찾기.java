import java.io.*;
import java.util.*;

// 해시셋, 이분탐색
// 수찾기
// 2026.2.11 수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(); 

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            
            if (set.contains(target)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
