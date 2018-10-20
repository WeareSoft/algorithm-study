package hee.samsung;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/** 시뮬레이션 */
public class Hee_Q3190 {
    static int n, k, l;
    static boolean[][] apple;
    static ArrayList<Move> moves = new ArrayList();
    static ArrayList<Point> snake = new ArrayList();

    static int[] dx = { 0, 0, 1, -1 }; // 0:E, 1:W, 2:S, 3:N
    static int[] dy = { 1, -1, 0, 0 };

    static int[] rightD = { 2, 3, 1, 0 }; // S, N, W, E
    static int[] leftD = { 3, 2, 0, 1 }; // N, S, E, W

    static int time = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        apple = new boolean[n + 1][n + 1]; // [주의1] 범위 0행, 0열은 제외
        for (int i = 0; i < k; i++)
            apple[sc.nextInt()][sc.nextInt()] = true;
        l = sc.nextInt();
        for (int i = 0; i < l; i++)
            moves.add(new Move(sc.nextInt(), sc.next()));
        // input

        int dir = 0; // 오른쪽 방향(E)
        int x = 1, y = 1; // (1, 1)에서 시작
        snake.add(new Point(x, y)); // 처음 위치

        while (true) {
            time++; // 1초에 1번 이동.

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            Point np = new Point(nx, ny);

            // [종료] 벽에 부딪치거나 자신의 몸에 닿으면
            if (nx <= 0 || ny <= 0 || nx > n || ny > n || snake.contains(np)) {
                System.out.println(time);
                return;
            }

            if (apple[nx][ny]) { // 사과가 있으면
                // 사과 없애고, 이동한 위치(머리 위치) 추가.
                apple[nx][ny] = false;
                snake.add(np); // 머리 위치: 마지막
            } else { // 사과 없으면
                // 몸길이를 줄여 꼬리 위치한 칸 비워줌.
                snake.remove(0); // 꼬리 위치: 처음(index=0)
                snake.add(np);
            }

            // [방향전환] X초가 끝난 뒤에 왼쪽(C가 'L') 또는 오른쪽(C가 'D')로 90도 방향을 회전
            if (!moves.isEmpty()) { // [주의]
                Move m = moves.get(0);

                if (time >= m.getSec()) {
                    String dirStr = m.getDir();

                    // [주의4] dirStr == "L" (X)
                    if (dirStr.equals("L")) // 왼쪽으로 90도 회전.
                        dir = leftD[dir];
                    else if (dirStr.equals("D")) // 오른쪽으로 90도 회전.
                        dir = rightD[dir];

                    moves.remove(0); // 처리한 것은 제거.
                }
            }
            // [주의] 위치 변경.(중요!)
            x = nx;
            y = ny;
        }
    }

    /** sec초 후에 dir 방향으로 90도 방향 전환 */
    public static class Move {
        private int sec;
        private String dir; // "D":오른쪽 , "L":왼쪽

        public Move(int sec, String dir) {
            this.sec = sec;
            this.dir = dir;
        }

        public int getSec() {
            return sec;
        }

        public String getDir() {
            return dir;
        }
    }
}
