import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/5/13 화요일
// 브루트포스
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        //100보다 작은 수는 모두 한수
        int count = Integer.parseInt(n);
        if (count > 99) {
            count = 99;
        } else {
            System.out.println(count);
            return;
        }

        for (int i = 100; i <= Integer.parseInt(n); i++) {
            char[] c = String.valueOf(i).toCharArray();
            boolean hansu = true;
            int check = c[0] - c[1];
            
            for (int j = 1; j < c.length - 1; j++) {
                if (c[j] - c[j + 1] != check) {
                    hansu = false;
                    break;
                }
            }
            if (hansu) count++;
        }
        System.out.println(count);
    }
}

