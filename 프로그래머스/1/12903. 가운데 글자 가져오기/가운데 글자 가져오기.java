class Solution {
    public String solution(String s) {
         String answer = "";
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(len % 2 == 0){ // 단어의 길이가 짝수
                answer += s.charAt(len/2 - 1); 
                answer += s.charAt(len/2); break;
            }else{ //단어의 길이가 홀수
                answer += s.charAt(len/2); break;
            }
        }
        return answer;
    }
}