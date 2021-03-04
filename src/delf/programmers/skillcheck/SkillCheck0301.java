package programmers.skillcheck;

public class SkillCheck0301 {
    public static int[] arr;
    public static int count = 0;

    public static void main(String[] args) {
        System.out.println(nQueen(8));
    }

    public static int nQueen(int n) {
        return dfs(new int[n * n], n, 0);
    }

    public static int dfs(int[] arr, int n, int depth) {
        if (depth == n) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[depth] = i;
            if (isPlacedQueens(arr, depth)) {
                cnt += dfs(arr, n, depth + 1);
            }
        }
        return cnt;
    }

    public static boolean isPlacedQueens(int[] arr, int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
