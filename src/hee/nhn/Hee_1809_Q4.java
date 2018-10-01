package hee.nhn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hee_1809_Q4 {
    static int N;
    static int turnNum = 0; // 턴 수

    static final int MY = 0;
    static final int NEXT = 1;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static String[][] map;
    static int[][] barrier; // 장애물의 정보
    static boolean[][] visited; // 점령 여부의 정보

    static ArrayList<Country> originAL; // 이번 턴에서 조사할 국가의 정보
    static ArrayList<Country> newAL; // 확장된 국가의 정보(다음 턴에서 조사할 국가의 정보)

    public static void run() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new String[N][N];
        barrier = new int[N][N];
        visited = new boolean[N][N];
        originAL = new ArrayList<>();
        newAL = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                String info = sc.next();
                map[i][j] = info;
                barrier[i][j] = 0; // 국가의 위치엔 장애물이 없음 = 0

                char check = info.charAt(0);
                if (check >= '0' && check < '9') { // 숫자면
                    barrier[i][j] = Integer.parseInt(info); // 장애물 표시
                } else { // 알파벳이면
                    originAL.add(new Country(i, j, info)); // 이번 턴에서 조사할 국가로 추가
                    visited[i][j] = true; // 방문 표시
                }
            }
        } // 입력 끝.

        check();
//		System.out.println("result");
        printMap();
    }

    public static void check() {
        // 조사할 국가의 위치가 있으면 반복.
        while (originAL.size() != 0) {
            Country country = originAL.get(0);
            int x = country.x;
            int y = country.y;

            originAL.remove(0); // 이번에 조사할 국가를 제거. 방문

            // 해당 좌표의 상하좌우 좌표를 확인.
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 1. 다음 좌표가 상자의 범위 안에 있으면
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    // 2. 다음 좌표가 방문하지 않은 좌표(점령당하지 않은)이고,
                    if (visited[nextX][nextY] == false) {
                        // 3. 이동할 방향이 장애물로 막혀있지 않고,
                        if (checkBarrier(MY, barrier[x][y], i) == true
                                && checkBarrier(NEXT, barrier[nextX][nextY], i) == true) {
                            // 4. 다음 좌표에 인접한 국가들이 나보다 적으면 점령 가능.
                            if (checkCountry(nextX, nextY, country.name) == true) {
                                // 점령한 좌표와 국가 이름은 다음 턴에 조사할 국가로 저장.
                                newAL.add(new Country(nextX, nextY, country.name));
                            } // 4. 조건
                        } // 3. 조건
                    } // 2. 조건
                } // 1. 조건
            }
            // 한 턴이 끝남.
            if (originAL.size() == 0) {
                if (newAL.size() == 0) // 종료 조건.
                    break;

                turnNum++; // 턴수 증가.
                for (int i = 0; i < newAL.size(); i++) {
                    Country visitedCountry = newAL.get(i);
                    // 방문 표시와 점령 국가 정보를 저장.
                    visited[visitedCountry.x][visitedCountry.y] = true;
                    map[visitedCountry.x][visitedCountry.y] = visitedCountry.name;
                }
                // 확장된 국가(newAL)를 이번 턴에서 조사할 국가(originAL)의 정보로 세팅
                originAL = newAL;
                newAL = new ArrayList<>();
//				printMap();
            }
        }
    }

    /**
     * direction 방향으로 다음 좌표 탐색이 가능한지(장애물로 막혀있는지) 여부
     * <p>
     * 1) 현재 자신의 위치의 장애물 번호로 탐색 가능 여부 판단. 2) 탐색할 위치의 장애물 정보로 탐색 가능 여부 판단.
     *
     * @param caseNum    0: 1)수행, 1: 2)수행
     * @param barrierNum 현재 자신의 위치의 장애물 정보,
     * @param direction  탐색할 방향 (0: 상, 1: 하, 2: 좌, 3: 우)
     * @return ture 탐색 가능, false 탐색 불가능
     * @desctiption 1)의 경우 장애물 확인 방향 동일.
     * @desctiption ---> 0: 상(idx=3), 1: 하(idx=2), 2: 좌(idx=1), 3: 우(idx=0)
     * @desctiption 2)의 경우 장애물 확인 방향 반대.
     * @desctiption ---> 0: 하(idx=2), 1: 상(idx=3), 2: 우(idx=0), 3: 좌(idx=1)
     */
    public static boolean checkBarrier(int caseNum, int barrierNum, int direction) {
        if (barrierNum == 0)
            return true;

        // 10->2진수: 2^3 + 2^2 + 2^1 + 2^0
        String str = Integer.toBinaryString(barrierNum);
        for (int i = 0; i < 4 - str.length(); i++)
            str = "0" + str; // 4자리로 만들기

        /* 확인할 2진수의 index 설정 */
        int checkIndex = 3 - direction; // 기본: MY
        if (caseNum == 1) // NEXT
            checkIndex = (direction + 2) % 4;

        if (str.charAt(checkIndex) == '1') {
            return false; // 막혀 있음
        }
        return true;
    }

    /**
     * 탐색할 다음 좌표에 인접한 영토가 많은 국가가 점령 가능.(즉, 다음 좌표에 인접한 국가가 나보다 적으면 점령 가능)
     *
     * @param x,      y 탐색할 위치
     * @param oriName 점령을 시도한 국가의 이름
     * @return ture 점령 가능, false 점령 불가능
     * @desctiption 영토 수가 동일하면 어느 국가도 점령 불가능.
     * @desctiption 탐색할 다음 좌표의 장애물 정보에 따라 장애물이 있는 쪽의 국가는 해당 좌표로 확장을 하지 못하므로 경우에서 제외.
     */
    public static boolean checkCountry(int x, int y, String oriName) {
        // 다음 좌표의 상하좌우를 모두 탐색 (oriName은 최소 하나는 존재)
        HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

        // 해당 좌표의 상하좌우를 확인.
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            // 1. 해당 좌표가 상자의 범위 안에 있으면
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                // 2. 해당 좌표의 장애물이 있는 쪽의 국가는 해당 좌표로 확장을 하지 못하므로 경우에서 제외.
                if (checkBarrier(MY, barrier[x][y], i) == true) {
                    String checkName = map[nextX][nextY];
                    char check = checkName.charAt(0);
                    // 3. 해당 좌표가 알파벳이면
                    if (check >= 'A' && check <= 'Z') {
                        // 4. 해당 국가가 hashmap에 존재하면 국가의 수 증가
                        if (hashmap.containsKey(checkName)) {
                            hashmap.put(checkName, hashmap.get(checkName) + 1);
                        } else { // 해당 국가가 처음으로 들어오면 국가의 수 + 1
                            hashmap.put(checkName, 1);
                        }
                    }
                }
            }
        }
        // hashmap에서 점령을 시도한 국가(oriName)보다 다른 국가(checkName)가 많으면 점령 불가능.
        int oriNum = hashmap.get(oriName); // 최소 1개 존재
        for (String key : hashmap.keySet()) {
            if (!key.equals(oriName)) {
                int num = hashmap.get(key);
                if (oriNum <= num)
                    return false;
            }
        }
        return true;
    }

    public static void printMap() {
        System.out.println(turnNum); // 턴 수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("\b");
        }
    }

    public static class Country {
        public int x;
        public int y;
        public String name;

        public Country(int x, int y, String name) {
            this.x = x;
            this.y = y;
            this.name = name;
        }
    }
}

