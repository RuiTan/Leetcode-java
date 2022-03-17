package jianzhi;

public class P18 {
    private boolean isValidChar(char c){
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
    public boolean isPalindrome(String s) {
        char[] sChars = s.toCharArray();
        for (int i = 0, j = sChars.length-1; i < j; ++i, --j){
            while (!isValidChar(s.charAt(i)) && i < j){
                ++i;
            }
            while (!isValidChar(s.charAt(j)) && j > i){
                --j;
            }
            if (i >= j || i > sChars.length - 1){
                return true;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P18().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new P18().isPalindrome(".,"));
    }
}
