package leetcode;

public class P7 {

    public boolean overflow(char[] num) {
        if (num[num.length-1] == '\0') return false;
        char[] max_ = new char[]{'2', '1', '4', '7', '4', '8', '3', '6', '4', '7'};
        if (num[0] == '-') {
            max_[9] = '8';
        }
        for (int i = 0; i < max_.length; i++) {
            int x = num[i+1], y = max_[i] - '0';
            if (x > y){
                return true;
            }else if (x < y){
                return false;
            }
        }
        return false;
    }

    public int reverse(int x) {
        int bit = 1;
        char[] num = new char[11];
        if (x < 0) {
            x = -x;
            num[0] = '-';
        }
        while (true) {
            int remainder = (int) (x % Math.pow(10, bit));
            int r = remainder / (int) Math.pow(10, bit - 1);
            num[bit++] = (char) r;
            if (x - remainder == 0) {
                break;
            }
        }
        if (overflow(num)){
            return 0;
        }
        int result = 0;
        for (int i = bit - 1; i > 0; i--) {
            result += num[i] * (int) Math.pow(10, bit - i - 1);
        }
        return num[0] == '-' ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(new P7().reverse(123));
//        System.out.println(Math.pow(2, 31));
    }
}
