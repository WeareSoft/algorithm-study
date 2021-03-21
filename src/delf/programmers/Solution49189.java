package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution49189 {
    public static void main(String[] args) {
        System.out.println(new Solution49189().solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int[] i : edge) {
            map[i[0]][i[1]] = true;
            map[i[1]][i[0]] = true;
        }

        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(1);

        int max = 0;
        while (!nodes.isEmpty()) {
            int i = nodes.poll();

            for (int j = 2; j <= n; j++) {
                if (dist[j] == 0 && map[i][j]) {
                    dist[j] = dist[i] + 1;
                    nodes.add(j);
                    max = Math.max(max, dist[j]);
                }
            }
        }

        int count = 0;
        for (int d : dist) {
            if (max == d)
                count++;
        }

        return count;
    }
}
