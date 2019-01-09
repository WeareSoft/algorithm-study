package hee.boj.tree;

import java.util.ArrayList;
import java.util.Scanner;

// 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 트리의 지름을 구해서 출력하는 프로그램
public class Hee_Q1967 {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Node>[] list; // 인접 리스트
    static int maxDist = 0; // 트리의 지름
    static int maxDistNode = 0; // 가장 멀리 있는 노드

    public static class Node {
        int num, weight; // 노드 번호, 가중치

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

    private static void dfs(int start, int dist, int[] dists) {
        dists[start] = dist;

        if(dists[start] > maxDist){
            maxDist = dists[start];
            maxDistNode = start;
        }

        for (Node node : list[start]) { // 인접 리스트의 노드를 순서대로 탐색한다.
            int num = node.num;
            int weight = node.weight;

            if(dists[num] == 0) {
                dfs(num, dist + weight, dists); // 재귀 함수 이용
            }
        }
    }

    public static void run() {
        int n = scanner.nextInt(); // 노드의 개수

        list = new ArrayList[n + 1]; // 인접 리스트
        int[] dists = new int[n + 1]; // 노드 사이의 거리

        // 각 정점들에 대한 정보를 담을 리스트를 초기화
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < n - 1; i++) {
            int parent = scanner.nextInt(); // 부모 노드의 번호
            int child = scanner.nextInt(); // 자식 노드의 번호
            int weight = scanner.nextInt(); // 가중치

            // 트리는 방향성이 없는 그래프이기 때문에 연결되는 양쪽에 서로에 대한 정보를 넣어준다.
            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        // 1. 루트 정점에서 모든 정점까지의 거리 중 가장 먼 거리였던 정점 A를 구한다.
        int start = 1;
        dfs(start, 0, dists);

        // 2. A를 기준으로 모든 정점까지의 거리 중 가장 먼 거리에 있는 정점과의 거리가 지름이다.
        maxDist = 0; dists = new int[n + 1]; // 다음 탐색을 위해 초기화
        dfs(maxDistNode, 0, dists);
        System.out.println(maxDist);
    }
}


