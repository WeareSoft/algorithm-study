package hee.samsung;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q16234 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, l, r;

    static int[][] map;
    static int[][] tmpMap;

    static ArrayList<Point> union; // 연합을 이루는 국가들
    static boolean[][] visited; // 해당 국가가 이미 연합을 형성했는지 여부

    static int res = 0; // 인구 이동 횟수
    static boolean flag = false; // 오늘 하루동안 인구 이동이 있었는지 여부

    public static void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        map = new int[n][n];
        tmpMap = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] = sc.nextInt();
        // input

        while (true) {
            visited = new boolean[n][n]; // 연합 형성 여부 초기화
            flag = false; // 인구 이동이 있었는지 여부 초기화

            // 인구 이동 후 결과를 저장할 임시 공간에 기존 인구 정보 저장
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    tmpMap[i][j] = map[i][j];

            // 모든 좌표를 돌면서 탐색 (1회전의 과정)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    union = new ArrayList<>(); // 초기화

                    // 연합이 형성되지 않은 국가에 대해서만 탐색
                    if (!visited[i][j]) {
                        visited[i][j] = true; // 해당 국가는 연합을 형성함
                        union.add(new Point(i, j)); // 연합에 추가
                        dfs(i, j);

                        /* 인구 이동 시작: 연합 국가들에 대해 새로운 인구를 설정 */
                        // (연합의 인구수)
                        int sum = 0;
                        for (int k = 0; k < union.size(); k++) {
                            Point point = union.get(k);
                            sum += tmpMap[point.x][point.y];
                        }
                        // (연합의 인구수) / (연합을 이루고 있는 칸의 개수)
                        int value = sum / union.size();
                        for (int k = 0; k < union.size(); k++) {
                            Point point = union.get(k);
                            tmpMap[point.x][point.y] = value; // 연합을 이루고 있는 각 칸의 인구수
                        }
                    }
                }
            }
            /* [종료] 인구 이동이 발생한 곳이 없다면 종료 */
            if (flag == false)
                break;

            // 인구 이동 후 최종 결과를 저장
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    map[i][j] = tmpMap[i][j];

            // 인구 이동 횟수 증가
            res++;

        } // while 끝.

        /* [결과 출력] */
        System.out.println(res);
    }

    public static void dfs(int x, int y) {
        // 상하좌우로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            Point np = new Point(nx, ny);

            // 범위 내이고
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                int diff = Math.abs(map[x][y] - map[nx][ny]); // 두 나라의 인구수 차이

                // 연합에 포함되어 있지 않은 국가이고, 연합할 수 있는 국가면
                if (diff >= l && diff <= r && !union.contains(np)) {
                    visited[nx][ny] = true; // 해당 국가는 연합을 형성함
                    union.add(np); // 연합에 추가
                    flag = true; // 인구 이동 발생

                    dfs(nx, ny);
                }
            }
        }
    }
}
