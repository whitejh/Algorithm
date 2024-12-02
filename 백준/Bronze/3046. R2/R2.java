import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R1 = 0;
        int S = 0;
        int R2 = 0;

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                R1 = sc.nextInt();
            } else {
                S = sc.nextInt();
            }
            R2 = (2 * S) - R1;
        }
        System.out.println(R2);
    }
}
