import java.util.ArrayList;
import java.util.Scanner;

// 싸이클
//2025/1/13 오후 11시
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int temp = N;

        ArrayList<Integer> myArr = new ArrayList<>();
        myArr.add(N);
        int mySize = 0;

        while (true) {
            temp = (temp * N) % P;

            if (myArr.contains(temp)) {
                for (int i = 0; i < myArr.size(); i++) {
                    if (myArr.get(i) == temp) {
                        mySize = myArr.size() - i;
                        break;
                    }
                }
                break;
            } else {
                myArr.add(temp);
            }
        }
        System.out.println(mySize);
    }
}
