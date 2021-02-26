package dami.hackerrank.medium;

// https://www.hackerrank.com/challenges/special-palindrome-again/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
public class Special_StringAgain {
	// 재귀 풀이 : 스택오버플로우 발생
	private long count = 0L;

	public long substrCount(int n, String s) {
		for (int i = 0; i < n; i++) {
			recursive(s.substring(i, i + 1), s, i, i + 1);
		}
		return count;
	}

	private void recursive(String prefix, String s, int start, int end) {
		if (isSpecial(prefix)) {
			count++;
		}

		if (end == s.length()) {
			return;
		}

		recursive(s.substring(start, ++end), s, start, end);
	}

	private boolean isSpecial(String prefix) {
		char[] charArray = prefix.toCharArray();

		char result = charArray[0];
		int index = 0;
		for (int i = 1; i < charArray.length; i++) {
			if (result != charArray[i]) {
				index = i;
			}
		}

		return index == 0 || (charArray.length % 2 != 0 && index == charArray.length / 2);
	}

}

