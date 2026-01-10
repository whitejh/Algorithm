import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            points[i] = new Point(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(points); // 숫자를 기준으로 오름차순 정렬

        int max = 0;
        for (int i = 0; i < N; i++) { // 해당 숫자의 인덱스가 몇 칸 움직였는지 계산
           if(max < points[i].idx - i)
            max = points[i].idx - i; // -> (이동한 횟수 - 1)번
        }

        System.out.println(max + 1); // 위에서 구한 값은 (이동한 횟수 - 1)번이므로 1 더함.
    }

}

class Point implements Comparable<Point> {
    int num; // 숫자
    int idx; // 인덱스

    Point(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    @Override
    public int compareTo(Point o) {
        return num - o.num;
    }

}
