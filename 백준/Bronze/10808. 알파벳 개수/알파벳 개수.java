import java.util.Scanner;

// 2024-12-02
public class Main {
    // value => index
    public static void main(String[] args) {
        //System.out.println((int)'a'); // 97
        Scanner sc = new Scanner(System.in);
        int[] result = new int[26];
        char[] temp = sc.next().toCharArray();
        for (int i = 0; i < temp.length; i++) {
            result[temp[i] - 97]++;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
