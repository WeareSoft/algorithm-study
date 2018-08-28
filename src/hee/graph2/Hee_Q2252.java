package hee.graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램
public class Hee_Q2252 {
    static int N;
    static int M;

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt(); // 학생의 수. 즉 정점의 수 (1≤N≤32,000)
        M = scanner.nextInt(); // 키를 비교한 횟수. 즉 간선의 수 (1≤M≤100,000)

        int[] cntOfLink = new int[N + 1]; // 간선의 수에 대한 배열

        // 가중치가 없는 그래프(인접 리스트 이용)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 단방향 연결 설정
        for (int i = 0; i < M; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.get(v1).add(v2);
            cntOfLink[v2]++; // 후행 정점에 대한 간선의 수 증가
        }

        // 위상 정렬 (A B: A가 B앞에 선다. A가 선행)
        topologicalSort(graph, cntOfLink);
    }

    /**
     * 위상 정렬
     */
    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cntOfLink) {
        Queue<Integer> queue = new LinkedList();

        // 초기: 선행 정점을 가지지 않는 정점을 큐에 삽입
        for (int i = 1; i < N + 1; i++) {
            if (cntOfLink[i] == 0) { // 해당 정점의 간선의 수가 0이면
                queue.add(i);
            }
        }

        // 정점의 수 만큼 반복
        for (int i = 0; i < N; i++) {
            int v = queue.remove(); // 1. 큐에서 정점 추출
            System.out.print(v + " "); // 정점 출력

            // 해당 정점과 연결된 모든 정점에 대해
            for (int nextV : graph.get(v)) {
                cntOfLink[nextV]--; // 간선의 수 감소

                if (cntOfLink[nextV] == 0) { // 해당 정점의 간선의 수가 0이면
                    queue.add(nextV); // 큐에 삽입
                }
            }
        }
    }
}
