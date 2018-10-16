package hee.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질
public class Hee_Q1697 {
    static int n, k;
    static int[] time = new int[100001];
    static boolean[] visited = new boolean[100001];

    static int minTime = -1;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        bfs1();
//		bfs2();
        System.out.println(minTime);
    }

    public static void bfs1() {
        Queue<Integer> queue = new LinkedList();
        queue.add(n); // 처음 수빈이의 위치 추가
        time[n] = 1;

        while (!queue.isEmpty()) {
            int check = queue.poll(); // 점검할 위치

            if (check == k) { // 점검할 위치가 수빈이 동생의 위치와 같으면 종료
                minTime = time[check] - 1;
                return;
            }

            // 순간이동 할 수 있는 경우의 수
            int c1 = check - 1;
            int c2 = check + 1;
            int c3 = check * 2;

            if (c1 >= 0 && time[c1] == 0) { // [주의] 방문하지 않았던 위치에 대해서만
                time[c1] = time[check] + 1; // 해당 위치까지 가는데 걸린 시간 저장
                queue.add(c1);
            }
            if (c2 <= 100000 && time[c2] == 0) {
                time[c2] = time[check] + 1;
                queue.add(c2);
            }
            if (c3 <= 100000 && time[c3] == 0) {
                time[c3] = time[check] + 1;
                queue.add(c3);
            }
        }
    }

    public static void bfs2() {
        Queue<Integer> queue = new LinkedList();
        queue.add(n); // 처음 수빈이의 위치 추가
        visited[n] = true;

        while (!queue.isEmpty()) {
            minTime++;
            int size = queue.size(); // n초 후에 갈 수 있는 모든 위치

            for (int i = 0; i < size; i++) {
                int check = queue.poll(); // 점검할 위치

                if (check == k) // 점검할 위치가 수빈이 동생의 위치와 같으면 종료.
                    return;

                // 순간이동 할 수 있는 경우의 수
                int c1 = check - 1;
                int c2 = check + 1;
                int c3 = check * 2;

                if (c1 >= 0 && !visited[c1]) { // [주의] 방문하지 않았던 위치에 대해서만
                    visited[c1] = true;
                    queue.add(c1);
                }
                if (c2 <= 100000 && !visited[c2]) {
                    visited[c2] = true;
                    queue.add(c2);
                }
                if (c3 <= 100000 && !visited[c3]) {
                    visited[c3] = true;
                    queue.add(c3);
                }
            }
        }
    }
}
