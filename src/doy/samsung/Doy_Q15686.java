package doy.samsung;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* [치킨 배달] https://www.acmicpc.net/problem/15686
   0은 빈 칸, 1은 집, 2는 치킨집
   폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최소값 */
public class Doy_Q15686 {
    static Scanner s = new Scanner(System.in);
    static int mapSize, chickenNum, res = Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> houseList = new ArrayList<>(); // 집 리스트
    static List<Point> chickenList = new ArrayList<>(); // 치킨집 리스트
    static boolean[] selected; // 치킨집 선택여부를 저장하는 배열

    public static void run() {
        mapSize = s.nextInt();
        chickenNum = s.nextInt();
        map = new int[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = s.nextInt();
                if (map[i][j] == 1) houseList.add(new Point(i, j));
                else if (map[i][j] == 2) chickenList.add(new Point(i, j));
            }
        }
        selected = new boolean[chickenList.size()];

        searchChicken(0, 0);
        System.out.println(res);
    }

    private static void searchChicken(int idx, int depth) {
        // chickenNum 개의 치킨집이 선택되었으면
        if (depth == chickenNum) {
            calcCityChickenDistance();
        } else {
            // 다음 치킨집 선택
            for (int i = idx; i < chickenList.size(); i++) {
                // idx 번째 치킨집 선택
                selected[i] = true;
                searchChicken(i + 1, depth + 1);
                // backtracking
                selected[i] = false;
            }
        }
    }

    // 도시의 치킨 거리 : 집과 chickenNum 의 개수만큼 선택된 치킨집과의 최소 거리들의 합 계산
    private static void calcCityChickenDistance() {
        int sum = 0;
        for (Point house : houseList) {
            int minDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chickenList.size(); i++) {
                // selected true 인 치킨집만 거리 계산
                if (!selected[i]) continue;
                Point chicken = chickenList.get(i);
                int distance = getDistance(house, chicken);
                // 치킨집 중 제일 최단 거리 저장
                minDistance = Math.min(minDistance, distance);
            }
            sum += minDistance;
        }
        res = Math.min(res, sum);
    }

    // 집과 치킨집의 거리 계산
    private static int getDistance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
