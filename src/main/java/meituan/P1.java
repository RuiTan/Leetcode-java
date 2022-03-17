package meituan;

import java.math.BigInteger;
import java.util.Scanner;

public class P1 {

    static boolean isLuckyNum(String num){
        BigInteger bigNum = new BigInteger(num);
        BigInteger remainder = bigNum.divideAndRemainder(new BigInteger(String.valueOf(11)))[1];
        boolean cond1 = remainder.equals(new BigInteger("0"));
        boolean cond2 = false;
        int count = 0;
        for (char i : num.toCharArray()){
            if (i == '1'){
                count++;
            }
            if (count == 2){
                break;
            }
        }
        cond2 = count == 2;
        return cond1 | cond2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String num = scanner.nextLine();
            System.out.println(isLuckyNum(num) ? "yes" : "no");
        }
    }
}
