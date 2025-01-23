import java.util.Scanner;

// 영화감독 숌
// 2025/1/23 오후 10시
// 브루트포스
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int index = 666;

        while (N > count) {
            String temp = String.valueOf(index);
            if (temp.contains("666")) { // 종말의 수면 count 1 증가
                count++;
            }
            index++;
        }
        System.out.println(index - 1);
    }
}
