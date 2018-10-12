package hee.samsung;

import java.util.ArrayList;
import java.util.Scanner;

/** 문제 풀이 방법
 * 1. 시작 방향에 따른 세대의 방향을 구한다.
 * 2. 사적 정점으로부터 방향에 맞게 좌표를 구한 후 방문 표시를 한다.
 * 3. (0,0)~(99,99)까지 확인하면서 (+1,0)(0,+1)(+1,+1)이 방문한 좌표면 result++; */
public class Hee_Q15685 {
    static int[][] matrix = new int[101][101];
    static ArrayList<Integer> preDirArr; // 이전 세대의 방향 배열
    static ArrayList<Integer> dirArr;

    // R, U, L, D, 오른쪽 아래 대각선
    static int[] dx = { 1, 0, -1, 0, 1 };
    static int[] dy = { 0, -1, 0, 1, 1 };

    static int result = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            preDirArr = new ArrayList<Integer>();
            getDirectionArr(d, g);
            visitPoint(x, y);
        }

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (matrix[i][j] == 1) {
                    // 0, 3, 4 (정사각형이 포함되는지 확인)
                    if ((matrix[i + dx[0]][j + dy[0]] == 1) && (matrix[i + dx[3]][j + dy[3]] == 1)
                            && (matrix[i + dx[4]][j + dy[4]] == 1)) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }

    public static void getDirectionArr(int startDir, int g) {
        preDirArr.add(startDir);
        dirArr = preDirArr;

        for (int i = 0; i < g; i++) {
            // 이전 세대의 방향을 역순으로 가져와 +1
            for (int j = preDirArr.size() - 1; j >= 0; j--) {
                int dir = (preDirArr.get(j) + 1) % 4; // 4면 0으로 처리
                dirArr.add(dir);
            }
            preDirArr = dirArr;
        }
    }

    public static void visitPoint(int x, int y) {
        matrix[x][y] = 1; // 시작점 방문 표시

        for (int i = 0; i < dirArr.size(); i++) {
            int dir = dirArr.get(i);
            int nextX = x + dx[dir];
            int nextY = y + dy[dir];

            if (nextX <= 100 && nextY <= 100) {
                matrix[nextX][nextY] = 1; // 방문 표시
            }
            x = nextX;
            y = nextY;
        }
    }
}
