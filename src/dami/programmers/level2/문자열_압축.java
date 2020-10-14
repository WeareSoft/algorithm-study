package dami.programmers.level2;

import java.util.Stack;

// 1. 문자열 길이만큼 반복
//  - 문자열 맨 앞 자르기
//  - 인덱스(==자를 문자열 개수)가 잘린 문자열 길이 초과하면 남은 문자열 뒤에 그대로 붙이기
//  - 자른 문자열 스택에 넣고 같은지 다른지 비교
//  - 같으면 스택에 추가 / 다르면 압축 문자열 길이 +=
//  2. 문자열 인덱스만큼 모두 자를 때까지 반복했는데 스택에 남은 값 있으면 압축 문자열 길이 +=
//  3. 압축 문자열 길이 최소값 비교해서 return
public class 문자열_압축 {
	public int solution(String s) {
		int answer = Integer.MAX_VALUE;

		if (s.length() == 1) {
			return 1;
		}

		Stack<String> stringStack = new Stack<>();
		for (int i = 1; i <= s.length(); i++) {
			StringBuilder originString = new StringBuilder(s);
			int compressedLength = 0;

			String substring = substringAndDelete(originString, i);
			stringStack.push(substring);

			while (originString.length() != 0) {
				if (i > originString.length()) {
					compressedLength += originString.length();
					break;
				}

				substring = substringAndDelete(originString, i);
				if (stringStack.peek().equals(substring)) {
					stringStack.push(substring);
					continue;
				}

				compressedLength += compressString(stringStack);
				stringStack.removeAllElements();
				stringStack.push(substring);
			}

			if (!stringStack.isEmpty()) {
				compressedLength += compressString(stringStack);
				stringStack.removeAllElements();
			}

			answer = Math.min(answer, compressedLength);
		}

		return answer;
	}

	private String substringAndDelete(StringBuilder stringBuilder, int index) {
		String substring = stringBuilder.substring(0, index);
		stringBuilder.delete(0, index);
		return substring;
	}

	private int compressString(Stack<String> stringStack) {
		return ((stringStack.size() > 1 ? stringStack.size() : "") + stringStack.pop()).length();
	}

}
