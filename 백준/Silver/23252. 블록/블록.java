import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        boolean flag;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            flag = true;
            if ((a + c) % 2 != 0) flag = false;
            else if (a < c) flag = false;
            else if (b % 2 == 1 && a == 0) flag = false;
            sb.append(flag ? "Yes" : "No").append("\n");
        }
        System.out.print(sb);
    }
}