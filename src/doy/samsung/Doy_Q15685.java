package doy.samsung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* [드래곤 커브] https://www.acmicpc.net/problem/15685
    드래곤 커브의 정보는 네 정수 x, y, d, g로 이루어져 있다.
    x, y : 드래곤 커브의 시작 점
    d : 시작 방향 0 (→), 1 (↑), 2 (←), 3(↓)
    g : 세대
    정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수를 출력 */
public class Doy_Q15685 {
    static Scanner s = new Scanner(System.in);
    static boolean[][] visited = new boolean[101][101];
    // 배열 방향정보 : 0 (→), 1 (↑), 2 (←), 3(↓), 4(대각선아래)
    static int[] dx = {0, -1, 0, 1, 1};
    static int[] dy = {1, 0, -1, 0, 1};
    static int res = 0;

    static class DragonCurve {
        int x, y;
        int direction;
        int generation;

        public DragonCurve(int y, int x, int direction, int generation) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.generation = generation;
        }
    }

    public static void run() {
        int curveNum = s.nextInt();
        DragonCurve[] dragonCurves = new DragonCurve[curveNum];

        for (int i = 0; i < curveNum; i++) {
            dragonCurves[i] = new DragonCurve(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
            // 입력한 드래곤 커브 세팅
            setDragonCurve(dragonCurves[i]);
        }

        // 4개 꼭지점이 모두 선택(visited true)된 사각형 탐색
        countRec();
        System.out.println(res);
    }

    private static void setDragonCurve(DragonCurve dragonCurve) {
        List<Integer> directions = new ArrayList<>();
        directions.add(dragonCurve.direction);

        // 세대만큼 반복
        for (int j = 0; j < dragonCurve.generation; j++) {
            // 움직일 방향 추가 (기존에 가지고있는 방향 거꾸로, 1씩 더하기)
            for (int k = directions.size() - 1; k >= 0; k--) {
                int dir = directions.get(k);
                directions.add((dir + 1) % 4);
            }
        }

        // 시작지점부터 방향에 따라 그림
        draw(dragonCurve.x, dragonCurve.y, directions);
    }

    private static void draw(int x, int y, List<Integer> directions) {
        visited[x][y] = true;
        for (int direction : directions) {
            x = x + dx[direction];
            y = y + dy[direction];
            visited[x][y] = true;
        }
    }

    private static void countRec() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                // 0(→) 3(↓) 4(대각선 아래) 체크
                if (visited[i][j] && visited[i + dx[0]][j + dy[0]] && visited[i + dx[3]][j + dy[3]] && visited[i + dx[4]][j + dy[4]]) {
                    res++;
                }
            }
        }
    }
}
