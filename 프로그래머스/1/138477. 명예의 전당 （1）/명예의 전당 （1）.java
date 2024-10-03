import java.util.*;


class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> showList = new ArrayList(); // 명예의 전당
        
        for(int i = 0; i < score.length; i++) {
            if(i < k) {
                showList.add(score[i]);
            }
            else {
                if(score[i] >= showList.get(0)) {
                    showList.remove(0);
                    showList.add(score[i]);
                }   
            }
            Collections.sort(showList);  // 오름차순 정렬
            answer[i] = showList.get(0); // 가장 낮은 점수를 발표점수에 추가
        }
        return answer;
    }
}