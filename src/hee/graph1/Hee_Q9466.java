package hee.graph1;

import java.util.Scanner;

public class Hee_Q9466 {
    static Scanner scanner = new Scanner(System.in);
    static int[] selectPartner;
    static int[] visited; // 방문하지 않은 경우: 0, 방문했으면: 그동안 거쳐간 정점의 수를 저장
    static int[] startVertax; // 시작 정점을 저장

    public static void run() {
        int testCase = scanner.nextInt();

        while (testCase-- > 0) {
            int n = scanner.nextInt(); // 학생의 수 (2 ≤ n ≤ 100,000)
            selectPartner = new int[n + 1];
            visited = new int[n + 1];
            startVertax = new int[n + 1];

            for (int i=1; i<n+1; i++) {
                selectPartner[i] = scanner.nextInt();
                visited[i] = 0; // 0으로 초기화
                startVertax[i] = 0; // 0으로 초기화
            }

            // 모든 각 정점을 시작 정점으로 탐색하는 동안 자기 자신에게 돌아오면 그룹을 형성.
            // Ex) 1->3->3 (X). 2->1->3 (X). 3->3 (O). 4->6->7->4 (O)
            int cntSelectedStudent = 0;
            for (int i=1; i<n+1; i++) {
                // 방문하지 않았던 정점을 돌면서 사이클 확인
                if (visited[i] == 0) {
                    cntSelectedStudent += dfs(i, 1, i);
//                    System.out.println("그룹 형성 인원: " + cntSelectedStudent);
                }
            }
            System.out.println(n - cntSelectedStudent); // 전체 인원 - 그룹을 형성한 인원
        }
    }

    static int dfs(int v, int cnt, int startV) {
        while (true) {
            // 방문했던 정점이면 싸이클이다.
            if (visited[v] != 0) {
//                System.out.println(startV + "번 정점 탐색, 마지막 탐색 정점 " + v + "의 시작 정점은 " + startVertax[v]);
                // 시작 정점과 마지막 방문한 정점이 같으면 그룹 형성.
                if (startV == startVertax[v]){
                    int cntSelectedStudent = cnt - visited[v];
                    return cntSelectedStudent; // 그룹을 형성한 정점의 수를 반환 (방문했던 정점의 수를 반환)
                }
                // 다르면 그룹 형성 못함.
                else
                    return 0;
            }

            visited[v] = cnt; // 거쳐간 정점의 수를 저장
            startVertax[v] = startV; // 시작 정점을 저장

            v = selectPartner[v]; // 다음의 인접 정점으로 이동
            cnt++; // 거쳐간 정점의 수 증가
        }
    }
}