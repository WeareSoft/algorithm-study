package dami.leetcode.medium.review;

// https://leetcode.com/problems/longest-palindromic-substring/
// 문자열 길이만큼 반복
// 현재 위치 기준으로 왼쪽 오른쪽으로 한자리씩 뻗어나가며 두 char가 같은지 비교해주는 방법
public class Longest_Palindromic_Substring_5 {
	public String longestPalindrome(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			String odd = compareLeftRight(s, i, i);
			String even = compareLeftRight(s, i, i + 1);
			if (odd.length() > result.length()) {
				result = odd;
			}
			if (even.length() > result.length()) {
				result = even;
			}
		}

		return result;
	}

	public String compareLeftRight(String s, int i, int j) {
		for (; i <= 0 && j < s.length(); i--, j++) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
		}
		return s.substring(i + 1, j);
	}


	// 문자열 길이만큼 맨 앞 인덱스와 같은 마지막 인덱스 찾아서 안으로 들어가며 비교해주는 방법
	// aaca / acaa 인 경우 등 실패
	public String longestPalindrome_실패(String s) {
		String result = String.valueOf(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {

			char first = s.charAt(i);
			int lastIndex = s.lastIndexOf(first);

			if (lastIndex + 1 - i <= result.length()) {
				continue;
			}

			if (lastIndex == i || lastIndex == -1) {
				continue;
			}

			if (isPalindrome(s, i, lastIndex)) {
				result = s.substring(i, lastIndex + 1);
			}
		}

		return result;
	}

	private boolean isPalindrome(String s, int currentIndex, int lastIndex) {
		for (int j = currentIndex + 1; j < (lastIndex - currentIndex + 1) / 2 + currentIndex; j++) {
			if (s.charAt(j) != s.charAt(lastIndex - j + currentIndex)) {
				return false;
			}
		}
		return true;
	}
}
