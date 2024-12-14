
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 가장 큰 수 x 가장 작은 수
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int Max = -1;
        int Min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (Max < temp) Max = temp;
            if (Min > temp) Min = temp;
        }
        
        System.out.println(Max * Min);
    }
}
