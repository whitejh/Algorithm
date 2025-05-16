import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2025/5/16 금요일
// 큐
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) { // 0번째 사람이 아니라 첫번째 사람이라서
            list.add(i);
        }
        int index = K - 1;
        System.out.print("<");

        while (!list.isEmpty()) {
            index %= list.size(); // 중요!

            if (list.size() != 1) {
                System.out.print(list.get(index) + ", ");
            } else {
                System.out.print(list.get(index) + ">");
            }

            list.remove(index);
            index += K - 1;
        }
    }
}
