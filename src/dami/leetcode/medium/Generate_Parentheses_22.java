package dami.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
public class Generate_Parentheses_22 {
	private static final String OPEN = "(";
	private static final String CLOSE = ")";

	private final List<String> result = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		StringBuilder sb = new StringBuilder();
		recursive(sb, 0, 0, n);
		return result;
	}

	private void recursive(StringBuilder prefix, int open, int close, int n) {
		if (n * 2 == prefix.length()) {
			result.add(prefix.toString());
			return;
		}

		if (open < n) {
			prefix.append(OPEN);
			recursive(prefix, open + 1, close, n);
			prefix.deleteCharAt(prefix.length() - 1);
		}

		if (close < open) {
			prefix.append(CLOSE);
			recursive(prefix, open, close + 1, n);
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
}
