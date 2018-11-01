package hee.samsung;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 시뮬레이션
 */
public class Hee_Q14500 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int n, m;
    static int[][] nums;

    static ArrayList<Point> tet = new ArrayList();
    static boolean[][] visited;

    static int res = Integer.MIN_VALUE;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        nums = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                nums[i][j] = sc.nextInt();

        // 모든 좌표를 돌면서
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                /* [방법1] -> DFS 이용 */
//				dfs1(i, j); // 상하좌우 가능한 모형들 (ㅗ 모양 제외)
                dfs2(i, j, 0, 0);
//				except1(i, j); // 'ㅗ' 모양 구현
                except2(i, j);

                /* [방법2] -> 직관적임 */
//				go(i, j); // 모든 모양에 대해 반복
            }
        }

        /* 결과 출력 */
        System.out.println(res);
    }

    /** ArrayList 이용 */
    public static void dfs1(int x, int y) {
        // [출력]
        if (tet.size() == 4) { // [주의] depth 사용 X
            int sum = 0;
            for (int i = 0; i < tet.size(); i++) {
                sum += nums[tet.get(i).x][tet.get(i).y];
            }
            res = Math.max(res, sum);
            return;
        }

        // [재탐색]
        for (int i = 0; i < 4; i++) { // (x,y)을 시작으로 상하좌우로 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];
            Point p = new Point(nx, ny);

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!tet.contains(p)) { // [주의]
                    tet.add(p);
                    dfs1(nx, ny);
                    tet.remove(tet.size() - 1);
                }
            }
        }
    }

    /** boolean[][] 이용 */
    static void dfs2(int x, int y, int depth, int sum) {
        // [출력]
        if (depth == 4) {
            res = Math.max(res, sum);
            return;
        }
        // [재탐색]
        for (int i = 0; i < 4; i++) { // (x,y)을 시작으로 상하좌우로 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            dfs2(nx, ny, depth + 1, sum + nums[nx][ny]); // [주의]
            visited[nx][ny] = false;
        }
    }

    public static void except1(int x, int y) {
        int[][] T1 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } }; // 'ㅗ' 모양
        int[][] T2 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }; // 'ㅜ'
        int[][] T3 = { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } }; // 'ㅏ'
        int[][] T4 = { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }; // 'ㅓ'

        int[][][] T = { T1, T2, T3, T4 };

        // (x,y) 좌표에 대해 가능한 'ㅗ'모형을 모두 돌면서 차지하는 공간의 합을 구한다.
        for (int i = 0; i < 4; i++) {
            int sum = 0;

            for (int j = 0; j < 4; j++) {
                int nx = x + T[i][j][0];
                int ny = y + T[i][j][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    break;

                sum += nums[nx][ny];
            } // 테트로미노가 차지하는 공간을 한 번씩 돈다.

            res = Math.max(res, sum);
        }
    }

    public static void except2(int x, int y) {
        // 시작 위치를 기준으로 오른쪽 아래 방향에 종류별 'ㅗ'모형을 두고 확인한다.
        // 'ㅗ' 'ㅏ' 'ㅜ' 'ㅓ' 순서
        int[][] Tx = { { 0, 1, 2, 1 }, { 1, 0, 1, 2 }, { 0, 0, 1, 0 }, { 1, 0, 1, 1 } };
        int[][] Ty = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 2 }, { 0, 1, 1, 2 } };

        // (x,y) 좌표에 대해 가능한 'ㅗ'모형을 모두 돌면서 차지하는 공간의 합을 구한다.
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            boolean flag = false; // 도형을 완전히 둘 수 있는지 확인

            for (int j = 0; j < 4; j++) {
                int nx = x + Tx[i][j];
                int ny = y + Ty[i][j];

                // 범위 안에 있으면 해당 도형을 둘 수 있는 위치.
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    sum += nums[nx][ny];
                } else {
                    flag = true; // 범위 안에 없으므로, 도형을 둘 수 없다.
                    break;
                }
            } // 테트로미노가 차지하는 공간을 한 번씩 돈다.

            // 해당 도형을 완전히 둔 후의 차지하는 공간의 값을 구한다.
            if (flag == false) {
                res = Math.max(res, sum);
            }
        }
    }

    public static void go(int x, int y) {
        int[][] I1 = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } }; // 'ㅣ' 모양
        int[][] I2 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } };
        int[][] O = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }; // 'ㅁ' 모양
        int[][] L1_1 = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } }; // 'ㄴ' 모양
        int[][] L1_2 = { { 1, 0 }, { 0, 0 }, { 0, 1 }, { 0, 2 } };
        int[][] L1_3 = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } };
        int[][] L1_4 = { { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 } };
        int[][] L2_1 = { { 0, 1 }, { 1, 1 }, { 2, 0 }, { 2, 1 } }; // 'ㄴ' 모양 대칭 ('ㄱ')
        int[][] L2_2 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } };
        int[][] L2_3 = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } };
        int[][] L2_4 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } };
        int[][] Z1_1 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } }; // 'Z' 모양
        int[][] Z1_2 = { { 1, 0 }, { 1, 1 }, { 0, 1 }, { 0, 2 } };
        int[][] Z2_1 = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 0 } }; // 'Z' 모양 대칭
        int[][] Z2_2 = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } };
        int[][] T1 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } }; // 'ㅗ' 모양
        int[][] T2 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } };
        int[][] T3 = { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } };
        int[][] T4 = { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } };

        // 모든 테트로미노의 종류 (회전, 대칭 포함 19가지)
        int[][][] shape = { I1, I2, O, L1_1, L1_2, L1_3, L1_4, L2_1, L2_2, L2_3, L2_4, Z1_1, Z1_2, Z2_1, Z2_2, T1, T2,
                T3, T4 };

        // (x,y) 좌표에 대해 모든 테트로미노 종류를 돌면서 차지하는 공간의 합을 구한다.
        for (int i = 0; i < shape.length; i++) {
            int sum = 0;
            boolean flag = false;

            for (int j = 0; j < 4; j++) {
                int nx = x + shape[i][j][0];
                int ny = y + shape[i][j][1];

                // 해당 좌표가 범위내에 있으면
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    sum += nums[nx][ny];
                } else {
                    flag = true; // 하나라도 범위를 벗어나면
                    break;
                }
            } // 테트로미노가 차지하는 공간을 한 번씩 돈다.

            if (flag == false) { // 테트로미노를 둘 수 있음.
                res = Math.max(res, sum);
            }

//			if (flag == true) // 테트로미노를 둘 수 없음.
//				continue;
//			res = Math.max(res, sum);
        }
    }
}
