import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 코스요리 리스트 미리 만들기
        // (0,1은 사용안함)
        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(new HashMap<>());
        }
        // 코스요리 탐색
        for (int i = 0; i < course.length; i++) {
            // 코스요리 메뉴개수
            int n = course[i];
            for (int j = 0; j < orders.length; j++) {
                // 주문메뉴 확인
                // (주문한 메뉴개수 이상만 탐색가능)
                if (n <= orders[j].length()) {
                    // 주문메뉴 정렬
                    char[] c = orders[j].toCharArray();
                    Arrays.sort(c);
                    // 주문메뉴의 알파벳 경우의수를 구한다.
                    // (재귀함수, 완전탐색)
                    addCourse(list.get(n), c, "", n, 0, new boolean[c.length]);
                }
            }
        }

        // 정답 리스트
        List<String> answer = new ArrayList<>();
        for (Map<String, Integer> map : list) {
            // 코스요리가 있는 경우
            if (map.size() > 0) {
                // 주문개수 최대값을 구한다.
                int max = -1;
                for (String key : map.keySet()) {
                    if (map.get(key) > 1) {
                        max = Math.max(max, map.get(key));
                    }
                }
                // 최대값과 동일하면, 정답 리스트에 코스요리를 추가한다.
                for (String key : map.keySet()) {
                    if (max == map.get(key)) {
                        answer.add(key);
                    }
                }
            }
        }
        // 정답 리스트 사전 오름차순정렬
        Collections.sort(answer);
        // 정답 리스트 배열로 반환
        return answer.stream().toArray(String[]::new);
    }

    // 주문메뉴의 알파벳 경우의수 구하기
    // (재귀함수, 완전탐색)
    public void addCourse(Map<String, Integer> map, char[] arr, String str, int n, int pos, boolean[] visited) {
        // 알파벳길이가 메뉴개수와 동일하면
        // 알파벳개수+1
        if (str.length() == n) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }
        // 오름차순으로 정렬된 주문메뉴를 완전탐색한다.
        for (int i = pos; i < arr.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            addCourse(map, arr, str + String.valueOf(arr[i]), n, i + 1, visited);
            visited[i] = false;
        }
        return;
    }
}