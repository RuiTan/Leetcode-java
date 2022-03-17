package jianzhi;

public class P16 {
    private long[] charToLongBit(char c, long[] longBits){
        if (c < 64){
            longBits[0] |= 1L << c;
        }else{
            longBits[1] |= 1L << (c - 64);
        }
        return longBits;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        long[] bits = charToLongBit(s.charAt(0), new long[2]);
        int i = 0, j = 1;
        int maxLen = 1;
        while (j < s.length() && i <= j){
            long[] b = charToLongBit(s.charAt(j), new long[2]);
            if (((b[0] & bits[0]) == 0) && ((b[1] & bits[1]) == 0)){
                bits[0] |= b[0];
                bits[1] |= b[1];
                j++;
            }else{
                b = charToLongBit(s.charAt(i), new long[2]);
                bits[0] ^= b[0];
                bits[1] ^= b[1];
                i++;
            }
            maxLen = Integer.max(j-i, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new P16().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new P16().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new P16().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new P16().lengthOfLongestSubstring("au"));
        System.out.println(new P16().lengthOfLongestSubstring("aabaab!bb"));
    }
}
