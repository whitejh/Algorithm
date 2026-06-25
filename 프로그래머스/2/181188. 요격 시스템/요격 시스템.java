import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1,o2)->o1[1]-o2[1]); // 미사일들의 범위가 들어 있는 배열을 미사일의 끝 지점을 기준으로 오름차순 정렬
        
        int point = 0;
        for(int[] arr: targets) {
            if(point <= arr[0]) {
                point = arr[1];
                answer++;
            }
        }
        
        return answer;
    }
}