package hee.samsung;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 백트래킹 (DFS) - nCm의 조합 백트래킹 + 상하좌우로 퍼지는 형태의 DFS
 */
public class Hee_Q14502 {
    static int n, m;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int[][] map;

    static ArrayList<Point> empty = new ArrayList(); // 빈칸
    static ArrayList<Point> virus = new ArrayList(); // 바이러스

    static int res = Integer.MIN_VALUE;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // x
        m = sc.nextInt(); // y

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = sc.nextInt();
                map[i][j] = value;

                if (value == 0) { // 빈칸
                    empty.add(new Point(i, j));
                } else if (value == 2) { // 바이러스
                    virus.add(new Point(i, j));
                }
            }
        } // input

        dfs(0, 0);
        System.out.println(res);
    }

    /* [nCm의 조합] 벽 3개를 선택하기 위한 DFS */
    public static void dfs(int start, int depth) {
        // [출력] 벽을 3개 선택했으면,
        if (depth == 3) {
            // 모든 바이러스에 의해 감염여부를 확인 후 감염되지 않은 안전지대 수를 구한다.
            int safe = virusSpread();

            // 최대 크기의 안전지대를 변경한다.
            res = Math.max(res, safe);
            return;
        }
        // [재탐색] 계속해서 빈칸 중 벽을 넣을 장소의 조합을 만든다.
        else {
            for (int i = start; i < empty.size(); i++) {
                Point p = empty.get(i); // 빈칸 하나를 가져온다.

                map[p.x][p.y] = 1;// depth번째 벽 선택.((p.x, p.y)위치를 벽으로 만든다.)
                dfs(i + 1, depth + 1); // (depth + 1)번째 벽 선택
                map[p.x][p.y] = 0;// 제외.(다시 빈칸으로 만든다.)
            }
        }
    }

    /* 모든 바이러스마다 돌면서 감염시킨 후 안전지대 수를 return */
    public static int virusSpread() {
        // 기존의 연구실 상태를 복사한다.
//		int[][] tmpLab = map; // [주의] 틀림!!!
        int[][] tmpLab = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                tmpLab[i][j] = map[i][j];

        // 모든 바이러스의 시작점에 대해 감염을 진행한다.
        for (int i = 0; i < virus.size(); i++) {
            Point p = virus.get(i); // 시작 바이러스 위치를 가져온다.
            virusDFS(p.x, p.y, tmpLab); // 바이러스 감염 DFS
        }

        // 안전지대의 수를 구한다.
        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmpLab[i][j] == 0) // 빈칸의 수가 안전 지대
                    safe++;
            }
        }
        return safe;
    }

    /* [상하좌우 퍼지면서 탐색] 바이러스 하나에 대해 상하좌우를 모두 확인하여 감염시키기 위한 DFS */
    public static void virusDFS(int x, int y, int[][] tmpLab) {
        // 상하좌우를 모두 확인
        for (int j = 0; j < 4; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];

            // 범위 내이고,
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 상하좌우의 위치가 빈칸이면,
                if (tmpLab[nx][ny] == 0) {
                    tmpLab[nx][ny] = 2; // 바이러스 감염 표시.
                    virusDFS(nx, ny, tmpLab); // 감염된 위치에 대해 다시 상하좌우를 확인.
                }
            }
        }
    }
}
