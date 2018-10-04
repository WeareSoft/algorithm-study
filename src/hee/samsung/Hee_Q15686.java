package hee.samsung;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 문제풀이방법
 * <p>
 * 1. 치킨집(chicken) 중 M개 만큼 조합으로 만든다.
 * 2-1. 치킨집 조합의 경우의 수마다 집(home)의 치킨 거리를 구한다.
 * 2-2. 치킨집 조합의 경우의 수마다의 도시의 치킨 거리를 구한다.
 * 3. 도시의 치킨 거리가 가장 짧은 경우를 구한다.
 * <p>
 * 백트래킹 기본 구성
 * 1. DFS(깊이우선)으로 다음 노드 탐색
 * 2. 방문 노드가 유망한지 점검(DFS와 다른점)
 * 2-1. NO: 부모 노드로 거술러 올라가 재탐색
 * 2-2. YES: 방문 노드가 단말 노드인지 확인(조합의 경우는 조합할 노드의 개수)
 * 3-1. NO: 자식 노드를 재탐색
 * 3-2. YES: 해를 출력
 */
public class Hee_Q15686 {
    static int N;
    static int M;
    static ArrayList<Point> home;
    static ArrayList<Point> chicken;
    static ArrayList<Point> selectedChicken; // 치킨집의 조합
    static boolean[] visited; // 치킨집의 조합에서의 방문 여부
    static int minCityChickenDistance = Integer.MAX_VALUE;

    public static void run() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // NXN 도시의 크기
        M = sc.nextInt(); // 가장 수익을 많이 낼 수 있는 치킨집의 개수

        int[][] city = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int num = sc.nextInt();
                city[i][j] = num; // 도시의 정보

                if (num == 1) { // 집
                    home.add(new Point(i, j));
                } else if (num == 2) { // 치킨집
                    chicken.add(new Point(i, j));
                }
            }
        }

        selectedChicken = new ArrayList<>(); // 조합으로 고른 치킨집들
        visited = new boolean[chicken.size()]; // 조합으로 고른 치킨집의 방문 여부

        chickenSelect(0, 0); // start: root index, depth: 조합번째
        System.out.println(minCityChickenDistance);
    }

    /* 치킨집 선택: DFS 이용, // 치킨집 선택 (M개 만큼 조합) */
    public static void chickenSelect(int start, int depth) {
        // M개의 조합 완성 시, [방문 노드가 단말 노드면 값 출력]
        // M개의 치킨집이 선택되었다면 거리값을 구한다.
        if (depth == M) {
            // 치킨집을 M개 고른 모든 조합의 경우를 기준으로 도시의 치킨 거리를 구한다.
            int cityChickenDistance = 0;

            // 모든 집에 대해 순차적으로 반복
            for (int i = 0; i < home.size(); i++) {
                Point selectedHome = home.get(i);
                int minChickenDistance = Integer.MAX_VALUE; // 최소 치킨 거리

                // selectedHome에서 M개의 치킨집(조합한 치킨집) 중에서 최소 치킨 거리를 구한다.
                for (int j = 0; j < M; j++) {
                    int chickenDistance = getDistance(selectedHome, selectedChicken.get(j));
                    minChickenDistance = Math.min(chickenDistance, minChickenDistance);
                }
                // 모든 home의 가장 짧은 치킨 거리의 합(즉, 도시의 치킨 거리)을 구한다.
                cityChickenDistance += minChickenDistance;
            }
            // 모든 치킨집 조합의 경우에 대해 구한 도시의 치킨 거리 중 최소값을 저장한다.
            minCityChickenDistance = Math.min(cityChickenDistance, minCityChickenDistance);
        }

        // M개의 조합 미완성 시, [방문 노드가 단말 노드가 아니면 다음 자식 노드 방문]
        // M개의 치킨집이 선택되지 않았다면 다음 노드를 조합번째로 선택.
        for (int i = start; i < chicken.size(); i++) {
            visited[i] = true; // 조합에 포함된 치킨집 방문 표시
            selectedChicken.add(chicken.get(i)); // 해당 치킨집을 조합으로 선택

            // DFS로 재귀.
            chickenSelect(i + 1, depth + 1); // start: root index, depth: 조합번째

            // 새로운 조합을 구성하기 위해 자식 노드를 조합에서 제외하고 [부모 노드로 거슬러 올라가 재탐색]
            selectedChicken.remove(selectedChicken.size() - 1);
            visited[i] = false; // 방문 초기화
        }
    }

    /* 치킨 거리 계산 */
    public static int getDistance(Point home, Point chicken) {
        int x = (int) Math.abs(home.getX() - chicken.getX());
        int y = (int) Math.abs(home.getY() - chicken.getY());

        return x + y;
    }

}

// references: https://gist.github.com/BrendenHJH/d7a931f1aa6502561b0e4a4f1326cc4e