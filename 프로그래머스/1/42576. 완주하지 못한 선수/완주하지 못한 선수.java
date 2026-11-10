import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // 완주한 선수들의 이름을 해시맵에 저장
        for(String name : completion) {
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);
            // "완주한 선수의 이름"이 있으면 그 값에 +1, 없으면 0을 가져와서 +1 (결국 1이 됨)
        }
        
        // 참가한 선수들의 이름을 키로 하는 값을 1씩 감소
        for(String name : participant) {
            if(hashMap.getOrDefault(name, 0) == 0) {
                return name; // 완주하지 못한 선수를 반환
            }
            
            hashMap.put(name, hashMap.get(name) - 1);
        }
        return answer;

    }
}