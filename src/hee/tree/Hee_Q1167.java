package hee.tree;

import java.util.*;

// 트리의 지름을 구하는 프로그램
public class Hee_Q1167 {
    static Scanner scanner = new Scanner(System.in);

    public static class Node {
        int num, dist; // 노드 번호, 거리

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

    private static int[] bfs(int V, ArrayList<Node>[] list, int start) {
        boolean[] visited = new boolean[V + 1]; // default는 false
        int[] dists = new int[V + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start); // 시작 정점을 큐에 넣는다.
        visited[start] = true; // 시작 정점을 방문했다는 정보를 저장한다.

        // 큐에 정점이 없어질 때까지 반복한다.
        while (!queue.isEmpty()) {
            int v = queue.remove();

            for (Node node : list[v]) { // 인접 리스트의 노드를 순서대로 탐색한다.
                int num = node.num;
                int dist = node.dist;

                if (visited[num] == false) {
                    dists[num] = dists[v] + dist; // 시작 정점으로 부터의 거리를 저장한다.
                    queue.offer(num);
                    visited[num] = true;
                }
            }
        }
        return dists;
    }

    public static void run() {
        int V = scanner.nextInt(); // 정점의 개수

        // 인접 리스트
        ArrayList<Node>[] list = new ArrayList[V + 1];

        // 각 정점들에 대한 정보를 담을 리스트를 초기화
        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < V; i++) {
            int v = scanner.nextInt(); // 정점의 번호

            while (true) {
                int num = scanner.nextInt(); // 연결된 정점의 번호
                if (num == -1) break;
                int dist = scanner.nextInt(); // 연결된 정점과의 거리

                list[v].add(new Node(num, dist)); // 인접 리스트에 추가
            }
        }

        // 1. 루트 정점에서 모든 정점까지의 거리 중 가장 먼 거리였던 정점 A를 구한다.
        int start = 1;
        int[] dists = bfs(V, list, start);
        for (int i = 2; i <= V; i++) {
            if (dists[i] > dists[start]) {
                start = i;
            }
        }

        // 2. A를 기준으로 모든 정점까지의 거리 중 가장 먼 거리에 있는 정점과의 거리가 지름이다.
        dists = bfs(V, list, start);
        int result = dists[1];
        for (int i = 2; i <= V; i++) {
            if (dists[i] > result) {
                result = dists[i];
            }
        }
        System.out.println(result);
    }
}
