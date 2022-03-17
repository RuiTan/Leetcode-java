package jianzhi;

public class P14 {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2){
            return false;
        }
        int[] s1Bit = new int[26];
        int[] s2Bit = new int[26];
        for (int i = 0; i < len1; i++){
            s1Bit[s1.charAt(i) - 'a'] += 1;
            s2Bit[s2.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < len2 - len1 + 1; i++){
            if (i >= 1){
                s2Bit[s2.charAt(i-1) - 'a'] -= 1;
                s2Bit[s2.charAt(i+len1-1) - 'a'] += 1;
            }
            boolean flag = false;
            for (int j = 0; j < 26; j++){
                flag = ((s1Bit[j] ^ s2Bit[j]) == 0x00000000);
                if (!flag){
                    break;
                }
            }
            if (flag){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new P14().checkInclusion("ab", "eidbaooo"));
        System.out.println(new P14().checkInclusion("dbb", "ccc"));
        System.out.println(new P14().checkInclusion("hello", "ooolleoooleh"));
    }
}
