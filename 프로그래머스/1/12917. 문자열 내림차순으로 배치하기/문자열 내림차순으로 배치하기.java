import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split("");
        Arrays.sort(str, Collections.reverseOrder());
        
        for(String a : str)
            answer+= a;
        
        return answer;
    }
}

// 1. 문자열을 split 메소드를 사용하여 배열 str에 넣는다.
// ['Z', 'b', 'c', 'd', 'e', 'f', 'g']
// 2. sort 메소드로 정렬한뒤 reverseOrder()로 내림차순으로 배열 정렬
// ["Z", "b", "c", "d", "e", "f", "g"]
// ["g", "f", "e", "d", "c", "b", "Z"]
// 3. 배열 속 문자열을 다 더한다