package dami.programmers.level3.review;

import java.util.LinkedList;
import java.util.Queue;

// https://programmers.co.kr/learn/courses/30/lessons/42898
public class 등굣길 {
	public int solution(int m, int n, int[][] puddles) {
		//return bfs(m, n, puddles);
		return dp(m, n, puddles);
	}

	// 시간 초과
	private int bfs(int m, int n, int[][] puddles) {
		boolean[][] water = new boolean[n][m];

		for (int[] puddle : puddles) {
			water[puddle[1] - 1][puddle[0] - 1] = true;
		}

		Queue<Point> points = new LinkedList<>();
		points.offer(new Point(1, 1));

		int result = 0;
		while (!points.isEmpty()) {
			Point point = points.poll();
			int x = point.x;
			int y = point.y;

			if (y < m && !water[x - 1][y]) {
				points.offer(new Point(x, y + 1));
			}

			if (x < n && !water[x][y - 1]) {
				points.offer(new Point(x + 1, y));
			}


			if (x == n && y == m) {
				result++;
			}
		}

		return result;
	}

	// 예전에 배웠던 최단 경로 구하는 방법 그대로 구현하면 되는 문제 .....
	// 오버플로우 주의
	private int dp(int m, int n, int[][] puddles) {
		int[][] path = new int[n][m];

		for (int[] puddle : puddles) {
			path[puddle[1] - 1][puddle[0] - 1] = -1;
		}

		path[0][0] = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (path[i][j] == -1) {
					path[i][j] = 0;
					continue;
				}

				if (i > 0) path[i][j] += path[i - 1][j] % 1_000_000_007;
				if (j > 0) path[i][j] += path[i][j - 1] % 1_000_000_007;
			}
		}

		return path[n - 1][m - 1] % 1_000_000_007;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
