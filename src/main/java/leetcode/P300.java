package leetcode;

import java.util.Arrays;

public class P300 {
    public int lengthOfLISDP(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
            max = Integer.max(max, dp[i]);
        }
        // System.out.println(Arrays.toString(dp));
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] heaps = new int[len];
        Arrays.fill(heaps, Integer.MAX_VALUE);
        int currMaxIndex = 0;
        for (int i : nums){
            for (int j = 0; j <= currMaxIndex; j++){
                if (i <= heaps[j]) {
                    heaps[j] = i;
                    if (j == currMaxIndex) ++currMaxIndex;
                    break;
                }
            }
        }
        return currMaxIndex;
    }
}
