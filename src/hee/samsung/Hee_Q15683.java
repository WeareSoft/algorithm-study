package hee.samsung;

import java.util.ArrayList;
import java.util.Scanner;

/** 브루트 포스 */
public class Hee_Q15683 {
    static int[] dx = { -1, 1, 0, 0 }; // (0:상, 1:하, 2:좌, 3:우)
    static int[] dy = { 0, 0, -1, 1 };
    static int n, m;

    static int[][] map;
    static boolean[][] visited;
    static boolean[][] originVisited;
    static ArrayList<CCTV> cctv = new ArrayList();

    static int res = Integer.MAX_VALUE; // 사각지대의 최소 개수

    public static void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
        originVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = sc.nextInt();
                map[i][j] = value;

                if (value != 0) { // 빈칸이 아니면 이미 감시한 공간으로 표시
                    visited[i][j] = true;
                    if (value != 6) // cctv면 ArrayList에 넣음
                        cctv.add(new CCTV(i, j, value));
                }
            }
        } // input

        initVisited(visited, originVisited); // 최초의 감시 정보 저장
        dfs(0); // 탐색 수행
        System.out.println(res);
    }

    public static void dfs(int depth) {
        // [출력] 모든 cctv를 탐색했으면, 사각지대의 최소 개수를 구한다.
        if (depth == cctv.size()) {
            // 모든 cctv를 돌면서 해당 cctv의 번호에 따라 회전하는 방향(rotation)에서의 감시하는 공간에 표시
            for (CCTV c : cctv) {
                check(c);
            }
            res = Math.min(res, getblindSpot()); // 사각지대의 최소 개수 변경
            initVisited(originVisited, visited); // 감시했던 공간을 처음으로 초기화
            return;
        }

        // [재탐색] N부터 시계 방향으로 90도씩 회전하면서 4방향 모두에 대해 탐색 수행 (N E S W)
        for (int i = 0; i < 4; i++) {
            cctv.get(depth).setRotation(i); // depth번째 cctv의 회전 방향 설정.
            dfs(depth + 1); // (depth + 1)번째 cctv 선택
        }
    }

    /* cctv 번호에 맞는 방법으로 감시 */
    // cctv마다 회전하는 방향(rotation)에서의 감시할 수 있는 방법이 다르다.
    public static void check(CCTV c) {
        // rotation: N(0), E(1), S(2), W(3)
        switch (c.cctvNum) {
            case 1: // [↑ 기준] N:상(0), E:우(3), S:하(1), W:좌(2)
                if (c.rotation == 0)
                    watch(c, 0);
                else if (c.rotation == 1)
                    watch(c, 3);
                else if (c.rotation == 2)
                    watch(c, 1);
                else
                    watch(c, 2);
                break;
            case 2: // [←→ 기준] N:좌우, E:상하, S:좌우, W:상하
                if (c.rotation == 0 || c.rotation == 2) {
                    watch(c, 2);
                    watch(c, 3);
                } else {
                    watch(c, 0);
                    watch(c, 1);
                }
                break;
            case 3:// [↑→ 기준] N:상우, E:하우, S:하좌, W:상좌
                if (c.rotation == 0) {
                    watch(c, 0);
                    watch(c, 3);
                } else if (c.rotation == 1) {
                    watch(c, 1);
                    watch(c, 3);
                } else if (c.rotation == 2) {
                    watch(c, 1);
                    watch(c, 2);
                } else {
                    watch(c, 0);
                    watch(c, 2);
                }
                break;
            case 4:// [←↑→ 기준] N:상좌우, E:상하우, S:하좌우, W:상하좌
                if (c.rotation == 0) {
                    watch(c, 0);
                    watch(c, 2);
                    watch(c, 3);
                } else if (c.rotation == 1) {
                    watch(c, 0);
                    watch(c, 1);
                    watch(c, 3);
                } else if (c.rotation == 2) {
                    watch(c, 1);
                    watch(c, 2);
                    watch(c, 3);
                } else {
                    watch(c, 0);
                    watch(c, 1);
                    watch(c, 2);
                }
                break;
            case 5:// 상하좌우
                watch(c, 0);
                watch(c, 1);
                watch(c, 2);
                watch(c, 3);
                break;
        }
    }

    /* 상하좌우 방향에 따라 감시할 수 있는 모든 곳에 감시 표시 */
    // 벽이면 더이상 감시할 수 없다.
    public static void watch(CCTV c, int direction) {
        switch (direction) {
            case 0: // 상(x--)
                for (int i = c.x; i >= 0; i--) {
                    if (map[i][c.y] == 6)
                        break;
                    visited[i][c.y] = true; // 감시 가능
                }
                break;
            case 1: // 하(x++)
                for (int i = c.x; i < n; i++) {
                    if (map[i][c.y] == 6)
                        break;
                    visited[i][c.y] = true; // 감시 가능
                }
                break;
            case 2: // 좌(y--)
                for (int i = c.y; i >= 0; i--) {
                    if (map[c.x][i] == 6)
                        break;
                    visited[c.x][i] = true; // 감시 가능
                }
                break;
            case 3: // 우(y++)
                for (int i = c.y; i < m; i++) {
                    if (map[c.x][i] == 6)
                        break;
                    visited[c.x][i] = true; // 감시 가능
                }
                break;
        }
    }

    /* 사각지대의 개수 */
    public static int getblindSpot() {
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!visited[i][j]) // 감시하지 못한 공간
                    cnt++;
        return cnt;
    }

    /* 감시 여부 초기화: oriVisited -> visited로 복사 */
    public static void initVisited(boolean[][] oriVisited, boolean[][] visited) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                visited[i][j] = oriVisited[i][j];
    }

    public static class CCTV {
        public int x;
        public int y;
        public int cctvNum; // 번호
        public int rotation; // 회전 방향 (0:N, 1:E, 2:S, 3:W)

        public CCTV(int x, int y, int cctvNum) {
            this.x = x;
            this.y = y;
            this.cctvNum = cctvNum;
        }

        public void setRotation(int rotation) {
            this.rotation = rotation;
        }
    }
}