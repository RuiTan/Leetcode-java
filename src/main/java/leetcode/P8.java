package leetcode;

public class P8 {

    // 还要考虑前导0
    public boolean overflow(char[] num) {
        if (num.length < 11) return false;
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

    public int myAtoi(String s) {
        char[] sChars = s.toCharArray();
        if (sChars.length <= 0){
            return 0;
        }
        int i = 0;
        char head = sChars[0];
        while (head == ' '){
            if (i == sChars.length - 1){
                return 0;
            }
            head = sChars[++i];
        }
        if (head != '-' && head != '+' && (head > '9' || head < '0')){
            return 0;
        }
        int j = i;
        boolean tail = false;
        if (head == '+' || head == '-'){
            j++;
        }
        if (j > sChars.length - 1){
            return 0;
        }
        while (sChars[j] <= '9' && sChars[j] >= '0'){
            if (j == sChars.length - 1){
                tail = true;
                j++;
                break;
            }
            ++j;
        }
        if (j - i == 1 && (sChars[i] == '+' || sChars[i] == '-')){
            return 0;
        }
        boolean negative = sChars[i] == '-';
        String check = tail ? s.substring(i) : s.substring(i, j);
        boolean overflow = overflow(sChars[i] != '+' && sChars[i] != '-' ? ("+" + check).toCharArray(): check.toCharArray());
        if (overflow){
            return negative ? (int)-Math.pow(2, 31) : (int)Math.pow(2, 31);
        }

        j = tail ? sChars.length : j;
        i = (sChars[i] == '+' || sChars[i] == '-') ? i+1 : i;
        int sum = 0;
        for (int k = j-i-1; k >= 0; k--){
            sum += (int) Math.pow(10, k) * (sChars[i++] - '0');
        }
        return negative ? -sum : sum;
    }


    public static void main(String[] args){
        System.out.println(new P8().myAtoi("+1"));
    }
}
