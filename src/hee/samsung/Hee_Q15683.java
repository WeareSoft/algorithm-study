package hee.samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 문제풀이방법: 완전탐색 + 깊이우선 이용
 *
 * 1. cctv의 개수를 모두 센다. 그 후 cctv를 전부 돌려본다(90도 방향으로).
 *
 */

// 사각 지대의 최소 크기를 출력한다. 0의 최소 개수
public class Hee_Q15683 {
    static int N, M;

    static int[][] office;
    static int[][] visited; // 방문했으면 -1
    static int[] EWSN;
    static ArrayList<myPoint> cctv;

    static final int UP = 0;
    static final int DOWN = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;

    static int cntBlindSpot = Integer.MAX_VALUE; // result(사각지대)

    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);

        office = new int[N][M];
        visited = new int[N][M];
        cctv = new ArrayList<myPoint>();

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int type = Integer.parseInt(str[j]);
                office[i][j] = type;

                if (type != 0 && type != 6) { // cctv가 존재하는 공간이면
                    cctv.add(new myPoint(i, j, type));
                }
            }
        }

        EWSN = new int[cctv.size()]; // 모든 cctv에 대해 동서남북으로 탐색
        dfs(0);
        bw.write(Integer.toString(cntBlindSpot));
        bw.close();
    }

    public static void dfs(int cctvIndex) {
        // 탐색할 cctv가 더이상 없다면 값을 출력 [말단 노드이면]
        if (cctvIndex == cctv.size()) {
            // 방문 여부 2차원 배열 초기화
            init();

            // 모든 cctv에 대한 이동
            for (int k = 0; k < cctv.size(); k++) {
                myPoint p = cctv.get(k);
                int typeNum = p.typeNum;

                switch (typeNum) {
                    case 1: // 상, 하, 좌, 우 4가지
                        if (EWSN[k] == 0) // NORTH
                            move(p, UP);
                        else if (EWSN[k] == 1) // EAST
                            move(p, RIGHT);
                        else if (EWSN[k] == 2) // SOUTH
                            move(p, DOWN);
                        else if (EWSN[k] == 3) // WEST
                            move(p, LEFT);
                        break;
                    case 2: // 상하, 좌우 2가지
                        if (EWSN[k] == 0) { // NORTH
                            move(p, UP);
                            move(p, DOWN);
                        }
                        else if (EWSN[k] == 1) { // EAST
                            move(p, LEFT);
                            move(p, RIGHT);
                        }
                        else if (EWSN[k] == 2) { // SOUTH
                            move(p, UP);
                            move(p, DOWN);
                        }
                        else if (EWSN[k] == 3) { // WEST
                            move(p, LEFT);
                            move(p, RIGHT);
                        }
                        break;
                    case 3: // 상우, 우하, 좌하, 상좌 4가지
                        if (EWSN[k] == 0) { // NORTH
                            move(p, UP);
                            move(p, RIGHT);
                        }
                        else if (EWSN[k] == 1) { // EAST
                            move(p, RIGHT);
                            move(p, DOWN);
                        }
                        else if (EWSN[k] == 2) { // SOUTH
                            move(p, LEFT);
                            move(p, DOWN);
                        }
                        else if (EWSN[k] == 3) { // WEST
                            move(p, UP);
                            move(p, LEFT);
                        }
                        break;
                    case 4: // 상좌우, 상하우, 하좌우, 상하좌 4가지
                        if (EWSN[k] == 0) { // NORTH
                            move(p, UP);
                            move(p, LEFT);
                            move(p, RIGHT);
                        }
                        else if (EWSN[k] == 1) { // EAST
                            move(p, UP);
                            move(p, DOWN);
                            move(p, RIGHT);
                        }
                        else if (EWSN[k] == 2) { // SOUTH
                            move(p, DOWN);
                            move(p, LEFT);
                            move(p, RIGHT);
                        }
                        else if (EWSN[k] == 3) { // WEST
                            move(p, UP);
                            move(p, DOWN);
                            move(p, LEFT);
                        }
                        break;
                    case 5: // 상하좌우 1가지
                        move(p, UP);
                        move(p, RIGHT);
                        move(p, DOWN);
                        move(p, LEFT);
                        break;
                }
            }

            // 가장 최소인 값을 출력
            cntBlindSpot = Math.min(getBlindSpot(), cntBlindSpot);
            return;
        }

        // 탐색할 cctv가 남아있다면 cctv에 대한 탐색을 진행한다.
        // cctv를 90도로 회전(동서남북)하면서 다음 노드를 탐색
        for (int i = 0; i < 4; i++) {
            // 0: NORTH 부터 90도로 회전
            EWSN[cctvIndex] = i;
            dfs(cctvIndex + 1); // DFS로 재귀.
        }
    }

    /* 방문 여부 2차원 배열의 값 초기화 */
    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = office[i][j];
            }
        }
    }

    /* 범위 내에서 상하좌우로 이동하면서 방문 */
    public static void move(myPoint p, int direction) {
        int curX = p.x;
        int curY = p.y;

        if (direction == UP) { // -1, 0
            for (int i = curX; i >= 0; i--) {
                if (office[i][curY] == 6) // 벽인 경우
                    return;
                visited[i][curY] = -1; // 방문 표시
            }
        } else if (direction == DOWN) { // 1, 0
            for (int i = curX; i < N; i++) {
                if (office[i][curY] == 6) // 벽인 경우
                    return;
                visited[i][curY] = -1; // 방문 표시
            }
        } else if (direction == LEFT) { // 0, -1
            for (int j = curY; j >= 0; j--) {
                if (office[curX][j] == 6) // 벽인 경우
                    return;
                visited[curX][j] = -1; // 방문 표시
            }
        } else if (direction == RIGHT) { // 0, 1
            for (int j = curY; j < M; j++) {
                if (office[curX][j] == 6) // 벽인 경우
                    return;
                visited[curX][j] = -1; // 방문 표시
            }
        }
    }

    /* 사각지대의 수 */
    public static int getBlindSpot() {
        int num = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) // 방문하지 못한 공간이면
                    num++;
            }
        }
        return num;
    }

    public static class myPoint {
        public int x, y, typeNum;

        public myPoint(int x, int y, int typeNum) {
            this.x = x;
            this.y = y;
            this.typeNum = typeNum;
        }
    }
}

