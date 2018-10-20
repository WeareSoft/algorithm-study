package doy.samsung;

import java.util.Scanner;

/* [로봇 청소기] https://www.acmicpc.net/problem/14503
    첫째 줄에 세로 크기 N과 가로 크기 M (3 ≤ N, M ≤ 50)
    둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d (0 : 북쪽, 1 : 동쪽, 2 : 남쪽, 3 : 서쪽)
    셋째 줄부터 N개의 줄에 장소의 상태가 주어짐. 빈 칸은 0, 벽은 1. 장소의 모든 외곽은 벽이다.
    로봇 청소기가 청소하는 칸의 개수를 출력 */
public class Doy_Q14503 {
    static Scanner s = new Scanner(System.in);
    static int n, m, r, c, d, cnt = 0;
    static int[][] map;
    static int[] dX = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dY = {0, 1, 0, -1};

    public static void run() {
        n = s.nextInt();
        m = s.nextInt();
        map = new int[n][m];

        r = s.nextInt();
        c = s.nextInt();
        d = s.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();
            }
        }

        clean(r, c, d);
        System.out.println(cnt);
    }

    // 1. 현재 위치 청소
    private static void clean(int x, int y, int d) {
        map[x][y] = 2;
        cnt++;

        nextClean(x, y, d);
    }

    // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행
    private static void nextClean(int x, int y, int d) {
        int nextX, nextY, nextD = d;

        for (int i = 0; i < 4; i++) {
            // 왼쪽 방향으로 4번 체크
            nextD = (nextD + 3) % 4;
            nextX = x + dX[nextD];
            nextY = y + dY[nextD];

            // 청소할 수 있으면
            if (map[nextX][nextY] == 0) {
                clean(nextX, nextY, nextD); // 청소
                return;
            }
        }

        // 뒤로 후진
        nextD = (d + 2) % 4;
        nextX = x + dX[nextD];
        nextY = y + dY[nextD];

        // 벽 체크
        if (map[nextX][nextY] == 1) {
            return;
        }

        // 후진한 위치 청소, 방향은 그대로
        nextClean(nextX, nextY, d);
    }
}
