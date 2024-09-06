class Solution {
    public String solution(String s) {
        String answer = "";
        
        int cnt = 0;
        String tokens[] = s.split("");
        for(String x : tokens) {
            if(x.contains(" ")) 
                cnt = 0;
            else 
                cnt ++;
                
            if(cnt%2==0) 
                answer += x.toLowerCase();
            else
                answer += x.toUpperCase();
        }
            
        return answer;
    }
}