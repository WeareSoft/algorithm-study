package hee.boj.graph1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램
public class Hee_Q7576 {
    // 상하좌우에 대한 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt(); // 상자의 가로 칸의 수
        int n = scanner.nextInt(); // 상자의 세로 칸의 수 (2 ≤ M,N ≤ 1,000)

        int[][] box = new int[n][m];
        int[][] date = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                date[i][j] = -1; // 날짜 초기화: -1. 방문하지 않음
                box[i][j] = scanner.nextInt(); // 익음: 1, 익지 않음: 0, 없음: -1

                // 익은 토마토의 좌표를 시작 좌표(큐에 삽입)로 bfs를 수행
                if (box[i][j] == 1) {
                    queue.add(new Pair(i, j)); // 시작 좌표로 큐에 삽입
                    date[i][j] = 0; // 이미 익은 토마토의 날짜: 0
                }
            }
        }

        /* bfs 수행 */
        while (!queue.isEmpty()) {
            int x = queue.peek().getX();
            int y = queue.peek().getY();
            queue.poll(); // 해당 좌표를 큐에서 추출. 방문

            // 해당 좌표의 상하좌우를 확인.
            for (int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 상하좌우 좌표가 상자의 범위 안에 있으면
                if (nextX>=0 && nextX<n && nextY>=0 && nextY<m){
                    // 상하좌우 좌표의 토마토가 익지 않았고, 한 번도 방문하지 않은 좌표면
                    if (box[nextX][nextY] == 0 && date[nextX][nextY] == -1) {
                        date[nextX][nextY] = date[x][y] + 1; // 시작 좌표의 날짜를 기준으로 날짜 하루 증가
                        queue.add(new Pair(nextX, nextY)); // 이제 익은 토마토이므로 상하좌우 좌표를 큐에 삽입
                    }
                }
            }
        }

        // 토마토가 모두 익을 때까지의 최소 날짜를 출력
        // 저장될 때부터 모든 토마토가 익어있는 상태: 0
        int minDate = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (date[i][j] > minDate) {
                    minDate = date[i][j];
                }
            }
        }
        // 토마토가 모두 익지는 못하는 상황: -1
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (box[i][j] == 0 && date[i][j] == -1) {
                    minDate = -1;
                }
            }
        }

        // 최소 날짜를 출력
        System.out.println(minDate);

    }

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