package dami.programmers.level2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12905
public class 가장_큰_정사각형_찾기 {
	public int solution(int [][]board) {
		int max = Arrays.stream(board[0]).anyMatch(value -> value == 1) ? 1 : 0;
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j] == 0) {
					continue;
				}
				board[i][j] += minimumOfThree(board[i-1][j-1], board[i][j-1], board[i-1][j]);
				max = Math.max(max, board[i][j]);
			}
		}
		return max * max;
	}

	private int minimumOfThree(int one, int two, int three) {
		return Math.min(one, Math.min(two, three));
	}
}
