import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);
            long left = 0;

            // times 배열의 최악의 경우는 범위
            // n명 기준으로 times의 가장 마지막 시간까지 탐색하는 경우
            long right = times[times.length - 1] * (long) n;

            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = 0;

                for (int time : times) {
                    sum += mid / time;
                }

                if (sum < n) // 해당 시간에는 모든 사람이 검사받을 수 없다.
                    left = mid + 1;
                else {
                    right = mid - 1;
                    answer = mid; // 모두 검사받았으나, 더 최솟값이 있을 수 있다.
                }
            }
            return answer;
        }
}