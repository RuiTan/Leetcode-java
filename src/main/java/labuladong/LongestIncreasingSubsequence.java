package labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    int lengthOfLIS(int[] nums){
        if (nums.length == 1){
            return 1;
        }
        Integer[] dp = new Integer[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Collections.max(Arrays.asList(dp));
    }

    int count = 0;

    void binarySearch(int[] tops, int elem){
        int left = 0, right = count - 1;
        if (count == 0){
            tops[0] = elem;
            count++;
            return;
        }
        if (elem > tops[right]) {
            tops[count] = elem;
            count++;
            return;
        }
        if (elem < tops[0]) {
            tops[0] = elem;
            return;
        }
        if (count == 1) {
            if (elem < tops[0]) {
                tops[0] = elem;
            }else {
                tops[1] = elem;
            }
            return;
        }
        int mid = (right + left) / 2;
        while (left < right){
            if (tops[mid] < elem){
                left = mid + 1;
            }else {
                right = mid;
            }
            mid = (right + left) / 2;
        }
        tops[left] = elem;
    }

    int lengthOfLISBinary(int[] nums){
        if (nums.length == 1){
            return 1;
        }
        int[] tops = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            binarySearch(tops, nums[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingSubsequence().lengthOfLISBinary(new int[]{3,5,6,2,5,4,19,5,6,7,12}));
    }
}
