package hee.graph1;

import java.util.ArrayList;
import java.util.Scanner;

public class Hee_Q11724 {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int N = scanner.nextInt(); // 정점의 개수 N(1 ≤ N ≤ 1,000)
        int M = scanner.nextInt(); // 간선의 개수 M(1 ≤ M ≤ 10,000)

        // 가중치가 없는 그래프를 인접리스트로 표현
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) { // 정점의 수 + 1만큼 초기화
            arrayLists.add(new ArrayList<Integer>());
        }

        // 양방향 그래프의 정점 연결
        while (M-- > 0) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();

            arrayLists.get(v1).add(v2);
            arrayLists.get(v2).add(v1);
        }

        // dfs 탐색
        boolean[] visited = new boolean[N + 1];
        int cntComponent = 0;
        // 각 정점에 대해서 한번씩 확인.
        for (int i=1; i<=N; i++) {
            if (!visited[i]) { // 방문했던 정점은 지나치므로, 연결이 떨어진 정점에 대해서만 카운트++
                dfs(arrayLists, i, visited);
                cntComponent++;
            }
        }
        System.out.println(cntComponent);
    }

    /** 깊이 우선 탐색 */
    public static void dfs(ArrayList<ArrayList<Integer>> arrayLists, int startV, boolean[] visited) {
        visited[startV] = true; // root 정점 방문 표시
//        System.out.print(startV + " "); // 방문

        // 방문한 정점과 인접한 정점들을 가져온다.
        for (int adjaV: arrayLists.get(startV)) {
            // 방문하지 않았던 정점이라면
            if (!visited[adjaV]) {
                // 해당 정점을 시작 노드로 다시 bfs 시작
                dfs(arrayLists, adjaV, visited);
            }
        }
    }
}