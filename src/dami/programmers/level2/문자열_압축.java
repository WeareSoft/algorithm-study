package dami.programmers.level2;

import java.util.Stack;

public class 문자열_압축 {
	public int solution(String s) {
		int answer = Integer.MAX_VALUE;

		if (s.length() == 1) {
			return 1;
		}

		Stack<String> stringStack = new Stack<>();
		for (int i = 1; i <= s.length(); i++) {
			StringBuilder originString = new StringBuilder(s);
			StringBuilder compressedString = new StringBuilder();

			String substring = originString.substring(0, i);
			originString.delete(0, i);
			stringStack.push(substring);

			while (originString.length() != 0) {
				if (i > originString.length()) {
					compressedString.append(originString);
					break;
				}

				substring = originString.substring(0,i);
				originString.delete(0, i);
				if (stringStack.peek().equals(substring)) {
					stringStack.push(substring);
					continue;
				}

				compressedString.append(stringStack.size() > 1 ? stringStack.size() : "")
						.append(stringStack.pop());
				stringStack.removeAllElements();
				stringStack.push(substring);
			}

			if (!stringStack.isEmpty()) {
				compressedString.append(stringStack.size() > 1 ? stringStack.size() : "")
						.append(stringStack.pop());
				stringStack.removeAllElements();
			}

			answer = Math.min(answer, compressedString.length());
		}

		return answer;
	}

}
