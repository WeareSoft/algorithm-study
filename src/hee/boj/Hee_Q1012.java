package hee.boj;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q1012 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int t, m, n, k;

    static boolean[][] visited;
    static ArrayList<Point> cabbage;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt(); // testcase

        while (t-- > 0) {
            m = sc.nextInt(); // x
            n = sc.nextInt(); // y
            visited = new boolean[m][n]; // 체크
            cabbage = new ArrayList();

            k = sc.nextInt();
            for (int i = 0; i < k; i++) {
                // 배추의 위치 저장
                cabbage.add(new Point(sc.nextInt(), sc.nextInt()));
            }

            int res = 0;
            for (int i = 0; i < cabbage.size(); i++) {
                Point p = cabbage.get(i); // 점검할 배추의 위치
                if (!visited[p.x][p.y]) { // 해당 위치를 방문하지 않았으면
                    res++;
//					dfs(p); // 해당 위치의 상하좌우로 이동하면서 방문 표시
                    dfs2(p.x, p.y);
                }
            }
            System.out.println(res);
        }
    }

    public static void dfs(Point p) {
        int x = p.x;
        int y = p.y;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            Point np = new Point(nx, ny);

            // 범위를 벗어나면 다음 상하좌우 확인
            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;

            // 배추인데 방문하지 않았던 위치면 해당 좌표를 기준으로 재탐색
            if (cabbage.contains(np) && !visited[nx][ny]) {
                visited[nx][ny] = true; // 방문 표시
                dfs(np);
            }
        } // 상하좌우 확인 끝.
    }

    public static void dfs2(int x, int y) {
        // 범위를 벗어나지 않고
        if (x >= 0 && x < m && y >= 0 && y < n) {
            // 배추인데 방문하지 않았던 위치면
            if (cabbage.contains(new Point(x, y)) && !visited[x][y]) {
                visited[x][y] = true; // 방문 표시
                // 상하좌우로 재탐색
                dfs2(x, y + 1);
                dfs2(x, y - 1);
                dfs2(x + 1, y);
                dfs2(x - 1, y);
            }
        }
    }
}
