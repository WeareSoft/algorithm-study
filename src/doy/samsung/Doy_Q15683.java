package doy.samsung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* [감시] https://www.acmicpc.net/problem/15683
    0은 빈 칸, 6은 벽, 1~5는 CCTV
    사무실의 크기와 상태, 그리고 CCTV의 정보가 주어졌을 때, CCTV의 방향을 적절히 정해서, 사각 지대의 최소 크기 구하기 */
public class Doy_Q15683 {
    static Scanner s = new Scanner(System.in);
    static int n, m, res = Integer.MAX_VALUE;
    static int[][] map;
    static final int UP = 0, LEFT = 1, DOWN = 2, RIGHT = 3;
    static ArrayList<CCTV> CCTVList = new ArrayList<>();

    static class CCTV {
        int x, y, num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void run() {
        n = s.nextInt();
        m = s.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();
                if (1 <= map[i][j] && map[i][j] <= 5) {
                    CCTVList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        search(0, map);
        System.out.println(res);
    }

    private static void search(int count, int[][] visited) {
        if (count == CCTVList.size()) {
            int zeroCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (visited[i][j] == 0) {
                        zeroCount++;
                    }
                }
            }
            res = Math.min(res, zeroCount);
        } else {
            CCTV cctv = CCTVList.get(count);
            int x = cctv.x;
            int y = cctv.y;
            int cctvNum = cctv.num;
            int[][] newVisited = new int[n][m];

            switch (cctvNum) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        copyArray(newVisited, visited);
                        detect(newVisited, x, y, i);
                        search(count + 1, newVisited);
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        copyArray(newVisited, visited);
                        detect(newVisited, x, y, i);
                        detect(newVisited, x, y, i + 2);
                        search(count + 1, newVisited);
                    }
                    break;
                case 3:
                    for (int i = 0; i < 4; i++) {
                        copyArray(newVisited, visited);
                        detect(newVisited, x, y, i);
                        detect(newVisited, x, y, (i + 1) % 4);
                        search(count + 1, newVisited);
                    }
                    break;
                case 4:
                    for (int i = 0; i < 4; i++) {
                        copyArray(newVisited, visited);
                        detect(newVisited, x, y, i);
                        detect(newVisited, x, y, (i + 1) % 4);
                        detect(newVisited, x, y, (i + 2) % 4);
                        search(count + 1, newVisited);
                    }
                    break;
                case 5:
                    copyArray(newVisited, visited);
                    for (int i = 0; i < 4; i++) {
                        detect(newVisited, x, y, i);
                    }
                    search(count + 1, newVisited);
                    break;
            }
        }
    }

    private static void detect(int[][] visited, int x, int y, int direction) {
        switch (direction) {
            case UP:
                for (int i = y; i >= 0; i--) {
                    if (map[x][i] == 6) {
                        break;
                    }
                    visited[x][i] = -1;
                }
                break;
            case LEFT:
                for (int i = x; i >= 0; i--) {
                    if (map[i][y] == 6) {
                        break;
                    }
                    visited[i][y] = -1;
                }
                break;
            case DOWN:
                for (int i = y; i < m; i++) {
                    if (map[x][i] == 6) {
                        break;
                    }
                    visited[x][i] = -1;
                }
                break;
            case RIGHT:
                for (int i = x; i < n; i++) {
                    if (map[i][y] == 6) {
                        break;
                    }
                    visited[i][y] = -1;
                }
                break;
        }
    }

    private static void copyArray(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < n; i++) {
            arr1[i] = Arrays.copyOf(arr2[i], m);
        }
    }
}
