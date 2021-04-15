package hackerrank;

/**
 * Recursion: Davis' Staircase
 * https://www.hackerrank.com/challenges/ctci-recursive-staircase/problem
 */
public class DavisStaircase {
    static int stepPerms(int n) {
        if (n < 3) {
            return n;
        }
        if (n == 3) {
            return 4;
        }

        int[] dp = new int[n];

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n - 1];
    }
}
