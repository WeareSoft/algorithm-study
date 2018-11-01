package hee.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 말이 되고픈 원숭이
public class Hee_Q1600 {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[] horseDx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] horseDy = { -2, -1, 1, 2, 2, 1, -1, -2 };

    static int k, h, w;
    static int[][] map = new int[201][201];
    /* visited[row][col][말처럼 이동한 횟수] */
    static boolean[][][] visited = new boolean[201][201][31];

    static int res = -1;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); // 말처럼 이동할 수 있는 횟수
        w = sc.nextInt(); // y
        h = sc.nextInt(); // x
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                map[i][j] = sc.nextInt(); // 0:빈칸, 1:장애물
        // input

//		bfs();
        bfs2(0, 0);
        System.out.println(res);
    }

    public static void bfs() {
        Queue<Point> queue = new LinkedList<Point>();

        queue.add(new Point(0, 0, k));
        visited[0][0][0] = true; // (0,0)좌표에 말처럼 이동할 수 있는 횟수를 사용하지 않고 방문

        while (!queue.isEmpty()) {
            res++; // 이동 횟수 증가

            int size = queue.size(); // [주의] 같은 깊이에 해당하는 모든 경우
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();

                // 목표지점에 도달하면 종료.
                if (p.x == h - 1 && p.y == w - 1)
                    return;

                // 1. MONKEY 처럼 이동 (상하좌우)
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                        continue; // 범위를 벗어나면
                    if (visited[nx][ny][p.k])
                        continue; // 방문했던 위치면
                    if (map[nx][ny] == 1)
                        continue; // 장애물이 있으면

                    queue.add(new Point(nx, ny, p.k));
                    visited[nx][ny][p.k] = true; // 방문 표시
                }

                // 2. HORSE 처럼 이동 (체스에서의 나이트 이동방식)
                if (p.k == 0)
                    continue; // 말처럼 이동할 수 있는 횟수를 모두 사용했으면
                for (int j = 0; j < 8; j++) {
                    int nx = p.x + horseDx[j];
                    int ny = p.y + horseDy[j];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                        continue; // 범위를 벗어나면
                    if (visited[nx][ny][p.k - 1])
                        continue; // 방문했던 위치면
                    if (map[nx][ny] == 1)
                        continue; // 장애물이 있으면

                    queue.add(new Point(nx, ny, p.k - 1));
                    visited[nx][ny][p.k - 1] = true; // 방문 표시(이동할 수 있는 횟수 감소)
                }
            }
        } // while 끝.
        res = -1; // 해당 위치에 도달할 수 없음
    }

    public static class Point {
        public int x, y, k;

        public Point(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public static void bfs2(int x, int y) {
        Queue<Point2> queue = new LinkedList<Point2>();

        queue.add(new Point2(x, y, 0, 0));
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            Point2 p = queue.poll();

            // 목표지점에 도달하면 종료.
            if (p.x == h - 1 && p.y == w - 1) {
                res = p.cnt;
                return;
            }

            /* 말처럼 이동할 수 있는 횟수까지 MONKEY, HORSE처럼 이동하는 것을 모두 큐에 넣는다. */
            // 1. MONKEY 처럼 이동 (상하좌우)
            for (int j = 0; j < 4; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                    continue; // 범위를 벗어나면
                if (visited[nx][ny][p.k])
                    continue; // 방문했던 위치면
                if (map[nx][ny] == 1)
                    continue; // 장애물이 있으면

                queue.add(new Point2(nx, ny, p.k, p.cnt + 1)); // 이동 횟수 증가
                visited[nx][ny][p.k] = true; // 방문 표시
            }

            // 2. HORSE 처럼 이동 (체스에서의 나이트 이동방식)
            if (p.k < k) { // 말처럼 이동할 수 있는 횟수가 남아있으면
                for (int j = 0; j < 8; j++) {
                    int nx = p.x + horseDx[j];
                    int ny = p.y + horseDy[j];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w)
                        continue; // 범위를 벗어나면
                    if (visited[nx][ny][p.k + 1])
                        continue; // 방문했던 위치면
                    if (map[nx][ny] == 1)
                        continue; // 장애물이 있으면

                    queue.add(new Point2(nx, ny, p.k + 1, p.cnt + 1)); // 이동 횟수 증가
                    visited[nx][ny][p.k + 1] = true; // 방문 표시(사용 횟수 증가)
                }
            }
        } // while 끝.
        res = -1; // 해당 위치에 도달할 수 없음
    }

    public static class Point2 {
        public int x, y, k, cnt;

        public Point2(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}
