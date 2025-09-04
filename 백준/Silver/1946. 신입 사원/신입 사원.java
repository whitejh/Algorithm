import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 2025/9/4 목요일
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < testCase; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Point> points = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                points.add(new Point(a, b));
            }
            
            Collections.sort(points);
            int best = Integer.MAX_VALUE;
            int count = 0;
            
            for (int i = 0; i < N; i++) {
                int now = points.get(i).b;
                if (best > now) {
                    count++;
                    best = now;
                }
            }
            System.out.println(count);
        }
    }
}

class Point implements Comparable<Point> {
    int a;
    int b;

    public Point(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Point o) {
        return this.a - o.a;
    }
}
