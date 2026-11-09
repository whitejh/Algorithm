class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while(right < sequence.length) {
            if(sum < k) {
                right++;
                if(right == sequence.length) {
                    break;
                }
                sum += sequence[right];
                
            } else if (sum > k) {
                sum -= sequence[left];
                left++;
                
            } else { // sum == k
                int curLen = right - left + 1;
                
                if(curLen < minLen) {
                    minLen = curLen;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                sum -= sequence[left];
                left++;
            }
        }
        
        return answer;
    }
}