package jianzhi;

import java.util.LinkedList;
import java.util.List;

public class P15 {
    public List<Integer> findAnagrams(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        List<Integer> indices = new LinkedList<>();
        if (len1 < len2) {
            return indices;
        }
        int[] sBits = new int[26], pBits = new int[26];
        for (int i = 0; i < len2; i++){
            sBits[s.charAt(i) - 'a'] += 1;
            pBits[p.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < len1 - len2 + 1; i++){
            boolean flag = true;
            for (int j = 0; j < 26; j++){
                flag = flag & ((sBits[j] ^ pBits[j]) == 0);
            }
            if (flag){
                indices.add(i);
            }
            if (i < len1 - len2){
                sBits[s.charAt(i) - 'a'] -= 1;
                sBits[s.charAt(i + len2) - 'a'] += 1;
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        System.out.println(new P15().findAnagrams(
                "abab",
                "ab"
        ));
    }
}
