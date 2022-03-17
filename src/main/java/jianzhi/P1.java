package jianzhi;

/**
 * @author tanrui
 */
public class P1 {
    public int divide(int a, int b) {
        int i = -1;
        int count = -1;
        boolean sign = (a < 0 && b < 0) || (a > 0 && b > 0);
        boolean signA = a < 0;
        boolean signB = b < 0;
        if(a == Integer.MIN_VALUE && b == 1){
            return Integer.MIN_VALUE;
        } else if (a == Integer.MIN_VALUE && b == -1){
            return Integer.MAX_VALUE;
        }
        a = signA ? a : -a;
        b = signB ? b : -b;
        while (a <= 0){
            int value = b;
            int k = 1;
            while (value >= - 1 << 30 && a <= value + value) {
                value += value;
                if (k >= 1 << 30) {
                    return Integer.MIN_VALUE;
                }
                k += k;
            }
            a -= value;
            count += k;
        }
        return sign ? count : -count;
    }
    public static void main(String[] args) {
        System.out.println(new P1().divide(Integer.MIN_VALUE, -1));
    }
}
