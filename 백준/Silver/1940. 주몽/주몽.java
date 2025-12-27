import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 2025/12/27 토요일
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 6
        int M = Integer.parseInt(br.readLine()); // 9
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        // 먼저 정렬!
        Collections.sort(list); // 1 2 3 4 5 7

        // 투포인터
        int count = 0;
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (list.get(left) + list.get(right) < M) {
                left++;
            } else if (list.get(left) + list.get(right) > M) {
                right--;
            } else {
                count++;
                left++;
                right--;
            }
        }
        System.out.println(count);
    }
}
