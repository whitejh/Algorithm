import java.util.ArrayList;
import java.util.Collections;

// 2025/1/29 수요일 오후 10시 25분
// 가장 큰 수
class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort((o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return Integer.compare(b, a);
        });

        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s);
        }
        
        if(sb.charAt(0) == '0') {
            return "0"; // 맨 앞자리가 0인 경우, 예외처리
        }
        
        return sb.toString();
    }
}
