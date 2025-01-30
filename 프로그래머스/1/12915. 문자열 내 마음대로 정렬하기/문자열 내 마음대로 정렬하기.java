import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
       Arrays.sort(strings, ((o1, o2) -> o1.charAt(n) == o2.charAt(n) ? 
                o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n))));
        // n번쨰 문자가 같다면 단순한 사전순 오름차순
        // 다르다면 n번째 문자를 기준으로 오름차순 정렬
        
        return strings;
    }
}