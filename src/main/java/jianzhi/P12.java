package jianzhi;

public class P12 {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int sumL = 0, sumR = 0;
        for (int i = 1; i < len; i++){
            sumR += nums[i];
        }
        int i = 0;
        while (sumL != sumR){
            i++;
            if (i >= len){
                return -1;
            }
            sumL += nums[i - 1];
            sumR -= nums[i];
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new P12().pivotIndex(new int[]{-1,-1,0,1,1,0}));
    }
}
