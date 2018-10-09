package hee.samsung;

import java.util.Scanner;

/**
 * 문제 풀이 방법: 백트래킹 + DFS(범위 있는 DFS)
 */
public class Hee_Q15684 {
    static int N, M, H;
    static boolean[][] ladderMatrix;
    static int result = -1;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // y축
        M = sc.nextInt(); // 가로선의 수
        H = sc.nextInt(); // x축
        ladderMatrix = new boolean[H + 2][N + 2]; // 1이면 가로선 시작 꼭지점

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ladderMatrix[x][y] = true; // 가로선 시작 꼭지점으로 추가
        }

        // 0~3개 까지 가로선 설치 가능.
        for (int i = 0; i < 4; i++) {
            find(0, i); // 추가할 가로선의 수가 i개 일 때

            if (result != -1) // result에 변경이 있으면 추가한 가로선의 최소값이 나온다.
                break;
        }
        System.out.println(result);
    }

    public static void find(int lineCnt, int total) {
        if (result != -1) // result에 변경이 있으면
            return;

        // [출력]
        if (lineCnt >= total) {
            if (rideLadder()) // 모든 세로줄에 대해 n->n이면
                result = lineCnt; // 추가한 가로선의 수로 result를 변경.
            return;
        }

        // 모든 좌표에 대해 가로선을 추가할 수 있는지 확인.
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= N; j++) {
                // 해당 좌표를 가로선 시작 꼭지점으로 추가할 수 없는 경우
                // (자신의 위치/왼쪽/오른쪽 위치가 이미 추가 되어 있는 경우)
                if (ladderMatrix[i][j] == true || ladderMatrix[i][j + 1] == true || ladderMatrix[i][j - 1] == true)
                    continue;

                ladderMatrix[i][j] = true; // 해당 좌표를 가로선으로 추가.
                find(lineCnt + 1, total);
                ladderMatrix[i][j] = false; // 백트래킹으로 부모로 올라간다.
            }
        }
    }

    /* 사다리 타기 모든 세로줄에 대해 n->n이면 return true; */
    public static boolean rideLadder() {
        for (int i = 1; i <= N; i++) {
            int x = 1;
            int y = i;

            while (x != H + 1) {
                if (ladderMatrix[x][y] == true) {
                    y = y + 1; // 오른쪽으로 이동
                } else if (ladderMatrix[x][y - 1] == true) {
                    y = y - 1; // 왼쪽으로 이동
                }
                // 아래로 이동
                x++;
            }
            if (y != i)
                return false;
        }
        return true;
    }
}
