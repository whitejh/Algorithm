import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int m[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String day_str[] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int day = 0;
        for (int i = 0; i < x; i++) {
            day += m[i];
        }
        day += y;
        System.out.println(day_str[day % 7]);
    }
}
