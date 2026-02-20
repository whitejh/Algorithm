import java.io.*;
import java.util.*;

// 2026.2.20 금요일 오후 12:30
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] cow = new int[11];
        Arrays.fill(cow, -1); // 배열에 -1로 다 채워넣기

        // 처음 관찰된 소가 아닌데, 이전 위치와 관찰된 위치가 다르면
        // 소가 이동한 것이기 때문에 이동횟수를 1 늘려준다.
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            if (cow[num] != -1 && cow[num] != dir) {
                cnt++;
            }
            cow[num] = dir; // 마지막에는 관찰된 소의 위치를 업데이트

        }
        System.out.println(cnt);
    }
}
