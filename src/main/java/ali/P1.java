package ali;

import java.util.HashSet;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int n = Integer.parseInt(scanner.nextLine());
        int n = scanner.nextInt();
        HashSet<String> names = new HashSet<>();
        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            if (name.isEmpty()){
                continue;
            }
            if (name.length() < 6 || name.length() > 12){
                System.out.println("illegal length");
                continue;
            }
            boolean legal = true;
            for (char c : name.toCharArray()){
                if (! ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A'))){
                    legal = false;
                    System.out.println("illegal charactor");
                    break;
                }
            }
            if (names.contains(name)){
                System.out.println("acount existed");
                continue;
            }else{
                names.add(name);
            }
            if (legal)
                System.out.println("registration complete");
        }
    }
}


//    registration complete
//    illegal length
//    acount existed
//    illegal charactor