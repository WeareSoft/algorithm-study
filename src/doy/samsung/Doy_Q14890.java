package doy.samsung;

import java.util.Scanner;

/* [경사로] https://www.acmicpc.net/problem/14890 */
public class Doy_Q14890 {
    static Scanner s = new Scanner(System.in);
    static int n, l, res = 0;
    static int[][] map;
    static int[] col;

    public static void run() {
        n = s.nextInt();
        l = s.nextByte();

        map = new int[n][n];
        col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = s.nextInt();
            }
        }

        // 행 검사
        for (int i = 0; i < n; i++) {
            check(map[i]);
        }

        // 열 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                col[j] = map[j][i];
            }
            check(col);
        }

        System.out.println(res);
    }

    private static void check(int[] arr) {
        int i, sameValueCount = 1; // 연속으로 같은 칸의 개수, 기본값 1

        for (i = 0; i < n - 1; i++) {
            int diff = arr[i + 1] - arr[i]; // 현재 칸과 다음 칸의 차이
            if (diff == 0) { // 같음
                sameValueCount++;
            } else if (diff == 1) { // 1 높은 칸
                if (sameValueCount >= l) // 연속으로 같은 칸의 개수가 경사로 길이(l) 보다 크거나 같으면 경사로 둘 수 있음
                    sameValueCount = 1; // 칸의 높이가 바뀌었으므로 초기화
                else
                    break;
            } else if (diff == -1) { // 1 낮은 칸
                if (sameValueCount >= 0) // 연속으로 같은 칸의 개수가 음수가 아니면
                    sameValueCount = -l + 1; // 앞으로 연속으로 같은 칸의 개수가 적어도 l 개 필요 (앞으로 낮은 칸만 나오면 l개, 높은 칸이 나오면 2*l개 필요)
                else
                    break;
            } else {
                break;
            }
        }

        // for문을 끝까지 반복하고, 연속으로 같은 칸의 개수가 음수가 아니면
        if (i == n - 1 && sameValueCount >= 0) {
            res++;
        }
    }
}
