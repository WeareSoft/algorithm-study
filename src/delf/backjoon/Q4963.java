package backjoon;

import java.util.Scanner;

public class Q4963 {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Q4963 q4963 = new Q4963();
		int n, m;
		do {

			n = scanner.nextInt();
			m = scanner.nextInt();
			int[][] map = new int[m][n]; // 4 5
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = scanner.nextInt();
				}
			}

			if (n == 0 && m == 0) {
				break;
			}

			System.out.println(q4963.solution(n, m, map));

		} while (true);
	}

	private final static int[][] DIRECTION = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

	public int solution(int n, int m, int[][] map) {
		int cnt = 0;
		boolean[][] isVisit = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (isVisit[i][j] || map[i][j] == 0) {
					continue;
				}
				cnt += dfs(i, j, map, isVisit);
			}
		}
		return cnt;
	}
	private int dfs(int n, int m, int[][] map, boolean[][] isVisit) {
		isVisit[m][n] = true;

		for (int[] dir : DIRECTION) {
			int nextN = n + dir[1];
			int nextM = m + dir[0];

			if (nextN < 0 || nextM < 0 || nextN >= map[0].length || nextM >= map.length) {
				continue;
			}

			if (isVisit[nextM][nextN] || map[nextM][nextN] == 0) {
				continue;
			}

			dfs(nextN, nextM, map, isVisit);
		}

		return 1;
	}
}
