import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 단어 정렬
// 2025/1/18 오후 6시
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String now = br.readLine();
            if (!arr.contains(now)) {
                arr.add(now);
            }
        }
        arr.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); // 2. 길이가 같으면 사전 순 출력
            }
            return o1.length() - o2.length(); // 1. 길이 짧은 것부터 출력
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
