package doy.samsung;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Doy_Q16235 {
    static Scanner s = new Scanner(System.in);
    static int n, m, k;
    static int[][] map, winterMap;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}; // 8개의 인접한 칸
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static List<Tree> tree = new LinkedList<>(); // 나무 저장
    static List<Tree> fiveTree = new LinkedList<>(); // 나이가 5의 배수인 나무 저장

    public static void run() {
        n = s.nextInt();
        m = s.nextInt();
        k = s.nextInt();

        map = new int[n + 1][n + 1];
        winterMap = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] = 5;
                winterMap[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int x = s.nextInt();
            int y = s.nextInt();
            int age = s.nextInt();
            tree.add(new Tree(x, y, age));
        }

        for (int i = 0; i < k; i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(tree.size());
    }

    private static void spring() {
        for (Tree t : tree) {
            // 양분을 먹을 수 없는 나무 죽음
            if (map[t.x][t.y] < t.age) {
                t.dead();
                continue;
            }

            // 자신의 나이만큼 양분을 먹고, 나이 1 증가
            map[t.x][t.y] -= t.age;
            t.addAge();

            // 나이가 5의 배수인 나무 추가
            if (t.age % 5 == 0) {
                fiveTree.add(t);
            }
        }
    }

    private static void summer() {
        Iterator<Tree> it = tree.iterator();
        while (it.hasNext()) {
            Tree t = it.next();

            // 죽은 나무의 나이 2로 나눈 값 양분으로 추가
            if (t.isDead) {
                map[t.x][t.y] += t.age / 2;
                it.remove();
            }
        }
    }

    private static void fall() {
        // 나이가 5의 배수인 나무의 인접한 8개의 칸 나무 생성
        for (Tree t : fiveTree) {
            for (int i = 0; i < 8; i++) {
                int nextX = t.x + dx[i];
                int nextY = t.y + dy[i];
                if (nextX < 1 || nextX > n || nextY < 1 || nextY > n) continue;
                // 나이가 1인 나무 0번 index에 추가 (봄에 나이가 어린 나무부터 양분을 먹으므로)
                tree.add(0, new Tree(nextX, nextY, 1));
            }
        }

        fiveTree.clear();
    }

    private static void winter() {
        // 양분 추가
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                map[i][j] += winterMap[i][j];
            }
        }
    }

    public static class Tree {
        int x, y, age;
        boolean isDead;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        public void addAge() {
            age++;
        }

        public void dead() {
            isDead = true;
        }
    }
}
