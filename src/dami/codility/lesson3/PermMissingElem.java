package dami.codility.lesson3;

import java.util.Arrays;

// 문제 : https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/
// 결과 : https://app.codility.com/demo/results/trainingMTKP8M-WJN/
public class PermMissingElem {
	public int solution(int[] A) {
		Arrays.sort(A);

		for (int i = 0; i < A.length; i++) {
			if (i + 1 != A[i]) {
				return i + 1;
			}
		}

		return A.length + 1;
	}
}
