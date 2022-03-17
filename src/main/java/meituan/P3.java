package meituan;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class P3 {

    static class Customer{
        Customer(int x, int y){
            this.x = x;
            this.y = y;
        }
        int x, y;
        boolean isColid(Customer c){
            return ((x & c.x) | (x & c.y) | (y & c.x) | (y & c.y)) == 0;
        }
    }

    static void sln2(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        LinkedList<Customer> customers = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            customers.add(new Customer(scanner.nextInt(), scanner.nextInt()));
        }
        for (int i = 0; i < n; i++){
            LinkedList<Customer> targets = new LinkedList<>();
            targets.add(customers.get(i));
            for (int j = 0; j < n; j++) {

            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        HashSet<HashSet<Customer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Customer newCustomer = new Customer(scanner.nextInt(), scanner.nextInt());
            boolean newSet = true;
            for (HashSet<Customer> hs : set){
                boolean notColid = true;
                for (Customer c : hs){
                    if (c.isColid(newCustomer)){
                        notColid = false;
                        break;
                    }
                }
                if (notColid) {
                    hs.add(newCustomer);
                    newSet = false;
                }
            }
            set.add(new HashSet<>());
        }
        int maxLen = 0;
        for (HashSet<Customer> hs : set){
            maxLen = Integer.max(maxLen, hs.size());
        }
        System.out.println(maxLen);
    }
}
