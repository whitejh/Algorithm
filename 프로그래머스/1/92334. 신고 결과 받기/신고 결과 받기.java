import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        //  1. 신고자 이름 → 인덱스 매핑 
        Map<String, Integer> idIndex = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
        }

        //  2. 중복 신고 제거
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        //  3. 각 유저의 신고당한 횟수 집계
        Map<String, Integer> reports = new HashMap<>();
        for (String id : id_list) {
            reports.put(id, 0);
        }
        for (String r : reportSet) {
            String target = r.split(" ")[1];
            reports.put(target, reports.get(target) + 1);
        }

        //  4. k번 이상 신고당한 대상을 신고한 사람의 카운트 증가
        int[] answer = new int[id_list.length];
        for (String r : reportSet) {
            String[] s = r.split(" ");
            if (reports.get(s[1]) >= k) {
                answer[idIndex.get(s[0])]++; 
            }
        }

        return answer;
    }
}