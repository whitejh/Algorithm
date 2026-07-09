class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int left = 0, right = 0;
        int sum = sequence[0]; // 초기 합은 첫번째 원소 값
        
        // 정답 구간의 길이와 인덱스를 기억할 변수
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (right < sequence.length) {
            if (sum == k) {
                int curLen = right - left + 1;
                
                if (curLen < minLen) {
                    minLen = curLen;
                    answer[0] = left;
                    answer[1] = right;
                }
                
                // 값을 찾았으니 left를 움직여 다음 구간 탐색 준비
                sum -= sequence[left];
                left++;
            } else if (sum < k) {
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                sum -= sequence[left]; // sum > k
                left++;
            }
        }
        
        return answer;
    }
}