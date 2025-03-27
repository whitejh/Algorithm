import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2025/3/27 목요일 오후 1시 30분
// 재귀
public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursive(0);
    }

    private static void recursive(int i) {
        if (i == N) {
            printX(i); System.out.println("\"재귀함수가 뭔가요?\"");
            printX(i); System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            printX(i); System.out.println("라고 답변하였지.");
            return;
        }
        printX(i); System.out.println("\"재귀함수가 뭔가요?\"");
        printX(i); System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        printX(i); System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        printX(i); System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        recursive(i + 1);
        printX(i); System.out.println("라고 답변하였지.");

    }

    private static void printX(int N) {
        for (int i = 0; i < N * 4; i++) {
            System.out.print("_");
        }
    }

}
