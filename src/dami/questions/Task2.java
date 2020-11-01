package dami.questions;

import java.util.Arrays;

// 완
// 백준 '빗물' 문제와 유사
public class Task2 {
	public void solution(int day, int width, int[][] blocks) { // 작업일, 너비, 공사 기간 동안 쌓을 벽돌 개수
		int[] workResult = new int[width];
		int cement = 0;
		for (int i = 0; i < day; i++) {
			// 다음날 벽돌 추가
			for (int j = 0; j < width; j++) {
				workResult[j] += blocks[i][j];
			}

			int left = 0, right = width - 1;
			while (canWork(workResult)) {
				// 시멘트 작업 가능 범위 확인
				while (workResult[left] <= 0) {
					left++;
				}
				while (workResult[right] <= 0) {
					right--;
				}
				int min = Math.min(workResult[left], workResult[right]);

				for (int j = 0; j < width; j++) {
					// 시멘트 작업 가능 범위 내에만 시멘트 추가
					if (j >= left && j <= right && workResult[j] < min) {
						cement += min - workResult[j];
						workResult[j] += min - workResult[j];
					}
					workResult[j] -= min;
				}
			}
		}

		System.out.println(cement);
	}

	// 시멘트가 넘치지 않도록 양쪽 사이드 벽이 될 수 있는지 판단
	private boolean canWork(int[] blocks) {
		return Arrays.stream(blocks)
				.filter(block -> block > 0)
				.count() >= 2;
	}
}
