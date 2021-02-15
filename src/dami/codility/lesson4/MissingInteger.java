package dami.codility.lesson4;

import java.util.Arrays;

// ⭐️
// 문제 : https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
// 결과 : https://app.codility.com/demo/results/trainingGWWV7R-UP7/
public class MissingInteger {
	public int solution(int[] A) {
		Arrays.sort(A);

		int result = 1;
		for (int num : A) {
			if (num < result) {
				continue;
			}

			if (result < num) {
				return result;
			}
			result++;
		}

		return result;
	}
}
