package jianzhi;

public class P19 {
    public boolean validPalindrome(String s) {
        char[] sChars = s.toCharArray();
        int i = 0, j = sChars.length - 1;
        int flag = 0;
        int tempI = 0, tempJ = 0;
        while (i < j){
            if (sChars[i] != sChars[j]){
                if (flag == 2){
                    return false;
                }else{
                    ++flag;
                    if (flag == 1){
                        tempI = i;
                        tempJ = j;
                        ++i;
                    }else {
                        i = tempI;
                        j = tempJ - 1;
                    }
                }
            }else{
                ++i; --j;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new P19().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(new P19().validPalindrome("aba"));
        System.out.println(new P19().validPalindrome("abc"));
    }
}
