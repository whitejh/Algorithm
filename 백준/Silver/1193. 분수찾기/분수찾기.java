import java.util.Scanner;

// 분수찾기
// 2025/1/19 오후 11시
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int count = 1;
        int X = 1; // X좌표
        int Y = 1; // Y좌표
        int dir = -1; // 방향 설정

        while (count < N) {
            if (X == 1 && dir == -1) {
                Y++;
                dir = 1;
            } else if (Y == 1 && dir == 1) {
                X++;
                dir = -1;
            } else if (dir == 1) {
                X++;
                Y--;
            } else {
                X--;
                Y++;
            }
            count++;
        }
        System.out.println(X + "/" + Y);

    }
}
