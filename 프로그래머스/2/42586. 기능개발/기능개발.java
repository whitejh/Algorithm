import java.util.*;


public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> production = new ArrayList<>();     
        int n = progresses.length;

        while (n > 0) {
            // 개발
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                }
            }

            // 배포
            int deployCount = 0;
            while (n > 0 && progresses[0] >= 100) {
                deployCount++;
                // 첫 번째 요소를 제거
                for (int i = 0; i < n - 1; i++) {
                    progresses[i] = progresses[i + 1];
                    speeds[i] = speeds[i + 1];
                }
                n--; // 배열 크기 감소
            }
            if (deployCount > 0) {
                production.add(deployCount);
            }
        }

         return production.stream().mapToInt(Integer::intValue).toArray();
        // int[] 배열로 변환
    }
}