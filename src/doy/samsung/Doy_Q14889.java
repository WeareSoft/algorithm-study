package doy.samsung;

import java.util.Scanner;

/* [스타트와 링크] https://www.acmicpc.net/problem/14889
    스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력 */
public class Doy_Q14889 {
    static Scanner s = new Scanner(System.in);
    static int n, res = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] selected;

    public static void run() {
        n = s.nextInt();
        map = new int[n][n];
        selected = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = s.nextInt();
            }
        }

        // n 명 중  n/2 명 선택하는 모든 경우의 수
        search(0, 0);

        System.out.println(res);
    }

    private static void search(int idx, int depth) {
        if (depth == n / 2) {
            // 각 팀의 능력치 계산
            calculateAbility();
            return;
        }

        for (int i = idx; i < n; i++) {
            // i번째 팀원 선택
            selected[i] = true;
            // 다음 팀원 선택
            search(i + 1, depth + 1);
            // backtracking
            selected[i] = false;
        }
    }

    private static void calculateAbility() {
        int teamSAbility = 0, teamLAbility = 0;

        // [스타트 팀] selected : true
        // [링크 팀] selected : false
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (selected[i] && selected[j]) {
                    teamSAbility += map[i][j];
                } else if (!selected[i] && !selected[j]) {
                    teamLAbility += map[i][j];
                }
            }
        }

        int diff = Math.abs(teamSAbility - teamLAbility);
        res = Math.min(res, diff);
    }
}
