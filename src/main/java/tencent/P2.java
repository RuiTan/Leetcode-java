package tencent;

import java.util.*;

public class P2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param a int整型ArrayList
     * @param k int整型
     * @param x int整型
     * @return int整型
     */
    public int minMax (ArrayList<Integer> a, int k, int x) {
        // write code here
        PriorityQueue<Integer> queue = new PriorityQueue<>(16, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i: a) {
            queue.add(i);
        }
        for (int i = 0; i < k; i++){
            Integer top = queue.poll();
            top -= x;
            queue.add(top);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(7);
        a.add(2);
        a.add(1);
        System.out.println(new P2().minMax(a, 3, 2));
    }
}
