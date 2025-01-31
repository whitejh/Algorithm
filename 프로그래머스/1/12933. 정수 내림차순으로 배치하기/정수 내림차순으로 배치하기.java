import java.util.*;

 class Solution {
            public long solution(long n) {
                // TODO 1: 정수 n을 문자열로 변환하고 각 자릿수를 배열로 저장
                String[] digits = String.valueOf(n).split("");

                // TODO 2: 내림차순으로 정렬
                Arrays.sort(digits, Collections.reverseOrder());

                // TODO 3: 정렬된 숫자를 다시 하나의 문자열로 합침
                StringBuilder sb = new StringBuilder();
                for(String digit : digits) {
                    sb.append(digit);
                }

                // TODO 4: 문자열을 long형으로 변환하여 변환
                return Long.parseLong(sb.toString());

            }
        }