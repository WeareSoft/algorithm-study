package dami.programmers.level2;

import java.util.Stack;

public class 카카오프렌즈_컬러링북 {

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}

		Stack<Integer> pointX = new Stack<>();
		Stack<Integer> pointY = new Stack<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int sizeOfOneArea = 0;
				if ((long) picture[i][j] == 0 || visited[i][j]) {
					continue;
				}

				pointX.push(j);
				pointY.push(i);
				visited[i][j] = true;
				numberOfArea++;
				sizeOfOneArea++;

				while (!pointX.isEmpty()) {
					int x = pointX.pop();
					int y = pointY.pop();

					// 위 이동
					if (y > 0 && (long) picture[i][j] == (long) picture[y-1][x] && !visited[y-1][x]) {
						pointX.push(x);
						pointY.push(y-1);
						visited[y-1][x] = true;
						sizeOfOneArea++;
					}
					// 좌측 이동
					if (x > 0 && (long) picture[i][j] == (long) picture[y][x-1] && !visited[y][x-1]) {
						pointX.push(x-1);
						pointY.push(y);
						visited[y][x-1] = true;
						sizeOfOneArea++;
					}
					// 우측 이동
					if (x < n-1 && (long) picture[i][j] == (long) picture[y][x+1] && !visited[y][x+1]) {
						pointX.push(x+1);
						pointY.push(y);
						visited[y][x+1] = true;
						sizeOfOneArea++;
					}
					// 아래 이동
					if (y < m-1 && (long) picture[i][j] == (long) picture[y+1][x] && !visited[y+1][x]) {
						pointX.push(x);
						pointY.push(y+1);
						visited[y+1][x] = true;
						sizeOfOneArea++;
					}
				}
				maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
			}
		}

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

}
