import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 2025/3/14 금요일 오후 1시 30분
// 투포인터 알고리즘
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 9

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        Collections.sort(list); // 1 2 3 5 7 9 10 11 12

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()); // 13

        // 투 포인터 알고리즘 적용
        int left = 0;
        int right = list.size() - 1;
        int count = 0;

        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum == x) {
                count++; // 합이 x와 같다면 개수 증가
                left++;  // 다음 조합 확인 
                right--;
            } else if (sum < x) {
                left++; // 합이 작으면 왼쪽 포인터 증가
            } else {
                right--; // 합이 크면 오른쪽 포인터 감소
            }
        }
        
        System.out.println(count);
    }
}
