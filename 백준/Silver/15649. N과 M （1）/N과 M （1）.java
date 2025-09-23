import java.io.*;
import java.util.*;

public class Main {
    
    private static boolean[] used;
    private static int N,M;
    private static StringBuilder sb;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        
        used = new boolean[N + 1];
        
        backtrack(0, "");
        
        System.out.println(sb);
    }

    private static void backtrack(int cnt, String s) {
        if(cnt == M){
            sb.append(s.trim() + "\n");
        }
        for(int i = 1; i <= N; i++) {
            if(!used[i]) {
                used[i] = true;
                backtrack(cnt + 1, s + " " + i);
                used[i] = false;
            }
        }
    }
}