package hee.samsung;

import java.util.Scanner;

/** 시뮬레이션: 단순한 규칙 찾기 */
public class Hee_Q14890 {
    static int n, l;
    static int[][] map;
    static int res = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 지도의 크기
        l = sc.nextInt(); // 경사로의 길이

        map = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] = sc.nextInt();
        // input

        // 모든 행, 열에 대해 확인.
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] = map[i][j]; /* 행 */
                col[j] = map[j][i]; /* 열 */
            }
            dfs(row);
            dfs(col);
        }
        /* 결과 출력 */
        System.out.println(res);
    }

    public static void dfs(int[] road) {
        boolean[] visited = new boolean[n]; // 경사로 설치 여부

        for (int i = 0; i < road.length - 1; i++) {
            int diff = Math.abs(road[i] - road[i + 1]);

            /* 모든 칸의 높이가 같으면 */
            if (diff == 0)
                continue;
                /* 인접한 칸의 높이차가 1보다 크면 길이 될 수 없음. */
            else if (diff > 1)
                return; // 실패!

            /* 인접한 칸의 높이차가 1일 때 */
            // 1. 왼쪽 칸의 높이가 더 낮으면
            if (road[i] < road[i + 1]) {
                // 왼쪽으로 경사로 설치 가능.
                int height = road[i]; // 왼쪽 높이가 기준

                int firstCheckIdx = i - (l - 1);
                if (firstCheckIdx < 0) // 경사로의 길이를 만족하지 못함
                    return;

                // 이전으로 L-1만큼 이동해서 높이가 같은지 판단
                // 1. 이미 경사로가 설치되었으면 설치 불가능
                // 2. 높이가 같지 않으면 경사로 설치 불가능
                for (int j = firstCheckIdx; j <= i; j++) {
                    if (visited[j] == true || height != road[j]) {
                        return; // 경사로 설치 불가능
                    }
                }

                // 경사로를 설치할 수 있으면 경사로 설치 여부 변경
                for (int j = firstCheckIdx; j <= i; j++) {
                    visited[j] = true;
                }
            }
            // 2. 오른쪽 칸의 높이가 더 낮으면
            else {
                // 오른쪽으로 경사로 설치 가능.
                int height = road[i + 1]; // 오른쪽 높이가 기준

                int lastCheckIdx = i + l;
                if (lastCheckIdx >= road.length) // 경사로의 길이를 만족하지 못함
                    return;

                // 이후로 L만큼 이동해서 높이가 같은지 판단 (위와 동일.)
                for (int j = (i + 1); j <= lastCheckIdx; j++) {
                    if (visited[j] == true || height != road[j]) {
                        return; // 경사로 설치 불가능
                    }
                }

                // 경사로를 설치할 수 있으면 경사로 설치 여부 변경
                for (int j = (i + 1); j <= lastCheckIdx; j++) {
                    visited[j] = true;
                }
            }
        }
        /* 높이가 모두 동일하거나 경사로를 설치를 만족하면 지나갈 수 있음. */
        res++; // 성공! 이동 가능.
        return;
    }
}
