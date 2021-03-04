package programmers;

/**
 * 정수 삼각형
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Solution43105 {

	public static void main(String[] args) {
		System.out.println(new Solution43105().solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
	}

	public int solution(int[][] triangle) {
		int answer;
		int n = triangle.length;
		int[][] dp = new int[n][n];

		System.arraycopy(triangle[n - 1], 0, dp[n - 1], 0, n);

		for (int i = n - 2; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
			}
		}
		answer = dp[0][0];

		return answer;
	}
}
