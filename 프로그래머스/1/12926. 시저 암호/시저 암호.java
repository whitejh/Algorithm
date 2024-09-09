class Solution {
     public String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);


            if (ch == ' '){
                answer += ch;
                continue;
            } 
            int range = Character.isUpperCase(ch) ? 65 : 97;
            int gap = (ch - range + n) % 26;
            answer += (char) (range + gap);
        }


        return answer;
    }
}