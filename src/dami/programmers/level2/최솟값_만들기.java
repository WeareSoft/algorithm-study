package dami.programmers.level2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/12941

public class 최솟값_만들기 {
	public int solution(int []A, int []B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i] * B[B.length - i - 1];
		}

		return sum;
	}

}
