package programmers;

import java.util.Arrays;

public class Solution12913 {
	public int solution(int[][] land) {
		for (int j = 0; j < land.length; j++) {
			for (int i = 0; i < land[j].length; i++) {
				if (j == 0) continue;
				land[j][i] += getMaxExcept(land[j - 1], i);
			}
		}

		return Arrays.stream(land[land.length - 1]).max().getAsInt();
	}

	private int getMaxExcept(int[] arr, int index) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == index) {
				continue;
			}
			max = Math.max(max, arr[i]);
		}
		return max;
	}
}
