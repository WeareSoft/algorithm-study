package hee.graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// N개의 각 건물이 완성되기까지 걸리는 최소 시간을 출력
public class Hee_Q1516 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 건물의 종류 수 N(1 ≤ N ≤ 500)
        int[] times = new int[N + 1]; // 건물을 짓는데 걸리는 시간(T ≤ 100,000)

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] cntLink = new int[N + 1]; // 간선의 수

        // 그래프 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i < N + 1; i++) {
            times[i] = scanner.nextInt();

            while (true) {
                int preV = scanner.nextInt(); // 선행 노드
                if (preV == -1) break;

                // 단방향 연결 설정
                graph.get(preV).add(i);
                cntLink[i]++; // 간선의 수 증가
            }
        }

        /* 위상 정렬 */
        int[] sumOfTime = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        // 초기: 선행 노드가 없는 노드를 큐에 삽입
        for (int i = 1; i < N + 1; i++) {
            if (cntLink[i] == 0) {
                queue.add(i);
                sumOfTime[i] = times[i]; // 완성하는 데걸리는 시간 초기화
            }
        }

        // 노드의 수 만큼 반복
        for (int i = 0; i < N; i++) {
            // 큐에서 노드 추출
            int v = queue.remove();

            // 해당 노드와 연결된 모든 후행 노드에 대해
            for (int nextV : graph.get(v)) {
                // 후행 노드의 간선의 수 감소
                cntLink[nextV]--;

                // 후행 노드까지 완성하는 데 걸리는 시간
                // (선행 노드까지 걸린 시간 중 가장 오래 걸린 값으로 할당)
                if (sumOfTime[nextV] < sumOfTime[v] + times[nextV]) {
                    sumOfTime[nextV] = sumOfTime[v] + times[nextV];
                }

                // 선행 노드가 없는 노드를 큐에 삽입
                if (cntLink[nextV] == 0) {
                    queue.add(nextV);
                }
            }
        }

        // 각 건물이 걸린 시간을 순차적으로 출력
        for (int i=1; i<N+1; i++) {
            System.out.println(sumOfTime[i]);
        }

    }
}