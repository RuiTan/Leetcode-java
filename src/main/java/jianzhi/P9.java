package jianzhi;

public class P9 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int product = nums[0];
        int i = 0, j = 0;
        while (i <= j){
            if (product < k){
                count += j - i + 1;
                if (j < nums.length - 1){
                    ++j;
                    product *= nums[j];
                }else {
                    break;
                }
            }else{
                product /= nums[i];
                ++i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new P9().numSubarrayProductLessThanK(
                new int[]{1,2,3}, 0
        ));
    }
}
