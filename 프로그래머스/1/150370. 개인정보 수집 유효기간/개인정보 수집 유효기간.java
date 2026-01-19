import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        // 약관별 유효기간을 해시맵에 저장 (일수로 변환)
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]) * 28);
        }
        
        int todayDays = toDays(today);
        
        // 개인정보 순회
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            int collectDays = toDays(parts[0]);
            int elapsed = todayDays - collectDays;
            
            // 경과 일수가 유효기간 이상이면 파기 대상
            if (elapsed >= termMap.get(parts[1])) {
                answer.add(i + 1);  // 번호는 1부터 시작
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int toDays(String date) {
        String[] parts = date.split("\\.");  // 정규표현식 주의
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        return (year - 2000) * 336 + (month - 1) * 28 + (day - 1);
    }
}