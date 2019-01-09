package hee.boj.graph1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hee_Q2146 {
    // 상하좌우에 대한 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 지도의 크기 (100이하의 자연수)
        int[][] country = new int[N][N]; // 육지와 바다 구분
        int[][] island = new int[N][N]; // 섬의 번호

        /** 입력 받기 */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                country[i][j] = scanner.nextInt(); // 육지: 1, 바다: 0
                island[i][j] = 0; // 섬의 번호 초기화: 0 (방문하지 않음)
            }
        }

        /** 1. 육지에 섬의 번호를 매긴다. */
        int numOfIsland = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 해당 좌표가 육지면서 방문하지 않은 좌표면
                if (country[i][j] == 1 && island[i][j] == 0) {
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(new Pair(i, j)); // 시작 좌표를 큐에 삽입
                    island[i][j] = ++numOfIsland; // 방문: 섬의 번호

                    /* bfs 탐색 */
                    while (!queue.isEmpty()) {
                        int x = queue.peek().getX();
                        int y = queue.peek().getY();
                        queue.poll(); // 큐에서 추출

                        // 좌표의 상하좌우를 탐색
                        for (int k = 0; k < 4; k++) {
                            int nextX = x + dx[k];
                            int nextY = y + dy[k];

                            // 상하좌우 좌표가 나라의 범위 안에 있으면
                            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                                // 해당 좌표가 육지면서 방문하지 않은 좌표면
                                if (country[nextX][nextY] == 1 && island[nextX][nextY] == 0) {
                                    queue.add(new Pair(nextX, nextY)); // 큐에 삽입
                                    island[nextX][nextY] = numOfIsland; // 방문. 같은 섬의 번호를 매긴다.
                                }
                            }
                        }
                    } // bfs 탐색 끝
                }
            }
        } // 1. 단계 끝


        /** [방법 1] 2. 각각의 섬의 번호에 대해서 다른 섬의 모든 좌표까지의 거리를 구한다. */
//        // 각각의 섬의 번호에 대해서 bfs를 모두 수행해야 하기 때문에 느리다.
//        int minDistance = -1; // 가장 짧은 다리의 길이
//        int[][] distance = new int[N][N];
//
//        // 섬의 개수 만큼 반복 수행
//        for (int l = 1; l <= numOfIsland; l++) {
//            Queue<Pair> queue = new LinkedList<>();
//
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    distance[i][j] = -1; // 거리 초기화: -1 (방문하지 않음)
//
//                    // 섬의 번호가 l이면
//                    if (island[i][j] == l) {
//                        queue.add(new Pair(i, j)); // 섬의 번호가 l인 모든 좌표를 큐에 삽입
//                        distance[i][j] = 0; // 방문: 거리
//                    }
//                }
//            }
//
//            /* bfs 탐색 */
//            // 섬의 번호가 l인 모든 좌표를 시작 좌표로 하여 탐색 수행 (섬의 번호가 l인 좌표와의 거리 표시)
//            while (!queue.isEmpty()) {
//                int x = queue.peek().getX();
//                int y = queue.peek().getY();
//                queue.poll(); // 큐에서 추출
//
//                // 좌표의 상하좌우를 탐색
//                for (int k = 0; k < 4; k++) {
//                    int nextX = x + dx[k];
//                    int nextY = y + dy[k];
//
//                    // 상하좌우 좌표가 나라의 범위 안에 있으면
//                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
//                        // 방문한 적이 없는 좌표면
//                        if (distance[nextX][nextY] == -1) {
//                            queue.add(new Pair(nextX, nextY)); // 큐에 삽입
//                            distance[nextX][nextY] = distance[x][y] + 1; // 방문: 다음 좌표 거리 증가
//                        }
//                    }
//                }
//            } // bfs 탐색 끝
//
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    // 해당 좌표가 육지면서 섬의 번호가 l이 아니면 (즉, 다른 섬의 좌표라면)
//                    if (country[i][j] == 1 && island[i][j] != l) {
//                        // 처음 최단 거리를 구하거나 (기존에 구한 최단 거리 > 해당 좌표와의 거리)인 경우
//                        if (minDistance == -1 || minDistance > distance[i][j] - 1) {
//                            minDistance = distance[i][j] - 1; // 더 최단 거리로 변경
//                        }
//                    }
//                }
//            }
//        } // 2. 단계 끝


        /** [방법 2] 2. 육지를 확장하면서 섬의 번호와 거리를 구한다. */
        // [방법 1] 보다 훨씬 빠르게 수행한다.
        Queue<Pair> queue = new LinkedList<>();
        int[][] distance = new int[N][N]; // 가장 인접한 섬까지의 최단 거리에 대한 배열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distance[i][j] = -1; // 거리 초기화: -1 (방문하지 않음)

                // 해당 좌표가 육지면
                if (country[i][j] == 1) {
                    queue.add(new Pair(i, j)); // 육지인 모든 좌표를 큐에 삽입
                    distance[i][j] = 0; // 방문: 거리
                }
            }
        }

        /* bfs 탐색 */
        // 육지인 모든 좌표를 시작 좌표로 하여 탐색 수행 (육지를 점점 확장하면서 거리 표시)
        while (!queue.isEmpty()) {
            int x = queue.peek().getX();
            int y = queue.peek().getY();
            queue.poll(); // 큐에서 추출

            // 좌표의 상하좌우를 탐색
            for (int k = 0; k < 4; k++) {
                int nextX = x + dx[k];
                int nextY = y + dy[k];

                // 상하좌우 좌표가 나라의 범위 안에 있으면
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    // 방문하지 않았던 좌표면
                    if (distance[nextX][nextY] == -1) {
                        queue.add(new Pair(nextX, nextY)); // 큐에 삽입
                        distance[nextX][nextY] = distance[x][y] + 1; // 방문: 다음 좌표 거리 증가
                        island[nextX][nextY] = island[x][y]; // 인접한 육지와 같은 섬의 번호 할당. 섬을 확장
                    }
                }
            }
        }

        int minDistance = -1; // 가장 짧은 다리의 길이
        // 모든 좌표를 기준 좌표로 반복 수행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 좌표의 상하좌우를 탐색
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];

                    // 상하좌우 좌표가 나라의 범위 안에 있으면
                    if (x >= 0 && x < N && y >= 0 && y < N) {
                        // 기준 좌표와 상하좌우 좌표가 같은 섬이 아니면 (다리를 만들 수 있는 경우라면)
                        if (island[i][j] != island[x][y]) {
                            // 처음 최단 거리를 구하거나 (기존에 구한 최단 거리 > 두 좌표의 거리의 합)인 경우
                            if (minDistance == -1 || minDistance > distance[i][j] + distance[x][y]) {
                                minDistance = distance[i][j] + distance[x][y]; // 최단 거리 변경
                            }
                        }
                    }
                }
            }
        } // 2. 단계 끝


        /** 가장 짧은 다리의 길이를 출력 */
        System.out.println(minDistance);
    }


    /* 좌표를 위한 클래스 */
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
