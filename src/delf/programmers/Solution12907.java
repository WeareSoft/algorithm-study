package programmers;

import java.util.Arrays;

/**
 * 거스름
 * https://programmers.co.kr/learn/courses/30/lessons/12907
 */
public class Solution12907 {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		System.out.println(new Solution12907().solution(10, new int[]{2, 3, 5}));
	}

	public int solution(int n, int[] money) {
		int[][] dp = new int[money.length + 1][n + 1];

		Arrays.sort(money);

		dp[0][0] = 1;

		for (int r = 1; r < dp.length; ++r) {
			for (int c = 0; c < dp[0].length; ++c) {
				if (c < money[r - 1]) {
					dp[r][c] = dp[r - 1][c] % MOD;
				} else if (c == money[r - 1]) {
					dp[r][c] = dp[r - 1][c] + 1 % MOD;
				} else {
					dp[r][c] = dp[r - 1][c] + dp[r][c - money[r - 1]] % MOD;
				}
			}
		}

		return dp[money.length][n];
	}
}
