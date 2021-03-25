package programmers;

/**
 * 순위
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */
public class Solution49191 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int max = Integer.MAX_VALUE;
        int[][] m = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                m[i][j] = max;
            }
        }

        for (int[] e : results) {
            m[e[0]][e[1]] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (m[i][j] > m[i][k] + m[k][j]) {
                        m[i][j] = m[i][k] + m[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                if (m[i][j] == max && m[j][i] == max) {
                    flag = false;
                    break;
                }
            }

            answer += (flag ? 1 : 0);
        }
        return answer;
    }

}
