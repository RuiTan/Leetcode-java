package labuladong;

public class Fibonacci {
    int fib(int n){
        if (n == 0 || n == 1){
            return n;
        }
        int dp_i_1 = 1, dp_i_2 = 0, dp_i = 0;
        for (int i = 2; i < n+1; i++) {
            dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fib(6));
    }
}
