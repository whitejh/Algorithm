import java.util.Arrays;
import java.io.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int result = 1;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j <i;j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

//class Solution {
//    public int lengthOfLIS(int[] nums) {
//        int[] tails = new int[nums.length];
//        int size = 0;
//
//        for (int num : nums) {
//
//            int left = 0;
//            int right = size;
//
//            while (left < right) {
//                int mid = (left + right) / 2;
//
//                if (tails[mid] < num)
//                    left = mid + 1;
//                else
//                    right = mid;
//            }
//
//            tails[left] = num;
//
//            if (left == size)
//                size++;
//        }
//
//        return size;
//    }
//}