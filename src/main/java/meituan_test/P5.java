package meituan_test;

import java.util.Scanner;

public class P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while ((line = scanner.nextLine()) != null && !"".equals(line)){
            int point = 0, start = line.length() - 1, end = 0;
            boolean positive;
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++){
                char c = chars[i];
                if (c == '-'){
                    end = 1;
                }
                if (c == '.'){
                    point = i;
                    start = point - 1;
                }
            }
            StringBuilder sb = new StringBuilder();
            int flag = 0;
            for (int i = start; i >= end; i--){
                if (flag == 3) {
                    sb.append(',');
                    flag = 0;
                }
                sb.append(chars[i]);
                flag++;
            }
            sb.append(end == 0 ? '$' : "$(");
            sb.reverse();
            if (point == 0) {
                sb.append(".00");
            }else {
                sb.append('.');
                flag = 0;
                for (int i = point + 1; i < chars.length; i++){
                    if (flag == 2){
                        break;
                    }
                    sb.append(chars[i]);
                    flag++;
                }
                if (flag == 1){
                    sb.append('0');
                }
                sb.append(end == 0 ? "" : ")");
            }
            System.out.println(sb.toString());
        }
    }
}