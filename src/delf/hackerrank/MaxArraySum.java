package hackerrank;

/**
 * Max Array Sum
 * https://www.hackerrank.com/challenges/max-array-sum/problem
 */
public class MaxArraySum {
    public static void main(String[] args) {
        System.out.println(maxSubsetSum(new int[]{3, 5, -7, 8, 10}));
    }

    static int maxSubsetSum(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        dp[2] = arr[1];

        int max = 0;
        for (int i = 3; i <= arr.length; i++) {
            int tmpMax = Math.max(dp[i - 2], dp[i - 3]);
            if (arr[i - 1] >= 0) {
                dp[i] = Math.max(arr[i - 1], tmpMax + arr[i - 1]);
            } else {
                dp[i] = tmpMax;
            }

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
