class Solution {
    public int[] solution(long n) {
        
        // 숫자 n을 문자열로 변환 후, 길이 구하기
        int length = Long.toString(n).length();
        
        // 결과 저장할 배열을 길이 length 만큼 생성
        int[] answer = new int[length];
        
        for(int i = 0; i < length ; i++) {
            // 현재 자리수의 숫자를 result 배열에 저장
            answer[i] = (int) (n % 10);
            n /= 10; // n으로 10으로 나누어 다음 자리수로 이동
        }
        
        return answer;
    }
}