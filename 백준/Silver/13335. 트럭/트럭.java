import java.util.*;
import java.io.*;

// 2025/7/30 수요일 오후 2시 40분 ~ 오후 4시
// 시뮬레이션 + 큐
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int L = Integer.parseInt(st.nextToken()); // 다리의 최대하중
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken())); // 각 트럭 무게 큐에 담기
        }

        for (int i = 0; i < w; i++) {
            bridge.add(0); // 다리의 길이만큼 큐에 마치 무게가 0인 트럭이 올라가있게 조건 설정
        }

        int time = 0;
        int weight = 0;

        while (!bridge.isEmpty()) { // 현재 다리에 올라와 있는 트럭이 존재하지 않을 때까지
            time++;
            weight -= bridge.poll(); // 다리에 올라와있는 트럭이 1대씩 다리에서 내려옴
            if (!trucks.isEmpty()) {
                if (trucks.peek() + weight <= L) { // 트럭큐에 담긴 맨앞의 값과 현재 다리위에 올라와있는 트럭의 무게의 합이 L 보다 낮을때
                    weight += trucks.peek();
                    bridge.add(trucks.poll()); // 다리에 트럭 1대씩 올라감
                } else { // 트럭큐에 트럭이 존재하지만 다리의 최대하중 때문에 다리로 못 올라가는 경우
                    bridge.add(0); // 0 트럭을 큐에 넣어 지연
                }
            }
        }
        System.out.println(time);

    }
}
