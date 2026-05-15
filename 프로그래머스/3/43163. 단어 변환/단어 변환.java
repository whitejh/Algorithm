import java.util.*;

class Solution {
    /*
    목적 : 최소 몇단계를 거쳐야 node로 갈 수 있는지 풀어야 하는 문제
    제안사항 : 단어 길이 10,워드 개수 50
    */
    public int solution(String begin, String target, String[] words) {
        Set<String> visit = new HashSet<>();
        visit.add(begin);
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        int count = 0;
        while(count < words.length){
            int size = queue.size();
            while(size-- > 0){
                String here = queue.poll();
                if(here.equals(target)){
                    return count;
                }
                for(String word : words){
                    if(visit.contains(word) || !canMoveNext(word,here)){
                        continue;
                    }
                    queue.offer(word);
                    visit.add(word);
                }
            }
            count++;
        }
        
        return 0;
    }
    
    private boolean canMoveNext(String str1,String str2){
        
        int count = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        
        return count <= 1;
    }
}