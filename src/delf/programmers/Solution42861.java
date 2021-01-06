package programmers;

import java.util.Arrays;

/**
 * 섬 연결하기
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */
public class Solution42861 {
	private int[][] graph;
	private boolean[][] isVisit;

	public int solution(int n, int[][] costs) {
		graph = new int[n][n];
		for (int[] cost : costs) {
			setCost(cost[0], cost[1], cost[2]);
		}
		System.out.println(Arrays.deepToString(graph));

		isVisit = new boolean[n][n];

		return dfs(0, 0, 0);
	}

	private int dfs(int from, int to, int depth) {
		visit(from, to);

		if (depth == graph.length) {
			return graph[from][to];
		}

		int min = graph[from][to];
		for (int i = 0; i < graph.length; i++) {
			if (i == to) {
				continue;
			}
			if (isVisit[to][i] || graph[to][i] == 0) {
				continue;
			}

			int cost = dfs(to, i, depth + 1);
			min += Math.min(cost, min);
		}

		return min;
	}

	private void visit(int from, int to) {
		isVisit[from][to] = true;
		isVisit[to][from] = true;
	}

	private void setCost(int from, int to, int cost) {
		graph[from][to] = cost;
		graph[to][from] = cost;
	}

	public static void main(String[] args) {
		System.out.println(new Solution42861().solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
	}
}

