package jianzhi;

import java.util.Arrays;

public class P3 {
    public int[] countBits(int n) {
        int[] ns = new int[n+1];
        if (n == 0){
            return new int[]{0};
        }
        ns[0] = 0;
        ns[1] = 1;
        for (int i = 2; i < n+1; i++){
            if ((i & 1) == 0){
                ns[i] = ns[i >> 1];
            }
            else {
                ns[i] = ns[i >> 1] + 1;
            }
        }
        return ns;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P3().countBits(3)));
    }
}
