package programmers;

/**
 * 가장 큰 정사각형
 * https://programmers.co.kr/learn/courses/30/lessons/12905
 */
public class Solution12905 {
	public int solution(int[][] board) {
		int up, left, upLeft;
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					up = board[i - 1][j];
					left = board[i][j - 1];
					upLeft = board[i - 1][j - 1];

					int min = Math.min(Math.min(up, left), upLeft);
					board[i][j] = min + 1;
				}
			}
		}

		int ans = 0;
		for (int[] n : board) {
			for (int j = 0; j < board[0].length; j++) {
				if (n[j] > 0) {
					ans = Math.max(ans, n[j]);
				}
			}
		}
		return ans * ans;
	}
}
