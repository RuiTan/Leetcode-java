package tencent;

import java.math.BigInteger;
import java.util.BitSet;

public class P1 {

    BigInteger sum = BigInteger.valueOf(0);

    private void dfs(int step, int n, int m){
        if (m == 1) {
            sum = sum.add(BigInteger.ONE);
            return;
        }
        for (int i = step; i < n/m; i++) {
            dfs(i, n-i, m-1);
        }
    }

    private void combine(int n, int k){
        if (n<k*2)
            return;
        if (n == k*2)
            sum = sum.add(BigInteger.ONE);
        for (int i = 2; i < n-2*(k-1)+1; i++) {
            combine(n-i, k-1);
        }
    }

    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(n));
        }
        return result;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @param k int整型
     * @return int整型
     */
    public int numsOfStrings (int n, int k) {
        // write code here
        int NUM = 26;
        if (k == 1) {
            return NUM;
        }
        int repeat = n - k - k;
        BigInteger count = BigInteger.valueOf(NUM);
        for (int i = 0; i < k - 1; i++){
            count = count.multiply(BigInteger.valueOf(NUM - 1));
        }
//        BigInteger range = factorial(k).multiply(factorial(repeat-k)).divide(factorial(repeat));
//         BigInteger range = BigInteger.valueOf(1);
//        BigInteger range = factorial(repeat + k - 1).divide(factorial(repeat).multiply(factorial(k-1)));
//         range = range.add(temp);
//        dfs(0, k, repeat);
        combine(n, k);
        return count.multiply(sum).mod(BigInteger.valueOf(1000000)).intValue();
    }

    public static void main(String[] args) {
        System.out.println(new P1().numsOfStrings(5, 2));
    }
}
