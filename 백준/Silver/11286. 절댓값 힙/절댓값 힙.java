import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2026.3.13 금요일 오후 2시
// 풀이시간 30분
// 늘보코치 3주차 답참고가능 문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(!pq.isEmpty()) {
                    System.out.println(pq.poll().value);
                } else {
                    System.out.println(0);
                }
            } else {
                pq.offer(new Node(x));
            }
        }

    }

    static class Node implements Comparable<Node> {
        int value;
        int absValue;

        public Node(int value) {
            this.value = value;
            this.absValue = Math.abs(value); // 절댓값
        }

        @Override
        public int compareTo(Node other) {
            // 1. 절댓값이 다르면 절댓값 기준 오름차순
            if(this.absValue != other.absValue) {
                return this.absValue - other.absValue;
            }
            // 2. 절댓값이 같으면 실제 값 기준 오름차순 (음수가 먼저 옴)
            return this.value - other.value;
        }
    }
}

