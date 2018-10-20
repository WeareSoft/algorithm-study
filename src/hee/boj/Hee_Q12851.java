package hee.boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 숨바꼭질2
public class Hee_Q12851 {
    static int n, k;
    static boolean[] visited = new boolean[100001];

    static int time = -1;
    static int minTime = Integer.MAX_VALUE;
    static int way = 0;

    public static void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        bfs();
        System.out.println(minTime);
        System.out.println(way);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList();
        queue.add(n); // 처음 수빈이의 위치 추가
//		visited[n] = true;

        while (!queue.isEmpty()) {
            time++;
            int size = queue.size(); // n초 후에 갈 수 있는 모든 위치

            for (int i = 0; i < size; i++) {
                int check = queue.poll(); // 점검할 위치
                // 큐에서 점검할 위치를 뺄 때 방문 표시한다.
                visited[check] = true; // [주의] 여기서 방문 표시!

                if (check == k) { // 점검할 위치가 수빈이 동생의 위치와 같으면
                    if (time <= minTime) { // 이 위치에 도달한 가장 빠른 시간이면
                        minTime = time;
                        way++; // 방법++
                    } else
                        return;
                }

                // 순간이동 할 수 있는 경우의 수
                int c1 = check - 1;
                int c2 = check + 1;
                int c3 = check * 2;

                if (c1 >= 0 && !visited[c1]) { // [주의] 방문하지 않았던 위치에 대해서만
//					visited[c1] = true;
                    queue.add(c1);
                }
                if (c2 <= 100000 && !visited[c2]) {
//					visited[c2] = true;
                    queue.add(c2);
                }
                if (c3 <= 100000 && !visited[c3]) {
//					visited[c3] = true;
                    queue.add(c3);
                }
            }
        }
    }
}
