import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] list = new int[arr.length];
        Arrays.sort(arr); // 오름차순 정렬
        
        int j= 0;
        for(int i = 0; i < arr.length; i++) {
                if(arr[i] % divisor == 0 ) {
                    list[j] = arr[i];
                    j++;
                }
        }
        
        if(j == 0) {
            list[j] = -1;
            j++;
        }
        
        int[] answer = Arrays.copyOf(list, j); // 배열 복사
        return answer;
    }
}