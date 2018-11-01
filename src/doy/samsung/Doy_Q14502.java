package doy.samsung;

import java.util.Arrays;
import java.util.Scanner;

/* [연구소] https://www.acmicpc.net/problem/14502 */
public class Doy_Q14502 {
    static Scanner s = new Scanner(System.in);
    static int n, m, res = 0;
    static int[][] map, tmpMap;
    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void run() {
        n = s.nextInt();
        m = s.nextInt();
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = s.nextInt();
            }
        }

        // 세울 수 있는 벽의 위치 모든 조합 탐색
        dfs(0, 0);

        System.out.println(res);
    }

    private static void dfs(int x, int count) {
        // 벽을 3개 세우면
        if (count == 3) {
            // 바이러스 퍼뜨리기
            // 모든 벽의 위치에 대해 각각 퍼뜨려야 하므로 tmpMap에 현재 map을 복사해 바이러스 퍼뜨림
            tmpMap = new int[n][m];
            copyArray(tmpMap, map);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tmpMap[i][j] == 2) { // visited를 두면 중복을 조금 더 줄일 수 있을 듯?
                        expandBirus(i, j);
                    }
                }
            }

            // 안전영역 계산
            res = Math.max(res, getSafetyArea(tmpMap));
            return;
        }

        // 벽을 3개 미만, 다음 세울 벽 위치 탐색
        for (int i = x; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    // 벽 세움
                    map[i][j] = 1;
                    dfs(i, count + 1);
                    // backtracking
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void expandBirus(int x, int y) {
        int nextX, nextY;
        // 상하좌우 4방향 퍼뜨림
        for (int i = 0; i < 4; i++) {
            // 위치 이동
            nextX = x + dX[i];
            nextY = y + dY[i];

            // 범위 제한
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
            if (tmpMap[nextX][nextY] == 0) {
                tmpMap[nextX][nextY] = 2;
                expandBirus(nextX, nextY);
            }
        }
    }

    private static int getSafetyArea(int[][] map) {
        int safetyArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    safetyArea++;
                }
            }
        }
        return safetyArea;
    }

    private static void copyArray(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < n; i++) {
            arr1[i] = Arrays.copyOf(arr2[i], m);
        }
    }
}
