package dami.programmers.level2.review;

// https://programmers.co.kr/learn/courses/30/lessons/17679
public class 프렌즈4블록 {
	private static final char VISITED = '-';

	public int solution(int m, int n, String[] board) {
		char[][] blocks = new char[m][n];
		for (int i = 0; i < m; i++) {
			blocks[i] = board[i].toCharArray();
		}

		int sum = 0;
		while (true) {
			int removed = find2x2Blocks(blocks, m, n);
			if (removed == 0) {
				break;
			}
			sum += removed;

			// 끌어내리기
			dropBlocks(blocks, m, n);
		}

		return sum;
	}

	private int find2x2Blocks(char[][] board, int m, int n) {
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (is2x2(board, i, j)) {
					visited[i][j] = true;
					visited[i][j + 1] = true;
					visited[i + 1][j] = true;
					visited[i + 1][j + 1] = true;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j]) {
					board[i][j] = '-';
					count++;
				}
			}
		}

		return count;
	}

	private boolean is2x2(char[][] board, int i, int j) {
		char current = board[i][j];
		return current != '-'
				&& current == board[i][j + 1]
				&& current == board[i + 1][j]
				&& current == board[i + 1][j + 1]
				&& i < board.length - 1
				&& j < board[i].length - 1;
	}

	// C C B D E
	// - - - D E
	// - - - B F
	// C C B B F
	// 가장 아랫줄부터 - 인 경우 찾아서 찾은 위치부터 위로 올라가면서 - 아닌 경우랑 swap
	private void dropBlocks(char[][] board, int m, int n) {
		for (int i = m - 1; i > 0; i--) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == VISITED) {
					for (int k = i - 1; k >= 0; k--) {
						if (board[k][j] != VISITED) {
							board[i][j] = board[k][j];
							board[k][j] = VISITED;
							break;
						}
					}
				}
			}
		}
	}
}
