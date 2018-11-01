package hee.samsung;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q16235 {
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
    static int n, m, k;

    static int[][] map;
    static int[][] food;

    static ArrayList<Point> places; // 나무가 존재하는 곳의 위치
    static ArrayList<Integer>[][] trees;// 해당 위치의 나무들의 나이 저장

    static ArrayList<Point> breed; // 번식 기준 위치

    public static void run() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt(); // 초기 나무의 개수
        k = sc.nextInt(); // k년 지난 후

        map = new int[n + 1][n + 1];
        food = new int[n + 1][n + 1];

        places = new ArrayList<>();
        trees = new ArrayList[n + 1][n + 1];
        breed = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = 5;
                food[i][j] = sc.nextInt(); // 매년 추가되는 양분 정보
                trees[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) { // 나무 정보
            int x = sc.nextInt();
            int y = sc.nextInt();
            int age = sc.nextInt();

            places.add(new Point(x, y)); // 나무 존재
            trees[x][y].add(age); // 나무 추가
        } // input

        while (k-- > 0) {
            /* 봄 */
            // 1. 해당 지역의 나무들은 자신의 나이만큼 해당 지역의 양분을 먹는다. (나이가 적은 나무부터)
            // 2. 나무의 나이가 1 증가한다.
            // 3. 자신의 나이만큼 양분을 먹지 못한 나무들은 죽는다.
//            print("봄");
            for (int i = 0; i < places.size(); i++) { // 나무가 있는 위치만 점검
                Point place = places.get(i);
                int x = place.x;
                int y = place.y;

                for (int j = 0; j < trees[x][y].size(); j++) {  // 해당 좌표의 나무들의 개수만큼
                    int age = trees[x][y].get(j); // 나무의 나이
                    map[x][y] -= age; // 나무의 나이만큼 해당 지역의 양분을 먹는다.

                    // 1. 해당 나무가 양분을 먹지 못하는 경우.
                    if (map[x][y] < 0) {
                        map[x][y] += age; // 마지막 양분은 사용하지 않음.

                        // 이 나무 이후의 나무들도 양분을 먹지 못한다. 죽는다.
                        int size = trees[x][y].size(); // [주의]
                        for (int k = j; k < size; k++) {
                            // 여름: 죽은 나무의 나이/2만큼 해당 지역에 양분이 추가된다.
                            map[x][y] += (trees[x][y].get(j) / 2);
                            trees[x][y].remove(j); // 해당 위치에서 나무제거
                        }
                        // 해당 좌표에 대한 점검은 끝.
                        break;
                    }
                    // 2. 해당 나무까지 양분을 먹을 수 있는 경우.
                    else if (map[x][y] == 0) {
                        // 이 나무까지는 양분을 먹고 나이가 + 1
                        trees[x][y].set(j, trees[x][y].get(j) + 1);
                        // 증가한 나이가 5의 배수이면 해당 위치 추가
                        if (trees[x][y].get(j) % 5 == 0) {
                            breed.add(place);
                        }

                        // 그 이후의 나무들은 양분을 먹지 못한다. 죽는다.
                        int size = trees[x][y].size() - 1;
                        for (int k = j; k < size; k++) {
                            // 여름: 죽은 나무의 나이/2만큼 해당 지역에 양분이 추가된다.
                            map[x][y] += (trees[x][y].get(j + 1) / 2);
                            trees[x][y].remove(j + 1); // 해당 위치에서 나무 제거
                        }
                        // 해당 좌표에 대한 점검은 끝.
                        break;
                    }

                    // 해당 나무의 나이 + 1, 다음 나무로 진행
                    trees[x][y].set(j, trees[x][y].get(j) + 1);
                    // 증가한 나이가 5의 배수이면 해당 위치 추가
                    if (trees[x][y].get(j) % 5 == 0) {
                        breed.add(place);
                    }
                }
            } // 봄 끝.

            // 해당 위치의 나무가 없으면 나무가 존재하는 위치에서 제거
            for (int i = 0; i < places.size(); i++) {
                Point p = places.get(i);

                if (trees[p.x][p.y].size() == 0)
                    places.remove(i);
            }

            /* 가을 */
//            print("가을");
            for (int i = 0; i < breed.size(); i++) { // 번식할 위치(나이가 5의 배수인 곳)를 돈다.
                Point p = breed.get(i);

                for (int j = 0; j < 8; j++) { // 인접한 8곳에 나무 추가
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    Point np = new Point(nx, ny);

                    if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                        // 인접한 8곳의 위치에 나이가 1인 나무 추가
                        trees[nx][ny].add(0, 1);

                        // 나무가 존재하는 위치로 추가
                        if (!places.contains(np))
                            places.add(np);
                    }
                }
            }
            breed = new ArrayList<>(); // 초기화


            /* 겨울 */
//            print("겨울");
            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++)
                    map[i][j] += food[i][j]; // 새로 양분 추가
        } // k년 반복 끝.

        /* 살아있는 나무의 수 */
        int res = 0;
        for (int i = 0; i < places.size(); i++) { // 나무가 존재하는 위치만 점검
            Point p = places.get(i);
            ArrayList<Integer> tree = trees[p.x][p.y];

            for (int j = 0; j < tree.size(); j++) // 해당 좌표의 나무들의 개수만큼 증가
                res++;
        }
        System.out.println(res);
    }

    public static void print(String str) {
        System.out.println(6 - k + " 번째 " + str + "시작====");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
