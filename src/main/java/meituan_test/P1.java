package meituan_test;

import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()) != null){
            String[] nums = line.split(" ");
            if (nums.length <= 1){
                System.out.println("0.00");
                continue;
            }
            float n = Float.parseFloat(nums[0]);
            int m = Integer.parseInt(nums[1]);
            if (m == 0) {
                System.out.println("0.00");
            } else {
                float sum = n;
                double temp = n;
                for (int i = 0; i < m - 1; i++) {
                    temp = Math.pow(temp, 0.5);
                    sum += temp;
                }
                System.out.printf("%.2f\n", sum);
            }
        }
    }
}
