package meituan_test;

import java.util.HashSet;
import java.util.Scanner;

public class P2 {

    static HashSet<Integer> set = new HashSet<>();

    private static boolean isSX(int num){
        char[] nums = String.valueOf(num).toCharArray();
        Long sum = 0L;
        for (int i = 0; i < 3; i++) {
            sum += (long) Math.pow(nums[i] - '0', 3);
        }
        return sum.equals((long) num);
    }

    private static void calcAndSave(){
        for (int i = 100; i < 1000; i++) {
            if (isSX(i)){
                set.add(i);
            }
        }
    }

    public static void main(String[] args) {
        calcAndSave();
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()) != null){
            String[] nums = line.split(" ");
            int n = Integer.parseInt(nums[0]), m = Integer.parseInt(nums[1]);
            boolean no = true;
            for (int i = n; i < m; i++) {
                if (set.contains(i)){
                    System.out.print(i + " ");
                    no = false;
                }
            }
            if (no){
                System.out.println("no");
            } else{
                System.out.println();
                String a = "11";
                a += 1;
            }
        }
    }
}
