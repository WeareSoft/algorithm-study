package hee.samsung;

import java.util.Scanner;

public class Hee_Q14503 {
    // 바라보는 방향의 왼쪽 방향 0:W, 1:N, 2:E, 3:S
    static int[] leftdx = { 0, -1, 0, 1 };
    static int[] leftdy = { -1, 0, 1, 0 };
    // 바라보는 방향의 후진 방향 0:S, 1:W, 2:N, 3:E)
    static int[] backdx = { 1, 0, -1, 0 };
    static int[] backdy = { 0, -1, 0, 1 };

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int res = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int d = sc.nextInt(); // 바라보는 방향 (0:N, 1:E, 2:S, 3:W)

        map = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        } // input

        move(x, y, d);
//		move2(x, y, d);
//		move3(x, y, d);

        /* 결과 출력 */
        System.out.println(res);
    }

    /* [방법1] 흐름에 따른 단순한 풀이 */
    public static void move(int x, int y, int d) {
        while (true) {
            visited[x][y] = true; // 1. 현재 위치를 청소.

            int c = check(x, y, d); // [종료 조건]
            if (c == 1) {
                // 2. 바라보는 방향의 왼쪽 위치 탐색.
                int nx = x + leftdx[d];
                int ny = y + leftdy[d];

                // 2-1. 탐색할 위치가 벽이 아니고 청소가 안되어 있으면,
                if (!visited[nx][ny] && map[nx][ny] != 1) { // 왼쪽 방향으로 회전 후 이동
                    // (0:N, 1:E, 2:S, 3:W) -> (3:W, 0:N, 1:E, 2:S)
                    d = (d == 0 ? 3 : d - 1);
                    x = nx;
                    y = ny;
                }
                // 2-2. 탐색할 위치가 벽이거나 청소가 되어 있으면,
                else if (visited[nx][ny] || map[nx][ny] == 1) { // 왼쪽 방향으로 회전만 수행
                    // (0:N, 1:E, 2:S, 3:W) -> (3:W, 0:N, 1:E, 2:S)
                    d = (d == 0 ? 3 : d - 1);
                }
            }
            // 2-3. 후진할 위치가 빈칸이면 방향 유지한 채로 뒤로 후진.
            else if (c == 2) {
                x = x + backdx[d];
                y = y + backdy[d];
            }
            // 2-4.후진할 위치가 벽이면 종료.
            else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (visited[i][j])
                            res++;
                    }
                }
                return;
            }
        }
    }

    /* 상하좌우 네 방향 모두 청소가 이미 되어있거나 벽인 경우 */
    public static int check(int x, int y, int d) {
        for (int i = 0; i < 4; i++) { // 상하좌우
            int nx = x + leftdx[i];
            int ny = y + leftdy[i];

            if (visited[nx][ny] || map[nx][ny] == 1)
                continue;
            return 1; // 2-1으로 이어서 계속 수행.
        }
        // 후진할 위치 정보 확인
        if (map[x + backdx[d]][y + backdy[d]] == 0)
            return 2; // 2-3. 후진할 위치가 빈칸이면 방향 유지한 채로 뒤로 후진.
        else
            return 3; // 2-4.후진할 위치가 벽이면 종료.
    }

    /* [방법2] 재귀 이용 (map 0:빈칸, 1:벽, 2:청소함) */
    public static void move2(int x, int y, int d) {
        // 1. 로봇의 현재 위치 청소
        if (map[x][y] == 0) { // 빈칸이면
            map[x][y] = 2; // 청소함.
            res++;
        }

        /* 동서남북 네 방향 모두 검사. */
        for (int i = 0; i < 4; i++) {
            // 자신의 왼쪽 위치를 점검
            int nx = x + leftdx[d];
            int ny = y + leftdy[d];

            // 왼쪽으로 방향 전환
            int leftD = (d + 3) % 4;
//			int leftD = (d - 1 < 0) ? 3 : (d - 1);

            // 2-1. 왼쪽 위치가 빈칸이면 청소한다. : 왼쪽으로 방향 변경 및 이동
            if (map[nx][ny] == 0) {
                move2(nx, ny, leftD); // 이동한 위치에서 재탐색
                // [주의] 다음 칸으로 넘어갔으면 더이상 나머지 방향은 조사하지 않는다.
                return;
            }
            // 2-2. 왼쪽 위치가 이미 청소가 되어 있거나(2) 벽(1)이면 방향만 변경한다. : 왼쪽으로 방향 변경
            else {
                d = leftD;
            }
        } // 네 방향 점검 끝.

        /* 네 방향이 모두 청소가 되어 있거나 벽인 상태 */
        int backX = x + backdx[d];
        int backY = y + backdy[d];

        // 2-4. 후진한 위치가 벽이면 종료
        if (map[backX][backY] == 1) {
            return;
        }
        // 2-3. 후진한 위치가 청소가 되어 있는 곳 : 방향 유지 및 후진 이동
        else if (map[backX][backY] == 2) {
            move2(backX, backY, d); // 후진한 위치에서 재탐색
        }
    }

    /* [방법3] flag + 반복문 이용 (map 0:빈칸, 1:벽, 2:청소함) */
    public static void move3(int x, int y, int d) {
        // 1. 로봇의 시작 위치 청소
        map[x][y] = 2; // 청소함.
        res++;
        boolean flag = false;

        int nx;
        int ny;
        while (true) {
            /* 동서남북 네 방향 모두 검사. */
            for (int i = 0; i < 4; i++) {
                flag = false; // 상태 초기화

                // 자신의 왼쪽 위치를 점검
                nx = x + leftdx[d];
                ny = y + leftdy[d];

                // 왼쪽으로 방향 전환
                int leftDir = (d + 3) % 4;
//				int leftDir = (d - 1 < 0) ? 3 : (d - 1);

                // 2-1. 왼쪽 위치가 빈칸이면 청소한다. : 왼쪽으로 방향 변경 및 이동
                if (map[nx][ny] == 0) {
                    d = leftDir;
                    x = nx;
                    y = ny;

                    map[x][y] = 2; // 청소함.
                    res++;
                    flag = true; // 상태 변경

                    break; // 나머지 방향은 조사하지 않는다.
                }
                // 2-2. 왼쪽 위치가 이미 청소가 되어 있거나(2) 벽(1)이면 방향만 변경한다. : 왼쪽으로 방향 변경
                else {
                    d = leftDir;
                }
            } // 네 방향 점검 끝.

            /* 네 방향이 모두 청소가 되어 있거나 벽인 상태 */
            if (flag == false) {
                x += backdx[d];
                y += backdy[d];

                // 2-4. 후진한 위치가 벽이면 종료한다.
                if (map[x][y] == 1) {
                    return;
                }
            } // 2-3. 후진한 위치가 청소가 되어 있는 곳 : 방향 유지 및 후진 이동 후 반복
        } // while문 종료.
    }
}
