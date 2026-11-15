class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        if(s.charAt(0) == ')') return false;
        int cnt = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                cnt++;
                continue;
            } else{
                cnt--;
            }
            
            if(cnt < 0) return false;
        }
        
        if(cnt != 0) return false;
        
        return answer;
    }
}