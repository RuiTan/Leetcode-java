package meituan_test;

import java.util.LinkedList;
import java.util.Scanner;

public class P4 {
    static class Point{
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        int x, y;
        boolean top, bottom, left, right;

        boolean isLucky(){
            return top & bottom & left & right;
        }
    }

    static LinkedList<Point> points = new LinkedList<>();

    static void checkPoints(Point p){
        for (Point i : points) {
            int x_ = p.x - i.x;
            int y_ = p.y - i.y;
            if (x_ < 0 && y_ == 0){
                p.right = true;
                i.left = true;
            } else if (x_ > 0 && y_ == 0){
                p.left = true;
                i.right = true;
            } else if (x_ == 0 && y_ < 0){
                p.top = true;
                i.bottom = true;
            } else if (x_ == 0 && y_ > 0){
                p.bottom = true;
                i.top = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Point p = new Point(scanner.nextInt(), scanner.nextInt());
            checkPoints(p);
            points.add(p);
        }
        int count = 0;
        for (Point p : points){
            if (p.isLucky()){
                count += 1;
            }
        }
        System.out.println(count);
    }
}
