package dami.leetcode.easy;

public class Palindrome_Number_9 {
	private static final int DIVIDING_NUMBER = 10;

	// TEST CASE : 121, -121, 1001, 10, 1000000001
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		return x == reverse(x);
	}

	private int reverse(int x) {
		int quotient = x;
		int remainder = 0;
		long reversedX = 0;
		while (quotient >= 1) {
			remainder = quotient % DIVIDING_NUMBER;
			quotient = quotient / DIVIDING_NUMBER;

			reversedX = (reversedX + remainder) * DIVIDING_NUMBER;
		}

		return (int) (reversedX / DIVIDING_NUMBER);
	}
}
