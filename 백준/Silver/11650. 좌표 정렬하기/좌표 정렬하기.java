import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 좌표 정렬하기
// 2025/1/28 화요일 오후 3시 20분
public class Main {
    private static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            } else {
                return Integer.compare(this.x, o.x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(points[i].x).append(" ").append(points[i].y).append("\n");
        }

        System.out.println(sb);
    }
}
