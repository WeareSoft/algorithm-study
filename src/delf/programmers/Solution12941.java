package programmers;

import java.util.Arrays;

/**
 * 최솟값 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12941
 */
public class Solution12941 {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) {
			answer += (A[i] * B[B.length - (i + 1)]);
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(new Solution12941().solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));

	}
}
