package etc.devmatching2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));
        System.out.println(Arrays.toString(new Solution2().solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}})));
        System.out.println(Arrays.toString(new Solution2().solution(100, 97, new int[][]{{1, 1, 100, 97}})));
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows + 1][columns + 1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = (i - 1) * (map[i].length - 1) + j;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int[] query : queries) {
            map = rotate(map, query, answer);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int[][] rotate(int[][] map, int[] query, List<Integer> answer) {
        int[][] arr = new int[map.length][map[0].length];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(map[i], 0, arr[i], 0, arr[i].length);
        }

        int startRow = query[0];
        int endRow = query[2];
        int startCol = query[1];
        int endCol = query[3];

        int min = Integer.MAX_VALUE;
        for (int r = startRow; r <= endRow; r++) {
            for (int c = startCol; c <= endCol; c++) {
                if (r != startRow && r != endRow && c != startCol && c != endCol) {
                    continue;
                }
                if (r == startRow && c != endCol) {
                    arr[r][c + 1] = map[r][c];
                } else if (r != endRow && c == endCol) {
                    arr[r + 1][c] = map[r][c];
                } else if (r == endRow && c != startCol) {
                    arr[r][c - 1] = map[r][c];
                } else if (r != startRow && c == startCol) {
                    arr[r - 1][c] = map[r][c];
                }

                min = Math.min(min, map[r][c]);
            }
        }
        answer.add(min);
        return arr;
    }
}
