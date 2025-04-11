import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        for(long i = 0; i < gcd(a, b); ++i) sb.append("1");
        System.out.print(sb);
    }

    static long gcd(long a, long b)
    {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}