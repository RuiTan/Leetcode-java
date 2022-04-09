package leetcode;

import java.util.Arrays;

public class P322 {
    int recursion(int[] coins, int amount){
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins){
            int subProblem = recursion(coins, amount - coin);
            if (subProblem == -1){
                continue;
            }
            res = Integer.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public int coinChange(int[] coins, int amount){
//        return recursion(coins, amount);
        return dpTable(coins, amount);
    }

    public int coinChangeDP(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            dp[i] = -1;
            for (int c : coins){
                if (i < c || dp[i-c] == -1) continue;
                dp[i] = dp[i] == -1 ? dp[i-c] + 1 : Integer.min(dp[i-c]+1, dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    int dpTable(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        // base case
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++){
            for (int c : coins){
                if (i < c) continue;
                dp[i] = Integer.min(dp[i], dp[i-c] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
//        System.out.println(new CoinChange().coinChange(new int[]{1, 5}, 21));
        System.out.println(new P322().coinChangeDP(new int[]{2}, 3));
    }
}
