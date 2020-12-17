package dami.programmers.level2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12913

// 처음에는 단순히 아래로 내려가면서 최댓값을 sum 하는 반복문으로 풀었지만
// 1 2 3 5
// 5 6 7 100
// 4 3 2 1
// 위와 같은 예시일 경우 오답

// 1. 두 번째 행부터 시작
// 2. 각 인덱스마다 본인 인덱스 제외한 윗 행 값과 더한 값 중 최댓값으로 갱신
// 3. 마지막 행까지 반복
// 4. 마지막 행의 최댓값 반환
public class 땅따먹기 {
	public int solution(int[][] land) {
		for (int i = 1; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				land[i][j] = findMaxSum(land[i-1], land[i][j], j);
			}
		}

		return Arrays.stream(land[land.length - 1])
				.max()
				.orElse(0);
	}

	private int findMaxSum(int[] prevLine, int currentValue, int exceptIndex) {
		int max = 0;
		for (int i = 0; i < prevLine.length; i++) {
			if (i == exceptIndex) {
				continue;
			}
			max = Math.max(max, currentValue + prevLine[i]);
		}
		return max;
	}
}
