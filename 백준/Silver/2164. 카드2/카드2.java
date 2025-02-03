import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 카드
// 2025/2/3 월요일 오후 11시 10분
// 큐 자료구조 이용
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            queue.add(i);
        }

        while(queue.size()>1) { // 카드가 1장 남을 때까지
            queue.poll();       // 맨 위의 카드를 버림
            queue.add(queue.poll()); // 맨 위의 카드를 가장 아래 카드 밑으로 이동
        }

        System.out.println(queue.poll()); // 마지막으로 남은 카드 출력
    }
}
