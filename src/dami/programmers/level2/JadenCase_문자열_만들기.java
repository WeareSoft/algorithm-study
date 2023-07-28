package dami.programmers.level2;

import java.util.StringTokenizer;

public class JadenCase_문자열_만들기 {
	public String solution() {
		StringBuilder answer = new StringBuilder();

		String s = " for 3the last   week ";
		String[] words = s.toLowerCase().split("\\s");
		for (String word : words) {
			if (word.isEmpty()) {
				answer.append(" ");
				continue;
			}

			answer.append(word.substring(0, 1).toUpperCase())
					.append(word.substring(1))
					.append(" ");
		}

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ');
		}

		StringTokenizer tokenizer = new StringTokenizer(s);
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			String jadenToken = token.substring(0,1).toUpperCase() + token.substring(1);
		}

		System.out.println(answer.toString());
		return answer.substring(0, answer.length() - 1);
	}

	public String solution2(String s) {
		StringBuilder answer = new StringBuilder(s.toLowerCase());
		boolean isEmpty = true;
		for (int i = 0; i < s.length(); i++) {
			char currentChar = s.charAt(i);
			if (currentChar == ' ') {
				isEmpty = true;
				continue;
			}

			if (isEmpty) {
				answer.replace(i, i + 1, String.valueOf(currentChar).toUpperCase());
				isEmpty = false;
			}
		}

		System.out.println(answer.toString());
		return answer.toString();
	}

	public static void main(String[] args) {
		new JadenCase_문자열_만들기().solution2("");
	}
}
