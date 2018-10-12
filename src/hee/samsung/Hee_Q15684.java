package hee.samsung;

import java.util.Scanner;

/**
 * 문제 풀이 방법: 백트래킹 + DFS(범위 있는 DFS)
 */
public class Hee_Q15684 {
    static int n, m, h;
    static boolean[][] visited;
    static int res = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 세로선의 개수, y
        m = sc.nextInt(); // 가로선의 개수
        h = sc.nextInt(); // 세로선마다 가로선을 놓을 수 있는 위치의 개수, x
        visited = new boolean[h + 2][n + 1];

        // 이미 존재하는 가로선을 방문 표시.
        for (int i = 0; i < m; i++) {
            visited[sc.nextInt()][sc.nextInt()] = true;
        }

        // 선택할 수 있는 사다리의 수: 0 ~ 3개
        for (int i = 0; i <= 3; i++) {
            /* dfs1 이용 */
//			if (dfs1(1, 0, i)) // return true면 값이 변경된 것이므로 반복문 나간 후 결과 출력.
//				break;

            /* dfs2 이용 */
            dfs2(1, 0, i); // 가로선을 i개 추가하는 모든 경우의 수
            if (res != -1) // res 값이 바뀌었으면 반복문 나감
                break;
        }
        System.out.println(res);
    }

    public static boolean dfs1(int x, int depth, int cnt) {
        // [출력] 가로선을 추가로 cnt개 선택 시
        if (depth == cnt) {
            // 조건을 만족했으면 선택한 사다리의 수를 변경.
            if (rideLadder()) {
                res = cnt;
                return true; // 값이 변경됨.
            }
            return false; // 사다리를 cnt개 선택 시엔 만족하지 않음. cnt++ 후 재점검
        }

        // [재탐색] 다음 추가해야 할 가로선 찾기
        else {
            for (int i = x; i <= h; i++) {
                for (int j = 1; j <= n - 1; j++) {
                    // 해당 위치, 해당 위치의 왼쪽, 오른쪽이 기존 사다리에 포함되어 있지 않으면 추가 가능.
                    if (!visited[i][j] && !visited[i][j + 1] && !visited[i][j - 1]) {
                        visited[i][j] = true; // i, j 좌표인 가로선 선택
//						dfs(i, j, depth + 1, cnt); // 틀림!
                        if (dfs1(i, depth + 1, cnt)) { // 맞음!
                            return true; // 값이 변경되었으므로 종료.
                        }
                        visited[i][j] = false; // backtracking
                    }
                }
            }
            return false;
        }
    }

    public static void dfs2(int x, int depth, int cnt) {
        // [종료] res값이 바뀌었으면 조건을 만족하는 사다리 완성했으므로 종료
        if (res != -1)
            return;

        // [출력] 가로선을 추가로 cnt개 선택 시 res값 변경
        if (depth == cnt) {
            // 조건을 만족했으면 선택한 사다리의 수를 변경.
            if (rideLadder())
                res = cnt;
            return;
        }
        // [재탐색] 다음 추가해야 할 가로선 찾기
        else {
            for (int i = x; i <= h; i++) {
                for (int j = 1; j <= n - 1; j++) {
                    // [방법1]
                    // 현재 위치, 현재 위치의 왼쪽, 오른쪽이 기존 사다리에 포함되어 있지 않으면 추가 가능.
                    if (!visited[i][j] && !visited[i][j + 1] && !visited[i][j - 1]) {
                        visited[i][j] = true; // i, j 좌표인 가로선 선택
                        dfs2(i, depth + 1, cnt); // 다음 가로선 찾기
                        visited[i][j] = false; // backtracking
                    }

                    // [방법2]
//					// 현재 위치에 가로선이 있으면 오른쪽으로 2칸 뛰어넘음
//					if (visited[i][j]) {
//						j += 1;
//						continue;
//						// 현재 위치 오른쪽에 가로선이 있으면 오른쪽으로 3칸 뛰어넘음
//					} else if (visited[i][j + 1]) {
//						j += 2;
//						continue;
//					}
//					visited[i][j] = true; // i, j 좌표인 가로선 선택
//					dfs2(i, depth + 1, cnt); // 다음 가로선 찾기
//					visited[i][j] = false; // backtracking
                }
            }
        }
    }

    /* 모든 세로선에 대해 i번째 사다리 결과가 i인지 확인 */
    public static boolean rideLadder() {
        // 세로선(y)의 개수만큼 점검.
        for (int i = 1; i <= n; i++) {
            // [방법1]
            int y = i;
            for (int x = 1; x <= h; x++) {
                if (visited[x][y]) // 해당 위치 확인
                    y++; // 오른쪽 이동
                else if (visited[x][y - 1]) // 해당 위치 왼쪽 확인
                    y--; // 왼쪽 이동
            }

            // [방법2]
//			// 시작 위치
//			int x = 1; // [주의] 초기값
//			int y = i;
//			// 가로선(x)의 위치가 h + 1가 될 때까지 이동 수행.
//			while (x != h + 1) {
//				if (visited[x][y]) // 해당 위치 확인
//					y++; // 오른쪽 이동.
//				else if (visited[x][y - 1]) // 해당 위치 왼쪽 확인
//					y--; // 왼쪽 이동.
//				x++; // 아래쪽 이동.
//			}

            // 하나의 세로선(y)이라도 결과가 맞지 않으면 실패이므로 return false;
            if (y != i)
                return false;
        }
        return true;
    }
}
