import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0';
            // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적
            // -'0' 또는 -48을 해주어야 입력받은 숫자 값 그대로 사용가능
        }
        System.out.println(sum);
    }
}
