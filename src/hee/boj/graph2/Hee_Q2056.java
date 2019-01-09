package hee.boj.graph2;

import java.util.*;

public class Hee_Q2056 {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 수행해야 할 작업의 개수 (3 ≤ N ≤ 10000)

        ArrayList<ArrayList<Integer>> graph = new ArrayList(); // 연결 그래프
        int[] times = new int[N + 1]; // 작업에 걸리는 시간에 대한 배열
        int[] numOfLinks = new int[N + 1]; // 간선의 수에 대한 배열

        // 그래프 초기화
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 1; i < N + 1; i++) {
            times[i] = scanner.nextInt(); // 해당 작업이 걸리는 시간

            int numOfLink = scanner.nextInt(); // 선행 관계에 있는 작업의 수(0 ≤ 개수 ≤ 100)
            while (numOfLink-- > 0) {
                numOfLinks[i]++; // 간선의 수 증가

                // 단방향 연결 설정
                int linkNode = scanner.nextInt(); // 선행 노드
                graph.get(linkNode).add(i);
            }
        }

        /* 위상 정렬 */
        int[] sumOfTime = new int[N + 1]; // 작업 시간의 순차적인 합을 위한 배열
        Queue<Integer> queue = new LinkedList<>();
        // 초기: 선행 관계가 없는 노드 중 작업 시간이 적은 순서대로 큐에 삽입
        for (int i = 1; i < N + 1; i++) {
            if (numOfLinks[i] == 0) {
                queue.add(i);
                sumOfTime[i] = times[i]; // 초기화
            }
        }

        // 3. 정점의 수만큼 반복
        for (int i = 0; i < N; i++) {
            int v = queue.poll(); // 1. 큐에서 정점 추출.

            // 2. 해당 정점과 연결된 모든 정점에 대해
            for (int nextV : graph.get(v)) {
                numOfLinks[nextV]--; // 2-1. 해당 정점의 간선의 수 감소

                // 여러 선행 정점에 대해 작업 시간이 과 현재 정점의 작업 시간의 합이 적은 작업 시간을 구한다.
                if (sumOfTime[nextV] < sumOfTime[v] + times[nextV]) {
                    sumOfTime[nextV] = sumOfTime[v] + times[nextV];
                }

                // 2-2. 선행 관계가 없는 노드 중 작업 시간이 적은 순서대로 큐에 삽입
                if (numOfLinks[nextV] == 0) {
                    queue.add(nextV);
                }
            }
        }

        Arrays.sort(sumOfTime); // 오름차순 정렬
        System.out.println(sumOfTime[sumOfTime.length - 1]); // 최댓값: 최종 걸린 작업 시간
    }
}
