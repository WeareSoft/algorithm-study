package hee.samsung;

import java.util.Scanner;

public class Hee_Q14499 {
    static int n, m;
    static int k;

    static int[] dx = { 0, 0, 0, -1, 1 }; // 1:E, 2:W, 3:N, 4:S
    static int[] dy = { 0, 1, -1, 0, 0 };
    static int[][] map;

    static int[] dice = new int[7]; // 1:위(기준), 2:N, 3:E, 4:W, 5:S, 6: 아래

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];

        int x = sc.nextInt();
        int y = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                map[i][j] = sc.nextInt();
        // input

        for (int i = 0; i < k; i++) {
            int moveDir = sc.nextInt(); // 움직일 방향

            // 움직일 방향의 좌표
            int nx = x + dx[moveDir];
            int ny = y + dy[moveDir];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                // 해당 방향으로 움직인다. 주사위의 상태 변경.
                changeDice(moveDir);

                if (map[nx][ny] == 0) {
                    // 주사위 바닥면 -> 칸에 복사
                    map[nx][ny] = dice[6];
                } else {
                    // 칸 -> 주사위 바닥면에 복사, 칸 = 0
                    dice[6] = map[nx][ny];
                    map[nx][ny] = 0;
                }
                // 주사위 상단의 수 출력.
                System.out.println(dice[1]);

                x = nx;
                y = ny;
            }
            // 지도 밖이면 해당 방향으로의 이동 명령을 무시. 다음 명령으로 넘어간다.
        }
    }

    public static void changeDice(int dir) { // 1:E, 2:W, 3:N, 4:S
        int[] tmpDice = new int[7];
        for (int i = 0; i < tmpDice.length; i++)
            tmpDice[i] = dice[i];

        // 1(위방향)을 기준으로 dir 방향으로 주사위 움직임. 각 위치의 값 변경.
        switch (dir) {
            case 1: // 동으로 이동(북, 남의 위치는 고정)
                dice[1] = tmpDice[4];
                dice[3] = tmpDice[1];
                dice[4] = tmpDice[6];
                dice[6] = tmpDice[3];
                break;
            case 2:// 서로 이동(북, 남의 위치는 고정)
                dice[1] = tmpDice[3];
                dice[3] = tmpDice[6];
                dice[4] = tmpDice[1];
                dice[6] = tmpDice[4];
                break;
            case 3:// 북으로 이동(동, 서의 위치는 고정)
                dice[1] = tmpDice[5];
                dice[2] = tmpDice[1];
                dice[5] = tmpDice[6];
                dice[6] = tmpDice[2];
                break;
            case 4:// 남으로 이동(동, 서의 위치는 고정)
                dice[1] = tmpDice[2];
                dice[2] = tmpDice[6];
                dice[5] = tmpDice[1];
                dice[6] = tmpDice[5];
                break;
        }
    }
}
