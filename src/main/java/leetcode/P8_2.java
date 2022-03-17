package leetcode;

import java.util.Stack;

public class P8_2 {
    public int overflow(char[] num, boolean positive) {
        char[] max_ = new char[]{'2', '1', '4', '7', '4', '8', '3', '6', '4', '7'};
        if (!positive) {
            max_[9] = '8';
        }
        if (num.length > 10){
            return !positive ? (int)-Math.pow(2, 31) : (int)Math.pow(2, 31);
        }
        for (int i = 0; i < max_.length; i++) {
            int x = num[i], y = max_[i];
            if (x > y){
                return !positive ? (int)-Math.pow(2, 31) : (int)Math.pow(2, 31);
            }else if (x < y){
                return Integer.parseInt(new String(num)) * (positive ? 1 : -1);
            }
        }
        return !positive ? (int)-Math.pow(2, 31) : (int)Math.pow(2, 31);
    }

    public int myAtoi(String s) {
        Stack<Character> stack = new Stack<>();
        String[] sStrs = s.split(" ");
        if (sStrs.length == 0){
            return 0;
        }
        int i = 0;
        String s1 = sStrs[i];
        while (s1.isEmpty()) {
            try {
                s1 = sStrs[++i];
            } catch (ArrayIndexOutOfBoundsException e) {
                return 0;
            }
        }
        boolean positive = true;
        if (s1.charAt(0) == '-') {
            s1 = s1.substring(1);
            positive = false;
        } else if(s1.charAt(0) == '+'){
            s1 = s1.substring(1);
            positive = true;
        } else if (s1.charAt(0) >= '0' && s1.charAt(0) <= '9') {
            positive = true;
        } else {
            return 0;
        }
        boolean preZero = true;
        for (Character sC : s1.toCharArray()) {
            if (preZero && sC.equals('0')){
                continue;
            } else if (sC < '0' || sC > '9'){
                break;
            } else if (preZero){
                preZero = false;
            }
            stack.push(sC);
        }
        if (stack.size() <= 0){
            return 0;
        } else if(stack.size() < 10){
            return Integer.parseInt(stackToString(stack)) * (positive ? 1 : -1);
        } else {
            return overflow(stackToString(stack).toCharArray(), positive);
        }
    }

    private String stackToString(Stack<Character> stack){
        StringBuilder stringBuilder = new StringBuilder();
        stack.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P8_2().myAtoi("21474836460"));
    }
}
