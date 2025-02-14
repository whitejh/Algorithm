import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String,Integer> hashMap = new HashMap<>();
        
        // 완주한 선수들의 이름을 해시맵에 저장
        for(String string : completion) {
            hashMap.put(string, hashMap.getOrDefault(string, 0) + 1);
        }
        
        
        // 참가한 선수들의 이름을 키로 하는 값을 1씩 감소
        for(String string : participant) {
            if(hashMap.getOrDefault(string, 0) == 0) 
                return string; // 완주하지 못한 선수를 찾으면 반환
        
            hashMap.put(string, hashMap.get(string)-1);
        }
        return null;
    }
}