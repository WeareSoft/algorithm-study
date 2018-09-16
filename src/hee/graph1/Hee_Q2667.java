package hee.graph1;

import java.util.*;

// 단지 번호 붙이기
public class Hee_Q2667 {
    // 상:(0, -1) 하:(0, 1) 좌:(-1, 0) 우:(1, 0)에 대한 벡터
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int N; // 정사각형 지도의 크기 (5≤N≤25)
    static int[][] house; // 해당 좌표에 대한 집의 존재 유무
    static int[][] visited; // 해당 좌표를 방문했는지에 대한 여부 (방문한 경우, 단지번호를 할당)
    static List<Integer> cntOfSameComplex = new ArrayList<>(); // 단지에 속한 집의 수

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        N = Integer.parseInt(scanner.nextLine());
        house = new int[N][N];
        visited = new int[N][N];

        // 집의 유무를 배열에 저장하는 방법 1
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < N; j++) {
                house[i][j] = Integer.parseInt(Character.toString(s.charAt(j)));
                visited[i][j] = 0; // 방문하지 않은 좌표: 0
            }
        }
//        // 집의 유무를 배열에 저장하는 방법 2
//        for (int i = 0; i < N; i++) {
//            String s = scanner.next();
//            char[] chars = s.toCharArray();
//            for (int j = 0; j < N; j++) {
//                house[i][j] = chars[j] - '0';
//                visited[i][j] = 0; // 방문하지 않은 좌표: 0
//            }
//        }

        int numOfComplex = 0; // 단지 번호
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 해당 좌표에 집이 있고, 방문한 적이 없으면 탐색 수행
                if ((house[i][j] == 1) && (visited[i][j] == 0)) {
                    bfs(i, j, ++numOfComplex); /* 너비 우선 탐색 */
                }
            }
        }

        System.out.println(numOfComplex); // 단지의 수 출력

        Collections.sort(cntOfSameComplex);
        for (int cnt : cntOfSameComplex) {
            System.out.println(cnt); // 단지에 속한 집의 수 출력
        }

    }

    /* 너비 우선 탐색 */
    static void bfs(int x, int y, int numOfComplex) {
        Queue<Pair> queue = new LinkedList<>(); // 큐에 좌표를 할당

        int cnt = 1; // 단지에 속한 집의 수 카운트
        queue.add(new Pair(x, y)); // 시작 좌표를 큐에 삽입
        visited[x][y] = numOfComplex; // 해당 좌표 방문: 방문한 좌표에 단지 번호를 할당

        while (!queue.isEmpty()) {
            x = queue.peek().getX();
            y = queue.peek().getY();
            queue.poll();

            // 탐색 좌표 기준으로 상하좌우 좌표를 확인
            for (int i = 0; i < 4; i++) {
                // 다음 좌표
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 지도 범위 안에 있는 좌표에 대해서만
                if ((nextX >= 0) && (nextX < N) && (nextY >= 0) && (nextY < N)) {
                    // 다음 좌표에 집이 있고, 방문한 적이 없으면 같은 단지 번호를 할당
                    if ((house[nextX][nextY] == 1) && (visited[nextX][nextY] == 0)) {
                        queue.add(new Pair(nextX, nextY));
                        visited[nextX][nextY] = numOfComplex;
                        cnt++; // 단지에 속한 집의 수를 증가
                    }
                }
            }
        }
        cntOfSameComplex.add(cnt);
    }

    // 좌표를 저장하기 위한 Pair 클래스
    public static class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}