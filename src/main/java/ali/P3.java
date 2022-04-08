package ali;

import java.util.*;

public class P3 {

    private static int generate(int n){
        int[] ns = new int[n];
        ns[0] = 1; ns[1] = 1;
        if (n >= 2){
            for (int i = 2; i<n; i++){
                ns[i] = ns[i-1] + i/2;
            }
        }
        return ns[n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        HashMap<Long, Integer> ks = new HashMap<>();
        int flag = 0;
        int a = 0, b = 0, c = 0;
        while (scanner.hasNextInt()){
            if (scanner.hasNextInt()){
                a = scanner.nextInt();
            }
            if (scanner.hasNextInt()){
                b = scanner.nextInt();
            }
            if (scanner.hasNextInt()){
                c = scanner.nextInt();
            }
//            int , b = scanner.nextInt(), c = scanner.nextInt();
            long k = (long) a / (long) b;
            if (ks.size() == 0){
                ks.put(k, 1);
            }else if (ks.size() < 2 && ks.containsKey(k)){
                ks.put(k, ks.get(k) + 1);
            }
            else if (ks.size() < 2 && !ks.containsKey(k)){
                count = 1;
                ks.put(k, 1);
            } else if (ks.size() >= 2){
                if (ks.containsKey(k)){
                    ks.put(k, ks.get(k) + 1);
                } else{
                    ks.put(k, 1);
                }
            }
        }

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(ks.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Long, Integer>>() {
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        n = generate(ks.size());
        System.out.println(n);
    }
}
