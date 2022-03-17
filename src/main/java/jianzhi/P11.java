package jianzhi;

import java.util.HashMap;
import java.util.Map;

public class P11 {
    public int findMaxLength(int[] nums) {
        int maxLen = 0, sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++){
            nums[i] = nums[i] == 0 ? -1 : 1;
        }
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        for (int i = 0; i < len; i++){
            sum += nums[i];
            if (sumToIndex.containsKey(sum)){
                maxLen = Integer.max(i - sumToIndex.get(sum), maxLen);
            }else{
                sumToIndex.put(sum, i);
            }
        }
        return maxLen;
    }
}
