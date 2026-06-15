import java.util.*;

class Solution {
    public int solution(String dartResult) {
        // 최종 합산 점수를 저장할 변수
        int answer = 0;
        
        // 각 라운드의 점수를 저장하는 배열
        int[] scores = new int[3];
        // 현재 라운드 인덱스
        int idx = 0;
        // 점수를 임시로 저장할 변수
        int num = 0;
        
        // 문자열을 처음부터 끝까지 순회
        for (int i = 0; i < dartResult.length(); i++) {
            // 현재 문자 가져오기
            char c = dartResult.charAt(i);
            
            // 숫자인 경우 (점수 부분)
            if (Character.isDigit(c)) {
                // '10' 처리 (앞이 '1'이고 뒤가 '0'인 경우)
                if (c == '1' && i + 1 < dartResult.length() && dartResult.charAt(i+1) == '0') {
                    num = 10;
                    // '0'까지 소비했으므로 인덱스 하나 더 이동
                    i++;
                } else {
                    // 문자 '0'~'9' -> 실제 숫자 0~9
                    num = c - '0';
                }
            // 보너스 처리 (S, D, T)
            } else if (c == 'S' || c == 'D' || c == 'T') {
                // 1제곱
                if (c == 'S') {
                    num = (int) Math.pow(num, 1);
                // 2제곱
                } else if (c == 'D') {
                    num = (int) Math.pow(num, 2);
                // 3제곱
                } else if (c == 'T') {
                    num = (int) Math.pow(num, 3);
                }
                
                // 계산된 점수를 배열에 저장 후 라운드 이동
                scores[idx++] = num;
            // 옵션 처리 (*, #)
            } else if (c == '*'  || c == '#') {
                // 현재 점수 2배
                if (c == '*') {
                    scores[idx-1] *= 2;
                    // 이전 점수도 존재하면 2배
                    if (idx > 1) {
                        scores[idx-2] *= 2;
                    }
                // 현재 점수 마이너스로 변경
                } else if (c == '#') {
                    scores[idx-1] *= -1;
                }
            }
        }
        
        // 3라운드 점수 합산
        answer = scores[0] + scores[1] + scores[2];
        
        // 최종 점수 반환
        return answer;
    }
}