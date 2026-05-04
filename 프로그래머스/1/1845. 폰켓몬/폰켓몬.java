import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        // 1. nums를 순회하며 HashMap에 빈도수 저장
        for(int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        
        // 2. 뽑을 수 있는 최대 수
        int pickCount = nums.length / 2;
        
        // 3. 폰켓몬 종류 수 (힌트: hashMap.size())
        int typeCount = hashMap.size();
        
        // 4. 둘 중 작은 값 반환
        answer = Math.min(pickCount, typeCount);
        return answer;
    }
}