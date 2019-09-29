package hee.leetcode;

public class MaxIncreaseKeepingSkyline_807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ROW_LENGTH = grid.length;
        int COL_LENGTH = grid[0].length;

        int[] topOrBottom = new int[COL_LENGTH];
        int[] leftOrRight = new int[ROW_LENGTH];

        for (int i=0; i<ROW_LENGTH; i++) {
            for (int j=0; j<COL_LENGTH; j++) {
                // Math.max 이용
                // [i][j] 00 01 02 03 leftOrRight
                if (grid[i][j] > leftOrRight[i]) {
                    leftOrRight[i] = grid[i][j];
                }
                // [j][i] 00 10 20 30 topOrBottom
                if (grid[j][i] > topOrBottom[i]) {
                    topOrBottom[i] = grid[j][i];
                }
            }
        }

        int result = 0;
        for (int i=0; i<ROW_LENGTH; i++) {
            for (int j=0; j<COL_LENGTH; j++) {
                // Math.min 이용
                if (topOrBottom[j] < leftOrRight[i]) {
                    result += topOrBottom[j] - grid[i][j];
                    continue;
                }
                result += leftOrRight[i] - grid[i][j];
            }
        }
        System.out.println(result);
        return result;
    }
}
