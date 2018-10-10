package hee.swexpert;

import java.awt.Point;
import java.util.Scanner;

// 최적경로 (테스트케이스는 모두 통과, but 시간초과)
public class Hee_Q1247 {
    static int c, n;
    static Point home;
    static Point office;
    static Point[] customer;
    static boolean visited[];

    static int minDis = Integer.MAX_VALUE;
    static int dis = 0;
    static int cnt = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt(); // 테스트케이스

        for (int i = 1; i <= c; i++) {
            System.out.print("#" + i + " ");
            n = sc.nextInt();
            home = new Point(sc.nextInt(), sc.nextInt());
            office = new Point(sc.nextInt(), sc.nextInt());
            customer = new Point[n];
            visited = new boolean[n];
            minDis = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                customer[j] = new Point(sc.nextInt(), sc.nextInt());
            }

            dfs(0, 0, office, 0);
            System.out.println(minDis);
        }
    }

    static void dfs(int start, int depth, Point pre, int sum) {
        // 출력(n개의 고객 집을 모두 돌았으면.)
        if (depth == n) {
            sum += getDis(customer[start], home);
            minDis = Math.min(minDis, sum);
            return;
        }

        // 재탐색.
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) { // 방문하지 않았으면,

                visited[i] = true; // 방문 표시하고 거리 재기.
                sum += getDis(customer[i], pre);

                dfs(i, depth + 1, customer[i], sum); // 재귀.

                visited[i] = false; // 백트래킹.
                sum -= getDis(customer[i], pre);
            }
        }
    }

    static int getDis(Point now, Point pre) {
        return Math.abs(now.x - pre.x) + Math.abs(now.y - pre.y);
    }
}
