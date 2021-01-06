package dami.leetcode.medium;

// https://leetcode.com/problems/counting-bits/
public class Counting_Bits_338 {
	public int[] countBits(int num) {
		return solution2(num);
	}

	// 방법 1. O(n^2)
	private int[] solution1(int num) {
		int[] result = new int[num + 1];
		for (int i = num; i >= 0; i--) {
			int sum = 0;
			int n = i;
			while (n >= 1) {
				sum += n % 2;
				n = n / 2;
			}
			result[i] = sum;
		}
		return result;
	}

	// 방법 2. 비트연산자 사용 O(n)
	private int[] solution2(int num) {
		int[] result = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			// " f[i >> 1] " is equivalent to " f[i / 2] "
			//  => 짝수는 비트연산으로 한 칸 밀어도(2로 나누면) 무조건 1이 한 개
			// " i & 1 " is equivalent to " i % 2 "
			//  => 홀수는 비트연산으로 한 칸 밀면 1 한 개가 없어짐.
			//      예를 들어 5의 2진수는 101이되고 " 101 & 1 " 하면 비트연산으로 없어진 1 추가 가능
			result[i] = result[i >> 1] + (i & 1);
		}
		return result;
	}
}
