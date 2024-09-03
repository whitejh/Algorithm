class Solution {
     public int solution(int n) {
        // 3진수로 변환
        String answer = Integer.toString(n, 3);
        
        // 문자열 뒤집기
        String reversed = new StringBuilder(answer).reverse().toString();
        
        // 다시 10진수로 변환하여 반환
        return Integer.parseInt(reversed, 3);
    }
}