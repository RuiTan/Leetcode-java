package jianzhi;

import java.util.Arrays;

public class P8 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int sum = nums[0];
        int len = 0;
        while (i <= j){
            if (sum < target){
                j++;
                if (j >= nums.length){
                    return len;
                }
                sum += nums[j];
            }else {
                len = len == 0 ? j-i+1 : Integer.min(j-i+1, len);
                sum -= nums[i];
                i++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
//        System.out.println(new leetcode.P8().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(new P8().minSubArrayLen(11
                , new int[]{1,1,1,1,1,1,1,1}));
    }
}
