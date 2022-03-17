package jianzhi;

public class P17 {
    private static final int LEN = 64;
    private boolean contains(int[] bitS, int[] bitT){
        for (int i = 0; i < LEN; i++){
            if (bitS[i] - bitT[i] < 0){
                return false;
            }
        }
        return true;
    }
    public String minWindow(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if (len1 < len2) {
            return "";
        }
        final char base = 'A';
        int index = 0, minLen = 0x7fffffff;
        int i = 0, j = len2 - 1;
        int[] bitS = new int[LEN], bitT = new int[LEN];
        for (int k = 0; k < len2; k++){
            bitS[s.charAt(k) - base] += 1;
            bitT[t.charAt(k) - base] += 1;
        }
        while (j < len1){
            if (i > j - len2 + 1){
                j++;
            }
            else if (contains(bitS, bitT)){
                if (minLen > j - i + 1){
                    index = i;
                    minLen = j - i + 1;
                }
                bitS[s.charAt(i) - base] -= 1;
                i++;
            }else{
                j++;
                if (j < len1){
                    bitS[s.charAt(j) - base] += 1;
                }
            }
        }
        return minLen == 0x7fffffff ? "" : s.substring(index, index + minLen);
    }

    public static void main(String[] args) {
//        System.out.println(new P17().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new P17().minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
