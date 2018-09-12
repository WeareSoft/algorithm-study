package hee.graph1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Hee_Q1707 {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> arrayLists;
    //    public enum color {RED, BLUE}
    static final int RED = 1;
    static final int BLUE = -1;
    static int[] colors; // 색 {RED 1 or BLUE 2}
    static boolean checkBipartite; // 이분 그래프인지 아닌지 확인


    public static void run() {
        int testCase = scanner.nextInt();

        while (testCase-- > 0) {
            int V = scanner.nextInt(); // 정점의 개수 V(1≤V≤20,000)
            int E = scanner.nextInt(); // 간선의 개수 E(1≤E≤200,000)

            arrayLists = new ArrayList<>();
            colors = new int[V + 1]; // 각 정점의 색을 구분
            checkBipartite = true; // 초기: 이분 그래프이다.

            for (int i = 0; i < V + 1; i++) {
                arrayLists.add(new ArrayList<Integer>()); // 정점의 수 + 1만큼 초기화
                colors[i] = 0; // 방문하지 않은 정점의 색을 초기화
            }

            // 양방향 그래프 연결
            while (E-- > 0) {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();

                arrayLists.get(v1).add(v2);
                arrayLists.get(v2).add(v1);
            }

            // 이분 그래프: 같은 레벨의 꼭짓점끼리는 무조건 같은 색, 인접한 정점 사이는 다른 색
            // 주의! 연결 그래프와 비연결 그래프(모든 정점을 돌면서 확인) 모두 고려!!
            for (int i = 1; i < V + 1; i++) {
                // 이분 그래프가 아니면 반복문 탈출
                if (!checkBipartite)
                    break;

                // 방문하지 않은 정점에 대해서 dfs 실행
                if (colors[i] == 0) {
//                    dfs(i, RED); /* 깊이 우선 탐색 */
                    bfs(i, RED); /* 너비 우선 탐색 */
                }
            }

            System.out.println(checkBipartite ? "YES" : "NO");
        }

    }

    /* 깊이 우선 탐색 */
    static void dfs(int startV, int color) {
        colors[startV] = color; // 시작 정점의 색을 설정

        for (int adjV : arrayLists.get(startV)) {
            // 시작 정점의 색과 인접한 정점의 색이 같으면 이분 그래프가 아니다.
            if (colors[adjV] == color) {
                checkBipartite = false;
                return;
            }

            // 시작 정점과 인접한 정점이 방문하지 않은 정점이면 dfs 실행
            if (colors[adjV] == 0) {
                // 인접한 정점을 다른 색으로 지정
                dfs(adjV, -color);
            }
        }

    }

    /* 너비 우선 탐색 */
    static void bfs(int startV, int color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startV); // root 정점을 큐에 삽입
        colors[startV] = color; // root 정점 방문 표시 + 색 표시

        // 큐가 비어있지 않고 이분 그래프 == ture 면 반복
        while (!queue.isEmpty() && checkBipartite) {
            int v = queue.poll(); // 큐에서 정점 추출

            // 해당 정점과 연결된 모든 인접 정점을 방문
            for (int adjV : arrayLists.get(v)) {
                // 방문하지 않은 정점이면
                if (colors[adjV] == 0) {
                    queue.offer(adjV); // 인접 정점을 큐에 삽입
                    colors[adjV] = colors[v] * -1; // 인접한 정점을 다른 색으로 지정
                }
                // 서로 인접한 정점의 색이 같은 색이면 이분 그래프가 아니다.
                else if (colors[v] + colors[adjV] != 0) {
                    checkBipartite = false;
                    return;
                }
            }
        }
    }
}


// reference: https://casterian.net/archives/78
// reference: http://sanghoon9939.tistory.com/33

// solution: http://stack07142.tistory.com/104
