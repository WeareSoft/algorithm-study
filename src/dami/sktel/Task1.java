package dami.sktel;

/**
 *
 * Write a function:
 *      class Solution { public int solution(int A, int B); }
 *
 * that, given two non-negative integers A and B,
 * returns the number of bits set to 1 in the binary representation of the number A * B.
 *
 * For example, given A=3 and B=7 the function should return 3,
 * because the binary representation of A * B = 3 * 7 = 21 is 10101 and it contains three bits set to 1.
 *
 * Assume that:
 *      A and B are integers within the range [0..100,000,000].
 *
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 *
 */

public class Task1 {
	public int solution(int A, int B) {
		int multiply = A * B;

		int count = 0;
		int q = multiply;
		int o = 0;
		while(q != 1) {
			o = q%2;
			q = q/2;

			if(o == 1) count++;
		}
		if(q == 1) count++;
		return count;
	}
}
