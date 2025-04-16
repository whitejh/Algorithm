import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true; // 새로운 단어의 시작(첫 문자) 여부 
        
        for(char c : s.toCharArray()) {
            if(c == ' ') {  
                sb.append(c); // 공백이면 그대로 추가
                newWord = true; // 공백 후 다음 문자는 새로운 단어의 첫글자
            } else {
                if(newWord) {
                    sb.append(Character.toUpperCase(c)); // 단어의 첫 글자면 대문자로 추가
                    newWord = false; // 단어 중간이니 false로 변경
                } else { // 단어의 첫 글자가 아니여서 소문자로 추가
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        
        return sb.toString();
    }
}
