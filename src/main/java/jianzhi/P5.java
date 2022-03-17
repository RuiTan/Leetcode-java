package jianzhi;

public class P5 {
    private int product(String a, String b){
        int productA = 0x00000000;
        int productB = 0x00000000;
        for (char i : a.toCharArray()){
            productA |= 1 << (i - 'a');
        }

        for (char i : b.toCharArray()){
            productB |= 1 << (i - 'a');
        }
        if ((productA & productB) == 0x00000000){
            return a.length() * b.length();
        }else {
            return 0;
        }
    }

    public int maxProduct(String[] words) {
        int product = 0;
        for (int i = 0; i < words.length; i++){
            for (int j = 0; j < words.length; j++){
                if (i != j){
                    int temp = product(words[i], words[j]);
                    product = Integer.max(temp, product);
                }
            }
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.println(new P5().maxProduct(new String[]{"abcw","baz","foo","bar","fxyz","abcdef"}));
    }
}
