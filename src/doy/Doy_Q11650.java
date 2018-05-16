package doy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Doy_Q11650 {
    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if(this.x > p.x) {
                return 1;
            }
            else if(this.x == p.x) {
                if(this.y > p.y) {
                    return 1;
                }
            }
            return -1;
        }
    }
    public static Scanner s = new Scanner(System.in);
    public static void run() {
        int t = s.nextInt();
        List<Point> pointList = new ArrayList<>();

        for(int i=0; i<t; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            pointList.add(new Point(x, y));
        }

        Collections.sort(pointList);

        for(int i=0; i<t; i++){
            System.out.println(pointList.get(i).x + " " + pointList.get(i).y);
        }
    }
}
