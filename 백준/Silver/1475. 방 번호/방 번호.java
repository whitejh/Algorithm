import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/3/26 수요일 오후 4시 20분
// 구현
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] temp = br.readLine().toCharArray();
        int[] count = new int[10];
        for (int i = 0; i < temp.length; i++) {
            int index = Integer.parseInt(String.valueOf(temp[i]));
            count[index]++;
        }

        int max = -1;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                if (max < count[i]) {
                    max = count[i];
                }
            }
        }
        int sixnine = (count[6] + count[9]) / 2;
        if ((count[6] + count[9]) % 2 != 0) sixnine++;
        if (max < sixnine) max = sixnine;
        System.out.println(max);
    }
}