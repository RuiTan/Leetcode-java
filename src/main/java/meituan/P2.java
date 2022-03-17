package meituan;

import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] list = new int[n];
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            list[i] = scanner.nextInt();
        }
        if (list[0] == 1){
            dp[0][0] = 1;
        }else {
            dp[0][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (list[i] == 1){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1];
            }else{
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0] + 1;
            }
        }
        long res = 0L;
        for (int i = 0; i < n; i++) {
            res += dp[i][0];
        }
        System.out.println(res);
    }
}
