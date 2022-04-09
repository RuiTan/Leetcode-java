package leetcode;

import java.util.Arrays;

public class P1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
        int[][] dp = new int[len1][len2];
        dp[len1-1][len2-1] = chars1[len1-1] == chars2[len2-1] ? 1 : 0;
        for (int i = len1 - 2; i >= 0; i--){
            if (chars1[i] == chars2[len2-1]) dp[i][len2-1] = 1;
            else dp[i][len2-1] = dp[i+1][len2-1];
        }
        for (int i = len2 - 2; i >= 0; i--){
            if (chars1[len1-1] == chars2[i]) dp[len1-1][i] = 1;
            else dp[len1 - 1][i] = dp[len1-1][i+1];
        }
        for (int i = len1 - 2; i >= 0; i--) {
            for (int j = len2 - 2; j >= 0; j--) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Integer.max(dp[i+1][j],
                            Integer.max(dp[i][j+1], dp[i+1][j+1]));
                }
            }
        }
        for (int[] d : dp)
            System.out.println(Arrays.toString(d));
        return dp[0][0];
    }

    private int[][] dpTable;
    private char[] chars1, chars2;
    private int len1, len2;

    private int dp(int i, int j) {
        if (dpTable[i][j] != -1){
            return dpTable[i][j];
        }
        if (i == len1 - 1 && j == len2 - 1){
            if (chars1[len1 - 1] == chars2[len2 - 1]) dpTable[i][j] = 1;
            else dpTable[i][j] = 0;
        }
        if (i == len1 - 1) {
            if (chars1[i] == chars2[j] || dp(i, j+1) == 1) dpTable[i][j] = 1;
            else dpTable[i][j] = 0;
        }
        if (j == len2 - 1) {
            if (chars1[i] == chars2[j] || dp(i+1, j) == 1) dpTable[i][j] = 1;
            else dpTable[i][j] = 0;
        }
        if (chars1[i] == chars2[j]) {
            dpTable[i][j] = dp(i+1, j+1) + 1;
        } else {
            dpTable[i][j] = Integer.max(dp(i+1, j),
                    Integer.max(dp(i, j+1), dp(i+1, j+1)));
        }
        return dpTable[i][j];
    }

    public int longestCommonSubsequenceRecursion(String text1, String text2) {
        len1 = text1.length();
        len2 = text2.length();
        chars1 = text1.toCharArray();
        chars2 = text2.toCharArray();
        dpTable = new int[len1][len2];
        for (int[] elem : dpTable)
            Arrays.fill(elem, -1);
        return dp(0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new P1143().longestCommonSubsequence("abcde", "ace"));
    }
}
