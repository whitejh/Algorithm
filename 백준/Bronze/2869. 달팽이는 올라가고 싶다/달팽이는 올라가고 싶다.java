import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int V = sc.nextInt();

        int C = A - B;
        int day = (V - B) / C;
        if ((V - B) % C != 0) day++;

        System.out.println(day);
    }
}
