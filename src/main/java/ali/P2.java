package ali;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> nums = new ArrayList<>(5);
        int count = 0;
        while (scanner.hasNextInt()){
            for (int i = 0; i < 5; i++) {
                int num = scanner.nextInt();
                try {
                    nums.set(i, num);
                } catch (IndexOutOfBoundsException e){
                    nums.add(num);
                }
            }
            nums.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 < o2 ? -1 : (o1.equals(o2) ? 0 : 1);
                }
            });
            if (nums.get(0) == 1){
                count += 1;
            }
            if (nums.get(2) != 1){
                count += nums.get(1);
            }
            System.out.println(count);
            count = 0;
        }
    }
}
