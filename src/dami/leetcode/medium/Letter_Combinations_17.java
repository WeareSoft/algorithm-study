package dami.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// 3가지 방법으로 구현
public class Letter_Combinations_17 {
	private static final String[] DIGIT_TO_LETTERS = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<>();
		}

		// bfsCombination1과 2는 같은 시간복잡도
		List<String> bfsResult1 = bfsCombination1(digits);
		List<String> bfsResult2 = bfsCombination2(digits);
		List<String> recursiveResult = new ArrayList<>();
		recursiveDfsCombination(recursiveResult, digits, new StringBuilder(), 0);

		return bfsResult1;
	}

	// 방법 1, 반복문 BFS
	// 같은 레벨 모두 순회 후 다음 레벨 순회
	// Queue에서 꺼내 문자열 더하고 다시 add
	private List<String> bfsCombination1(String digits) {
		LinkedList<String> result = new LinkedList<>();
		result.add("");

		for (int i = 0; i < digits.length(); i++) {
			int number = Character.getNumericValue(digits.charAt(i));
			while (result.peek().length() == i) {
				String combi = result.poll();
				for (char c : DIGIT_TO_LETTERS[number].toCharArray()) {
					result.add(combi + c);
				}
			}
		}

		return result;
	}

	// 방법 2, 반복문 BFS
	private List<String> bfsCombination2(String digits) {
		LinkedList<String> result = new LinkedList<>();
		result.add("");

		while (result.peek().length() != digits.length()) {
			String combi = result.poll();
			String mapLetter = DIGIT_TO_LETTERS[digits.charAt(combi.length()) - '0']; // 조합한 문자 길이값의 위치에 있는 digit과 매핑되는 문자열
			for (char c : mapLetter.toCharArray()) {
				result.addLast(combi + c);
			}

		}

		return result;
	}

	// 방법 3, 재귀 DFS
	private void recursiveDfsCombination(List<String> result, String digits, StringBuilder combi, int offset) {
		if (offset == digits.length()) {
			result.add(combi.toString());
			return;
		}

		int number = digits.charAt(offset) - '0';
		for (int i = 0; i < DIGIT_TO_LETTERS[number].length(); i++) {
			combi.append(DIGIT_TO_LETTERS[number].charAt(i));
			recursiveDfsCombination(result, digits, combi, offset + 1);
			combi.deleteCharAt(combi.length() - 1);
		}
	}
}
