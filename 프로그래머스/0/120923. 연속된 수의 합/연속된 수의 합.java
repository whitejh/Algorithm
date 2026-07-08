class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        // 1. 초기 윈도우 설정: 0부터 num - 1까지의 합 구하기
        int curSum = 0;
        for (int i = 0; i < num; i++) {
            curSum += i;
        }
        
        // 2. 윈도우의 시작 인덱스(start)
        int start = 0;
        
        // 3. 현재 합(curSum)이 total과 같아질 때까지 윈도우를 이동
        while (curSum != total) {
            if (curSum < total) {
                // 합이 작으면 윈도우를 오른쪽으로 한 칸 이동
                // 오른쪽에 새로 추가될 값: start + num, 왼쪽에서 빠질 값: start
                curSum += (start + num) - start;
                start++;
            } else {
                // 합이 크면 윈도우를 왼쪽으로 한 칸 이동
                // 왼쪽에 새로 추가될 값: start - 1, 오른쪽에서 빠질 값: start + num - 1
                start--;
                curSum += (start - 1) - (start + num - 1);
            }
        }
        
        for (int i = 0; i < num; i++) {
            answer[i] = start + i;
        }
        return answer;
    }
}