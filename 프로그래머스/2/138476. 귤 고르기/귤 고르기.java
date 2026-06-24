import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int result = 0; // 최솟값 카운트(정답)
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : tangerine) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        //System.out.println(map);
        
        List<Integer> counts = new ArrayList<>(map.values());
        
        counts.sort(Collections.reverseOrder()); // 내림차순 정렬
        //System.out.println(counts);
        
        for(int count : counts) {
            k -= count;
            result++;
            
            if(k <= 0) break;
        }
        
        return result;
    }
}
