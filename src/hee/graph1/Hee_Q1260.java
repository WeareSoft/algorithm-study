package hee.graph1;

import java.util.*;

// 그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램
public class Hee_Q1260 {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        int N = scanner.nextInt(); // 정점의 개수 N(1 ≤ N ≤ 1,000)
        int M = scanner.nextInt(); // 간선의 개수 M(1 ≤ M ≤ 10,000)
        int V = scanner.nextInt(); // 탐색을 시작할 정점의 번호

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

        // 정점 번호 오름차순 정렬
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(arrayLists.get(i));
        }

        boolean[] visited = new boolean[arrayLists.size() + 1]; // 정점의 방문 여부 판단 (초깃값: false)
        dfs(arrayLists, V, visited); // 깊이 우선 탐색

        System.out.println();
        bfs(arrayLists, V); // 너비 우선 탐색
    }


    /** 너비 우선 탐색 */
    public static void bfs(ArrayList<ArrayList<Integer>> arrayLists, int startV) {
        boolean[] visited = new boolean[arrayLists.size() + 1]; // 정점의 방문 여부 판단 (초깃값: false)
        Queue<Integer> queue = new LinkedList();
        queue.offer(startV); // root 정점을 큐에 삽입
        visited[startV] = true; // root 정점 방문 표시

        while (!queue.isEmpty()) {
            int v = queue.poll(); // 큐에서 정점을 뺀 후, 방문
            System.out.print(v + " ");

            // 해당 정점과 연결된 모든 인접 정점을 방문
            for (int adjaV : arrayLists.get(v)) {
                // 방문하지 않았던 정점이라면
                if (!visited[adjaV]) {
                    queue.offer(adjaV); // 인접 정점을 큐에 삽입
                    visited[adjaV] = true; // 인접 정점 방문 표시
                }
            }
        }
    }

    /** 깊이 우선 탐색 */
    public static void dfs(ArrayList<ArrayList<Integer>> arrayLists, int startV, boolean[] visited) {
        visited[startV] = true; // root 정점 방문 표시
        System.out.print(startV + " "); // 방문

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
