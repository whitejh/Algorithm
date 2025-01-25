import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations); // 정렬 -> [0,1,3,5,6]
        
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= (citations.length - i)) {
                answer = citations.length - i; // 인용된 논문의 수
                break;
            }
        }
        
        return answer;
    }
}