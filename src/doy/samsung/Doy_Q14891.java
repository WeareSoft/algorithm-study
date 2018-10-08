package doy.samsung;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* [톱니바퀴] https://www.acmicpc.net/problem/14891
   N극은 0, S극은 1
   톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하는 프로그램을 작성
 */
public class Doy_Q14891 {
    static Scanner s = new Scanner(System.in);
    static Wheel[] wheels = new Wheel[4];
    static boolean[] visited;

    static class Wheel {
        List<Character> tooth = new ArrayList<>();
        int direction;

        public Wheel(String toothInfo) {
            for (int i = 0; i < 8; i++) {
                tooth.add(toothInfo.charAt(i));
            }
        }

        public void rotate() {
            if (direction == 1) { // 시계 방향으로 회전
                char tmp = tooth.get(7);
                tooth.remove(7);
                tooth.add(0, tmp);
            } else { // 반시계 방향으로 회전
                char tmp = tooth.get(0);
                tooth.remove(0);
                tooth.add(tmp);
            }
        }
    }

    public static void run() {
        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(s.next());
        }

        int k = s.nextInt();
        for (int i = 0; i < k; i++) {
            int wheelNum = s.nextInt();
            int direction = s.nextInt();
            visited = new boolean[4];
            rotateWheel(wheelNum - 1, direction);
        }

        int score = getScore();
        System.out.print(score);
    }


    private static void rotateWheel(int wheelNum, int direction) {
        visited[wheelNum] = true;
        // 방향 설정
        wheels[wheelNum].direction = direction;

        // 왼쪽 톱니바퀴가 존재하고 확인하지 않았으면
        if (wheelNum != 0 && !visited[wheelNum - 1]) {
            // 맞닿은 톱니가 다른 극이면
            if (wheels[wheelNum].tooth.get(6) != wheels[wheelNum - 1].tooth.get(2)) {
                // 왼쪽 톱니바퀴 방향 설정하고 회전
                rotateWheel(wheelNum - 1, -direction);
            }
        }

        // 오른쪽 톱니바퀴가 존재하고 확인하지 않았으면
        if (wheelNum != 3 && !visited[wheelNum + 1]) {
            // 맞닿은 톱니가 다른 극이면
            if (wheels[wheelNum].tooth.get(2) != wheels[wheelNum + 1].tooth.get(6))
                // 오른쪽 톱니바퀴 방향 설정하고 회전
                rotateWheel(wheelNum + 1, -direction);
        }

        // 바퀴 회전
        wheels[wheelNum].rotate();
    }

    private static int getScore() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels[i].tooth.get(0) == '1')
                sum += Math.pow(2, i);
        }
        return sum;
    }
}
