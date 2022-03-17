package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P5 {
    private boolean isPalindrome(String s) {
        int sLength = s.length();
        if (sLength % 2 == 0) {
            return s.substring(0, sLength / 2).contentEquals(new StringBuffer(s.substring(sLength / 2)).reverse());
        } else {
            return s.substring(0, sLength / 2).contentEquals(new StringBuffer(s.substring(sLength / 2 + 1)).reverse());
        }
    }

    public String longestPalindrome_timeLimitExceeded(String s) {
        char[] sChars = s.toCharArray();
        int maxLength = 0;
        String longestPalindromeString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (sChars[i] == sChars[j] && isPalindrome(s.substring(i, j + 1))) {
                    String sub = s.substring(i, j + 1);
                    if (maxLength < sub.length()) {
                        longestPalindromeString = s.substring(i, j + 1);
                    }
                    maxLength = Math.max(maxLength, sub.length());
                }
            }
        }
        return longestPalindromeString;
    }

    /**
     * 动态规划，时间n^2，空间n^2
     */
    public String longestPalindrome_DP(String s) {
        int len = s.length();
        int maxLen = 1;
        int start = 0;
        boolean[][] states = new boolean[len][len];
        char[] sChars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            states[i][i] = true;
        }
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len - 1; i++) {
                int j = L + i - 1;
                if (j > len - 1) {
                    break;
                }
                if (sChars[i] != sChars[j]) {
                    states[i][j] = false;
                } else {
                    states[i][j] = j - i < 3 || states[i + 1][j - 1];
                }
                if (states[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    /**
     * 中心扩散，时间n^2，空间1
     */
    public String longestPalindrome_CenterSpread(String s) {
        int len = s.length();
        int maxLen = 1;
        int start = 0;
        char[] sChars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            int l1 = expandMaxLen(sChars, i, i);
            int l2 = expandMaxLen(sChars, i, i + 1);
            if (l1 <= maxLen && l2 <= maxLen) {
                continue;
            }
            if (l1 > l2) {
                maxLen = l1;
                start = i - (l1 - 1) / 2;
            }else {
                maxLen = l2;
                start = i - l2/2 + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expandMaxLen(char[] sChars, int left, int right) {
        while (left >= 0 && right <= sChars.length-1 && sChars[left] == sChars[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private String padding(String s){
        StringBuilder sb = new StringBuilder();
        for (char i : s.toCharArray()){
            sb.append('#').append(i);
        }
        sb.append('#');
        return sb.toString();
    }

    private int expand(String S, int i, int l){
        while (true){
            if (i - l < 0 || i + l >= S.length())
                break;
            if (S.charAt(i-1) == S.charAt(i+1))
                l++;
            else
                break;
        }
        return l-1;
    }

    private String manacher(String S){
        S = padding(S);
        Integer[] p = new Integer[S.length()];
        int C = 0, R = 0;
        for (int i=0; i<S.length(); i++){
            if (i >= R)
                p[i] = expand(S, i, 1);
            else{
                int i_m = 2*C-i;
                if (p[i_m] + i >= R){
                    p[i] = expand(S, i, R-i+1);
                }
                else{
                    if (i_m-p[i_m] <= 0){
                        p[i] = expand(S, i, p[i_m]+1);
                    }else{
                        p[i] = p[i_m];
                    }
                }
            }
            if (i+p[i] >= R){
                R = i+p[i];
                C=i;
            }
        }
        List<Integer> pl = new ArrayList<Integer>();
        Collections.addAll(pl, p);
        int m = Collections.max(pl);
        int m_i = pl.indexOf(m);
        StringBuilder sb = new StringBuilder().append(S.charAt(m_i));
        for (int i = 0; i < m; i++){
            sb.append(S.charAt(m_i-i-1));
        }
        String result = sb.toString(), resultReverse = new StringBuffer(result).reverse().toString();
        result = resultReverse.substring(0, resultReverse.length()-1) + result;
        sb = new StringBuilder();
        for (String a : result.split("#")){
            sb.append(a);
        }
        return sb.toString();
    }


    public String longestPalindrome(String s){
        return manacher(s);
    }

    public static void main(String[] args) {
        System.out.println(new P5().longestPalindrome("cbbd"));
    }
}
