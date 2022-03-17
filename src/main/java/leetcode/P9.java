package leetcode;

public class P9 {
    // 转成字符串
//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        int size = String.valueOf(x).length();
//        int a, b;
//        if (size % 2 == 0){
//            a = x / (int) Math.pow(10, (float)(size/2));
//        }else{
//            a = x / ((int) Math.pow(10, (float)(size/2)) * 10);
//        }
//        b = x % (int) Math.pow(10, (float)(size/2));
//        if (a < 10){
//            return a == b;
//        }
//        String as = String.valueOf(a);
//        String bs = String.valueOf(b);
//        for (int i = 0; i < as.length(); i++){
//            int m = a / (int) Math.pow(10, i) % 10;
//            int n = b / (int) Math.pow(10, as.length() - i - 1) % 10;
//            if (m != n) return false;
//        }
//        return true;
//    }
    private int getRevertNumber(int x){
        int y = 0;
        int length = String.valueOf(x).length();
        for (int i = 0; i < length; i++){
            y += x / (int) Math.pow(10, i) % 10 * (int) Math.pow(10, length - i - 1);
        }
        return y;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int size = String.valueOf(x).length();
        int a, b;
        if (size % 2 == 0){
            a = x / (int) Math.pow(10, (float)(size/2));
        }else{
            a = x / ((int) Math.pow(10, (float)(size/2)) * 10);
        }
        b = x % (int) Math.pow(10, (float)(size/2));
        if (a < 10){
            return a == b;
        }
        return b == getRevertNumber(a);
    }

    public static void main(String[] args){
        System.out.println(new P9().isPalindrome(1001));
    }
}
