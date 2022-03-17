package meituan_test;

import java.util.LinkedList;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        while (true){
            x = (a*x + b) % m;
            if (queue.isEmpty()){
                queue.addLast(x);
            }else {
                int first = queue.getFirst();
                if (first == x) {
                    temp.add(queue.removeFirst());
                } else{
                    if (temp.isEmpty()){
                        queue.addLast(x);
                    } else{
                        for (int i : temp) {
                            queue.addFirst(i);
                        }
                        queue.addLast(x);
                    }
                }
            }
            if (queue.isEmpty()){
                break;
            }
        }
        System.out.println(temp.size());
    }
}
