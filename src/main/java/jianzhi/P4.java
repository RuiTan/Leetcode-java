package jianzhi;

public class P4 {
    public int singleNumber(int[] nums) {
        final int LEN = 32;
        int[] bits = new int[LEN];
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < LEN; j++){
                bits[32 - j -1] += nums[i] & 1;
                nums[i] = nums[i] >>> 1;
            }
        }
        int result = 0;
        for (int i = 0; i < bits.length; i++){
            if (bits[i] % 3 != 0){
                result |= 1 << (31 - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new P4().singleNumber(new int[]{2,2,3,2}));
    }
}
