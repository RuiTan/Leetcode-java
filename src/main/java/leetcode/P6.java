package leetcode;

public class P6 {

    public String convert(String s, int numRows){
        int len = s.length();
        char[] sChars = s.toCharArray();
        char[][] result = new char[numRows][numRows == 1 ? len : (len / (numRows * 2 - 2) + 1) * (numRows-1)];
        int x = 0, y = 0;
        boolean direction = true;
        for (int i = 0; i < len; i++){
            result[y][x] = sChars[i];
            if (numRows == 1){
                x += 1;
            }
            else
            {
                direction = y == 0 || (y != numRows - 1 && direction);
                if (direction){
                    y += 1;
                } else {
                    y -= 1;
                    x += 1;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] chars : result) {
            for (int j = 0; j < result[0].length; j++) {
                if (chars[j] != '\0') {
                    stringBuilder.append(chars[j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P6().convert("C", 2));
    }
}
