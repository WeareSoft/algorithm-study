package hee.boj.graph1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램
public class Hee_Q2178 {
    // 상하좌우에 대한 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n, m;

    static int[][] maze; // 이동가능: 1, 이동불가: 0
    static int[][] visited; // 방문하지 않음: 0, 방문: 이동한 칸의 수

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt(); // (2≤N, M≤100)
        m = scanner.nextInt();

        maze = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            char[] chars = s.toCharArray();

            for (int j = 0; j < m; j++) {
                maze[i][j] = chars[j] - '0';
                visited[i][j] = 0; // 방문하지 않음: 0
            }
        }

        dfs(0, 0);

        // 마지막 지점까지의 최소 거리 출력
        System.out.println(visited[n-1][m-1]);
    }

    static void dfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y)); // 시작좌표 큐에 삽입
        visited[x][y] = 1; // 시작좌표 방문

        while (!queue.isEmpty()) {
            int x1 = queue.peek().getX();
            int y1 = queue.peek().getY();
            queue.poll(); // 방문

            // 상하좌우 좌표 방문
            for (int i = 0; i < 4; i++) {
                int nextX = x1 + dx[i];
                int nextY = y1 + dy[i];

                // 상하좌우 좌표가 상자의 범위 안에 있으면
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    // 상하좌우 좌표가 이동이 가능한 좌표면서, 한 번도 방문하지 않은 좌표면
                    if (maze[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                        visited[nextX][nextY] = visited[x1][y1] + 1; // 거쳐간 좌표 하나 증가
                        queue.add(new Pair(nextX, nextY)); // 좌표를 큐에 삽입
                    }
                }
            }
        }
    }

    public static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}