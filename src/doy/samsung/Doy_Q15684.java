package doy.samsung;

import java.util.Scanner;

/* [사다리 조작] https://www.acmicpc.net/problem/15684
    첫째 줄에 세로선의 개수 N, 가로선의 개수 M, 세로선마다 가로선을 놓을 수 있는 위치의 개수 H
    둘째 줄부터 M개의 줄에는 가로선의 정보(x, y)
    i번 세로선의 결과가 i번이 나오도록 사다리 게임을 조작하려면, 추가해야 하는 가로선 개수의 최솟값을 출력한다.
    만약, 정답이 3보다 큰 값이면 -1을 출력한다. 또, 불가능한 경우에도 -1을 출력한다. */
public class Doy_Q15684 {
    static Scanner s = new Scanner(System.in);
    static int n, m, h, res = -1;
    static int[][] map;

    public static void run() {
        n = s.nextInt();
        m = s.nextInt();
        h = s.nextInt();
        map = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            map[x][y] = 1;
        }

        // 추가해야 하는 가로선 개수(0 ~ 3개)
        for (int i = 0; i < 4; i++) {
            // 가로선을 i개 추가하는 모든 경우의 수
            search(1, 0, i);
            // res 값이 바뀌었으면 반복문 나감
            if (res != -1) break;
        }

        System.out.println(res);
    }

    private static void search(int x, int cnt, int maxCnt) {
        if (res != -1) return; // res 값이 바뀌었으면
        if (cnt == maxCnt) { // 추가해야 하는 가로선을 다 추가했으면
            if (rideLadder())
                res = cnt;
            return;
        }

        // 다음 추가해야 할 가로선 찾기
        // 왼쪽->오른쪽 으로 순회하므로 현재 순회중인 x좌표를 다음 가로선을 찾을 때 넘겨주면 반복되는 조합 없앨 수 있음
        for (int i = x; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                // 현재 위치에 가로선이 있으면 오른쪽으로 2칸 뛰어넘음
                if (map[i][j] == 1) {
                    j+=1;
                    continue;
                // 현재 위치 다음칸에 가로선이 있으면 오른쪽으로 3칸 뛰어넘음
                } else if (map[i][j+1] == 1) {
                    j+=2;
                    continue;
                }

                // i, j 좌표인 가로선 선택
                map[i][j] = 1;
                // 다음 가로선 찾기
                search(i, cnt + 1, maxCnt);
                // backtracking
                map[i][j] = 0;
            }
        }
    }

    // i번째 사다리 결과가 i인지 확인
    private static boolean rideLadder() {
        for (int i = 1; i <= n; i++) {
            int y = i;
            for (int x = 1; x <= h; x++) {
                // 해당 위치 확인
                if (map[x][y] == 1)
                    y++; // 오른쪽 이동
                // 해당 위치 왼쪽 확인
                else if (map[x][y - 1] == 1)
                    y--; // 왼쪽 이동
            }
            if (y != i)
                return false;
        }
        return true;
    }
}
