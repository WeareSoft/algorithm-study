package hee.samsung;

import java.util.Scanner;
import java.util.ArrayList;

public class Hee_Q14891 {
    static int[][] Gears = new int[4][8];
    static int result = 0;
//    static Gear[] gear;

    /** 1. 재귀 이용 */
    public static void run() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            String NSnum = sc.nextLine();

            for (int j = 0; j < 8; j++)
                Gears[i][j] = NSnum.charAt(j) - '0';
        }

        int K = sc.nextInt(); // 회전 횟수 K

        for (int i = 0; i < K; i++) {// K번 회전시킨다.
            int oriGearNum = sc.nextInt() - 1; // 회전시킨 톱니바퀴의 번호
            int direction = sc.nextInt(); // 회전시킨 방향 (1: 시계, -1: 반시계)

            // 최초의 LorR은 -1로 양방향으로 모두 재귀 시작.
            Turn(oriGearNum, direction, -1);
        }

        /* 12시 방향(index=0)의 값으로 결과 값 출력. */
        result = (Gears[0][0] * 1) + (Gears[1][0] * 2) + (Gears[2][0] * 4) + (Gears[3][0] * 8);
        System.out.println(result);
    }

    /* LorR은 기준 톱니바퀴의 왼쪽(1) 또는 오른쪽(0)으로 탐색. */
    public static void Turn(int gearNum, int direction, int LorR) {
        /* 왼쪽으로 탐색 */
        // 현재(gearNum) 톱니바퀴의 index 6와 왼쪽 톱니바퀴(gearNum - 1)의 index 2 비교
        if (gearNum != 0 && Gears[gearNum][6] != Gears[gearNum - 1][2] && LorR != 0)
            // 자신의 왼쪽(num-1), 방향은 지금과 반대로, 계속해서 왼쪽으로 재탐색
            Turn(gearNum - 1, direction * (-1), 1);

        /* 오른쪽으로 탐색 */
        // 현재(gearNum) 톱니바퀴의 index 2와 왼쪽 톱니바퀴(gearNum + 1)의 index 6 비교
        if (gearNum != 3 && Gears[gearNum][2] != Gears[gearNum + 1][6] && LorR != 1)
            // 자신의 오른쪽(num+1), 방향은 지금과 반대로, 계속해서 오른쪽으로 재탐색
            Turn(gearNum + 1, direction * (-1), 0);

        if (direction == 1) { // 시계방향 (1)
            int tmp = Gears[gearNum][7]; // 맨 뒤의 값을 맨 앞으로
            for (int i = 7; i > 0; i--) {
                Gears[gearNum][i] = Gears[gearNum][i - 1];
            }
            Gears[gearNum][0] = tmp;

        } else { // 반시계방향 (-1)
            int tmp = Gears[gearNum][0]; // 맨 앞의 값을 맨 뒤로
            for (int i = 0; i < 7; i++) {
                Gears[gearNum][i] = Gears[gearNum][i + 1];
            }
            Gears[gearNum][7] = tmp;
        }
    }

    /** 2. 흐름에 따라 단순한 반복문 이용 */
//    public static void run() {
//        Scanner sc = new Scanner(System.in);
//        gear = new Gear[5];
//
//        for (int i = 1; i <= 4; i++) {
//            String info = sc.nextLine();
//            ArrayList<Integer> al = new ArrayList();
//
//            for (int j = 0; j < info.length(); j++) {
//                al.add(info.charAt(j) - '0');
//                gear[i] = new Gear(al);
//            }
//        } // 입력.
//        int K = sc.nextInt();
//
//        while (K-- > 0) {
//            int gearNum = sc.nextInt(); // 회전시킨 톱니바퀴의 번호
//            int direction = sc.nextInt(); // 회전기킨 방향
//
//            // 기준 톱니바퀴의 회전방향 설정.
//            gear[gearNum].setDirection(direction);
//
//            int preNum = gearNum;
//            int nextNum = gearNum;
//            /* 기준 톱니바퀴의 왼쪽으로 탐색. */
//            while (nextNum > 1) {
//                nextNum--;
//
//                // 왼쪽 톱니바퀴(next)의 index 2와 현재(pre) 톱니바퀴의 index 6을 비교
//                int next = gear[nextNum].al.get(2);
//                int pre = gear[preNum].al.get(6);
//
//                // 이전 톱니바퀴가 회전하지 않거나 두 전극이 같으면 회전하지 않는다.
//                if (gear[preNum].direction == 0 || pre == next) {
//                    gear[nextNum].setDirection(0); // 회전 방향: 0
//                } else { // 두 전극이 다르면 반대 방향으로 회전한다.
//                    gear[nextNum].setDirection(gear[preNum].direction * -1); // 회전 방향: 반대
//                }
//                preNum = nextNum; // 이전 톱니바퀴를 변경.
//            }
//
//            preNum = gearNum;
//            nextNum = gearNum;
//            /* 기준 톱니바퀴의 오른쪽으로 탐색. */
//            while (nextNum < 4) {
//                nextNum++;
//
//                // 오른쪽 톱니바퀴(next)의 index 6과 현재(pre) 톱니바퀴의 index 2을 비교
//                int next = gear[nextNum].al.get(6);
//                int pre = gear[preNum].al.get(2);
//
//                // 이전 톱니바퀴가 회전하지 않거나 두 전극이 같으면 회전하지 않는다.
//                if (gear[preNum].direction == 0 || pre == next) {
//                    gear[nextNum].setDirection(0); // 회전 방향: 0
//                } else { // 두 전극이 다르면 반대 방향으로 회전한다.
//                    gear[nextNum].setDirection(gear[preNum].direction * -1); // 회전 방향: 반대
//                }
//                preNum = nextNum; // 이전 톱니바퀴를 변경.
//            }
//
//            /* 톱니바퀴에 지정한 회전방향에 따라 전극을 재설정. */
//            for (int i = 1; i <= 4; i++) {
//                ArrayList<Integer> al = gear[i].al;
//                int dir = gear[i].direction;
//
//                if (dir == 1) { // 시계 방향이면
//                    // 맨 뒤의 값을 맨 앞으로
//                    al.add(0, al.remove(al.size() - 1));
//                } else if (dir == -1) { // 반시계 방향이면
//                    // 맨 앞의 값을 맨 뒤로
//                    al.add(al.remove(0));
//                }
//            }
//        }
//
//        /* 12시 방향의 값으로 결과 값 출력. */
//        int result = 0;
//        for (int i = 1; i <= 4; i++) {
//            ArrayList<Integer> al = gear[i].al;
//            if (al.get(0) == 1) { // 12시 방향(index=0)의 전극이 S극이면
//                result += (Math.pow(2, i - 1));
//            }
//        }
//        System.out.println(result);
//    }
//
//    public static class Gear {
//        public ArrayList<Integer> al; // 전극 정보
//        public int direction; // 방향
//
//        public Gear(ArrayList<Integer> al) {
//            this.al = al; // 0: N극, 1: S극
//            this.direction = 0; // 초기: 움직이지 않는다, -1: 반시계, 1: 시계
//        }
//
//        public void setAL(ArrayList<Integer> al) {
//            this.al = al;
//        }
//
//        public void setDirection(int direction) {
//            this.direction = direction;
//        }
//    }

}