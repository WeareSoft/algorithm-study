package programmers;

import java.util.Arrays;

/**
 * 등굣길
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 **/
public class Solution42898 {
    public static void main(String[] args) {
//        System.out.println(new Solution42898().solution(4, 3, new int[][]{{2, 2}}));
        System.out.println(new Solution42898().solution(100, 100, new int[][]{{0, 2}, {1, 2}, {1, 3}, {1, 4}}));
    }

    public int solution(int m, int n, int[][] puddles) {
        int[][] puddleMap = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            puddleMap[puddle[1]][puddle[0]] = -1;
        }
        dp[1][1] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if ((i == 1 && j == 1) || puddleMap[i][j] == -1) {
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }
        return dp[n][m];
    }
}
