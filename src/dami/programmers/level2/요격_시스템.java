package dami.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class 요격_시스템 {

	public int solution(int[][] targets) {
		Arrays.sort(targets, Comparator.comparing(target -> target[1]));

		int result = 0;
		double last = -1.0;
		for (int[] target : targets) {
			if (target[0] < last) {
				continue;
			}

			result++;
			last = target[1] - 0.1;
		}
		return result;
	}
}
