package doy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Doy_Q11650 {
    // 2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
    // 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
    // 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
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


/*
    오호. 저는 Point 클래스를 그대로 사용했는데 아예 커스텀으로 Point 클래스를 만든게 다르네요.
    근데 compareTo(Point p) 내용은 똑같아보입니다~
    그리고 List<Point> pointList = new ArrayList<>();와 ArrayList<Point> pointList = new ArrayList<>();가 
    어떤 경우에 사용되는지의 차이를 찾아서 다음에 공유하면 좋을 거 같아요 :)
*/
