package meituan;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int max = (1 << n) - 1;
        int[] rooms = new int[m];
        for (int i = 0; i < m; i++) {
            rooms[i] = scanner.nextInt();
        }
        int bit = 0x00000001;
//        int bit = max ^ (1 << rooms[rooms.length - 1] - 1);
        int count = 0;
        String bitStr, nowStr;
        for (int i = 0; i < rooms.length; i++){
            int now = 1 << (rooms[i] - 1);
            if ((now ^ bit) == 0) {
                bit = max - now;
                count++;
            }else {
                bitStr = Integer.toBinaryString(bit);
                nowStr = Integer.toBinaryString(now);
                if (bitStr.length() >= nowStr.length() && bitStr.charAt(bitStr.length() - nowStr.length()) == '1'){
                    bit -= 1<<(nowStr.length() - 1);
                }
            }
        }
        System.out.println(count);
    }
}
