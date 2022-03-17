package jianzhi;

public class P20 {
    private int countPalindrome(String s, int i, int j){
        int count = 0;
        while (j >= 0 && i < s.length() && s.charAt(i) == s.charAt(j)){
            ++count;
            ++i;
            --j;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++){
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i+1);
        }
        return count + 1;
    }

    public static void main(String[] args) {
//        System.out.println(new P20().countSubstrings("abc"));
        System.out.println(new P20().countSubstrings("aaa"));
    }
}
