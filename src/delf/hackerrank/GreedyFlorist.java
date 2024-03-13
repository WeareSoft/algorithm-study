package hackerrank;

import java.util.Arrays;

/**
 * Greedy Florist
 * https://www.hackerrank.com/challenges/greedy-florist/problem
 */
public class GreedyFlorist {
    public static void main(String[] args) {
        System.out.println(getMinimumCost(3, new int[]{1, 3, 5, 7, 9}));
    }

    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int answer = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            answer += (((c.length - (i + 1)) / k) + 1) * c[i];
        }
        return answer;
    }
}
