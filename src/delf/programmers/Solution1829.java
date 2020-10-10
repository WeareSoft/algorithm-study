package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1829 {

    private static final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int X = 0;
    private static final int Y = 1;

    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int area;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                area = bfs(i, j, picture, visited);
                numberOfArea++;
                if (maxSizeOfOneArea < area) {
                    maxSizeOfOneArea = area;
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int bfs(int x, int y, int[][] picture, boolean[][] visited) {
        int area = 0;
        visited[x][y] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int[] d : direction) {
                int nx = now.x + d[X];
                int ny = now.y + d[Y];

                if (0 <= nx && nx < picture.length && 0 <= ny && ny < picture[0].length) {
                    if (picture[nx][ny] != picture[x][y] || visited[nx][ny]) {
                        continue;
                    }
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    area++;
                }
            }
        }
        return area;
    }

    public class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution2(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int area = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0) {
                    continue;
                }
                area = dfs(i, j, picture[i][j], picture);
                if (maxSizeOfOneArea < area) {
                    maxSizeOfOneArea = area;
                }
                numberOfArea++;
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int dfs(int x, int y, int prevColor, int[][] picture) {
        if (picture[x][y] != prevColor) {
            return 0;
        }
        int count = 1;
        picture[x][y] = 0;
        for (int[] d : direction) {
            int nx = x + d[X];
            int ny = y + d[Y];

            if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length || picture[nx][ny] == 0) {
                continue;
            }
            if (picture[nx][ny] != prevColor) {
                continue;
            }

            count += dfs(nx, ny, prevColor, picture);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1829().solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }
}
