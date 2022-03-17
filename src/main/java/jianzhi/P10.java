package jianzhi;

import java.util.HashMap;
import java.util.Map;

public class P10 {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P10().subarraySum(new int[]{1,2,3}, 3));
    }
}
