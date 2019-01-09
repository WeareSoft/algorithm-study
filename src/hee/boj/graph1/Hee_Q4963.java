package hee.boj.graph1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hee_Q4963 {
    // 좌표의 상하좌우대각선에 대한 벡터
    static int[] dx = {0, 0, -1, 1, -1, 1, 1, -1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    static int w, h;
    static int[][] map;
    static int[][] visited; // 방문하지 않았으면: 0, 방문했으면: 1
    static int cntOfIsland; // 섬의 수


    public static void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            cntOfIsland = 0;

            if (w == 0 && h == 0) break; // 종료 조건: 0 0

            map = new int[h][w];
            visited = new int[h][w];

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    map[i][j] = scanner.nextInt(); // 땅: 1, 바다: 0
                    visited[i][j] = 0;
                }
            }

            // 좌표 탐색
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    // 해당 좌표가 땅이고, 방문하지 않은 좌표면 탐색 시작
                    if (map[i][j] == 1 && visited[i][j] == 0) {
                        bfs(i, j);
                    }
                }
            }
            System.out.println(cntOfIsland);
        }
    }

    // 너비 우선 탐색
    static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y)); // 시작 좌표를 큐에 삽입
        visited[x][y] = 1; // 방문

        while (!queue.isEmpty()) {
            int x1 = queue.peek().getX();
            int y1 = queue.peek().getY();
            queue.poll(); // 좌표를 방문하고 큐에서 추출

            // 해당 좌표에 대해 상하좌우대각선을 확인
            for (int i=0; i<8; i++) {
                int nextX = x1 + dx[i];
                int nextY = y1 + dy[i];

                // 해당 좌표가 지도 안에 있으면
                if (nextX >= 0 && nextX < h && nextY >=0 && nextY < w) {
                    // 해당 좌표가 땅이고, 방문하지 않은 좌표면 같은 섬으로 표시
                    if (map[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                        queue.add(new Pair(nextX, nextY)); // 다음 좌표를 큐에 삽입
                        visited[nextX][nextY] = 1; // 방문
                    }
                }
            }
        }
        cntOfIsland++; // 섬의 수 증가
    }

    // 좌표를 위한 클래스
    public static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() { return x; }
        public int getY() { return y; }
    }
}