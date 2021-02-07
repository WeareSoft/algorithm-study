package hackerank;

/* Minimum Swaps 2
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 * */
public class MinimumSwap2 {
    static int minimumSwaps(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i];
            if (idx == (i + 1)) {
                continue;
            }
            arr[i] = arr[idx - 1];
            arr[idx - 1] = idx;
            cnt++;
            i--;
        }
        return cnt;
    }
}