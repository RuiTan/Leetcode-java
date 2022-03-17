package jianzhi;

import java.util.*;

public class P7 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3){
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        int sum = 0;
        List<List<Integer>> result = new LinkedList<>();
        int i = 0;
        while (i < nums.length){
            int k = i+1, j = nums.length-1;
            while (k < j){
                if (i != k && i != j){
                    if (nums[k] + nums[j] + nums[i] == 0){
                        result.add(Arrays.asList(nums[i], nums[k], nums[j]));
                        int temp = nums[k];
                        while (temp == nums[k] && k < j){
                            k++;
                        }
                    }else if (nums[k] + nums[j] + nums[i] < 0){
                        k++;
                    }else{
                        j--;
                    }
                }
            }
            int temp = nums[i];
            while (i < nums.length && temp == nums[i] && i < k){
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P7().threeSum(new int[]{0, 0, 0, 0}));
    }
}
