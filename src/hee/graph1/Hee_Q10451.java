package hee.graph1;

import java.util.Scanner;

public class Hee_Q10451 {
    static Scanner scanner = new Scanner(System.in);
    static int[] permutation; // 순열
    static boolean[] visited; // 순열의 방문 여부(초기: 0)

    public static void run() {
        int testCase = scanner.nextInt();

        while (testCase-- > 0) {
            int N = scanner.nextInt(); // 순열의 크기 N (2 ≤ N ≤ 1,000)

            permutation = new int[N + 1]; // 순열
            visited = new boolean[N + 1]; // 순열의 방문 여부(초기: false)

            for (int i=1; i<N+1; i++) { // 연결 그래프 연결 설정
                permutation[i] = scanner.nextInt();
            }

            int cntCycle = 0;
            for (int i=1; i<N+1; i++) { // 방문하지 않았던 정점을 돌면서 사이클 확인
                if (visited[i] == false) {
                    dfs(i);
                    cntCycle++;
                }
            }

            System.out.println(cntCycle);
        }
    }

    static void dfs(int v) {
        if(visited[v]) return; // 방문했던 정점이면 사이클이다.

        visited[v] = true; // 방문 표시
        dfs(permutation[v]); // 다음의 인접 정점을 방문한다.
    }
}