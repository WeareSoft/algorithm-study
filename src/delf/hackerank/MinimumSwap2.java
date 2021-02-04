package hackerank;

public class MinimumSwap2 {
    static int minimumSwaps(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != (i + 1)) {
                int idx = arr[i];
                int tmp = arr[idx - 1];
                arr[idx - 1] = arr[i];
                arr[i] = tmp;
                cnt++;
                i--;
            }
        }
        return cnt;
    }
}
