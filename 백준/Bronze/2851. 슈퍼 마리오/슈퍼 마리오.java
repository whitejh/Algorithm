import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;

        for (int i = 0; i < 10; i++) {
            int temp = Integer.parseInt(br.readLine());
            sum += temp;
            if (sum > 100) {
                int X = sum - 100;
                int Y = 100 - (sum - temp);
                if (Y < X) sum -= temp;
                break;
            }
        }
        System.out.println(sum);
    }
}
