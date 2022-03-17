package jianzhi;

public class P2 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int c = 0;
        int len = Math.min(lenA, lenB);
        for (int i = 0; i < len; i++){
            int j = ca[lenA - i - 1] - '0', k = cb[lenB - i - 1] - '0';
            sb.append((c + j + k) & 1);
            c = (c + j + k) > 1 ? 1 : 0;
        }
        if (c == 1){
            if (lenA == lenB){
                return "1" + sb.reverse();
            }
            else {
                char[] rest = lenA > lenB ? a.substring(0, lenA - len).toCharArray() : b.substring(0, lenB - len).toCharArray();
                int restL = lenA > lenB ? lenA - len : lenB - len;
                StringBuilder restSB = new StringBuilder();
                for (int i = 0; i < restL; i++){
                    int j = rest[restL - i - 1] - '0';
                    restSB.append((c + j) & 1);
                    c = (c + j) > 1 ? 1 : 0;
                }
                if (c == 1){
                    restSB.append(1);
                }
                return restSB.reverse().append(sb.reverse()).toString();
            }
        }
        else {
            return lenA > lenB ? a.substring(0, lenA - len) + sb.reverse() : b.substring(0, lenB-len) + sb.reverse();
        }
    }

    public static void main(String[] args) {
        System.out.println(new P2().addBinary("101111", "10"));
    }
}
