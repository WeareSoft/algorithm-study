package dami.hackerrank.medium.review;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// https://www.hackerrank.com/challenges/richie-rich/problem
public class Highest_Value_Palindrome {
	private static final String pattern = Pattern.compile("[0-9]").pattern();
	private static final char MAX = '9';

	public String highestValuePalindrome(String s, int n, int k) {
		if (n <= k) {
			return s.replaceAll(pattern, "9");
		}

		char[] chars = s.toCharArray();
		List<Integer> diff = differentIndexes(chars);

		if (k < diff.size()) {
			return "-1";
		}

		// 양쪽 다른 숫자 치환
		int diffSize = diff.size();
		for (int i = 0; i < diff.size() && k > 0; i++) {
			char m;
			if (k > diffSize) {
				m = MAX; // 변경 횟수 충분하면 양쪽 최댓값 9로 치환
			} else {
				m = (char) Math.max(chars[diff.get(i)], chars[chars.length - diff.get(i) - 1]);
			}

			if (chars[diff.get(i)] != m) {
				chars[diff.get(i)] = m;
				k--;
			}

			if (chars[chars.length - diff.get(i) - 1] != m) {
				chars[chars.length - diff.get(i) - 1] = m;
				k--;
			}

			diffSize--;
		}

		// 양쪽 같은 숫자 최댓값 9로 치환
		for (int i = 0; i < n / 2 && k > 0; i++) {
			if (k == 1 && n % 2 != 0) {
				chars[chars.length / 2] = MAX;
				k--;
			} else {
				if (chars[i] != MAX) {
					chars[i] = MAX;
					k--;
				}

				if (chars[chars.length - i - 1] != MAX) {
					chars[chars.length - i - 1] = MAX;
					k--;
				}
			}
		}

		return new String(chars);
	}

	private List<Integer> differentIndexes(char[] chars) {
		List<Integer> diff = new ArrayList<>();
		for (int i = 0; i < chars.length / 2; i++) {
			if (chars[i] != chars[chars.length - i - 1]) {
				diff.add(i);
			}
		}
		return diff;
	}
}
