package dami.hackerrank.medium;

// https://www.hackerrank.com/challenges/common-child/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

// LCS 문제
// 참고 1. https://ko.wikipedia.org/wiki/%EC%B5%9C%EC%9E%A5_%EA%B3%B5%ED%86%B5_%EB%B6%80%EB%B6%84_%EC%88%98%EC%97%B4
// 참고 2. https://twinw.tistory.com/126

// 값 구하는 규칙
// - String1[n], String2[k]가 같다면 : [n, k] == [n-1, k-1] + 1
// - String1[n], String2[k]가 다르면 : [n, k] == [n-1, k]와 [n, k-1] 중 큰 값
public class Common_Child {
	public int commonChild(String s1, String s2) {
		int[][] lcs = new int[s1.length() + 1][s2.length() + 1];

		char[] s1c = s1.toCharArray();
		char[] s2c = s2.toCharArray();
		for (int i = 1; i < lcs.length; i++) {
			for (int j = 1; j < lcs[0].length; j++) {
				if (s2c[i - 1] == s1c[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		return lcs[s1.length()][s2.length()];
	}
}
