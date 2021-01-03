package programmers;

import java.util.Arrays;

/**
 * 이진 변환 반복하기
 * https://programmers.co.kr/learn/courses/30/lessons/70129
 */
public class Solution70129 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution70129().solution("110010101001")));
		System.out.println(Arrays.toString(new Solution70129().solution("01110")));
		System.out.println(Arrays.toString(new Solution70129().solution("1111111")));
	}
	// 문제의 로직 그대로...
	// 1. s에서 0 카운트
	// 2. 그 숫자를 이진수로 변환
	// 3. 그 수가 s
	// 4. s가 1이될 때 까지 반복
	public int[] solution(String s) {

		int loopCnt = 0; // 반복 횟수
		int leftOnes; // s에서 남은 1의 개수
		int totalZeroCnt = 0; // 총 0의 개수


		do {
			// 1.
			int zeroCnt = 0;
			leftOnes = s.length();
			for (char ch : s.toCharArray()) {
				zeroCnt += ((ch == '0') ? 1 : 0);
			}

			// 2~3.
			leftOnes -= zeroCnt;
			totalZeroCnt += zeroCnt;

			s = Integer.toBinaryString(leftOnes);

			loopCnt++;

		} while (leftOnes > 1); // 4.

		/*for (loopCnt = 0; leftOnes > 1; loopCnt++) {
			int zeroCnt = 0;
			for (char ch : s.toCharArray()) {
				if (ch == '0') {
					zeroCnt++;
				}
			}

			leftOnes -= zeroCnt;
			totalZeroCnt += zeroCnt;

			s = Integer.toBinaryString(leftOnes);
			leftOnes = s.length();
		}*/

		return new int[]{loopCnt, totalZeroCnt};
	}
}
