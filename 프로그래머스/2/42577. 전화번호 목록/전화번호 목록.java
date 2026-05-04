import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        // 1. phone_book 전체를 HashMap에 저장
        for(String phone : phone_book) {
            hashMap.put(phone, 1);
        }
        
        // 2. 각 번호의 접두사가 HashMap에 있는지 체크
        for(String phone : phone_book) {
            for(int i = 1; i < phone.length(); i++) {
                // phone의 i글자가 HashMap에 있는지 확인
                if(hashMap.containsKey(phone.substring(0,i))) {
                    return false;
                }
            }
        }
        return true;
    }
}