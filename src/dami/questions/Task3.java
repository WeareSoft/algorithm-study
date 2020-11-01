package dami.questions;

import java.util.Stack;

public class Task3 {
	public void solution(int numOfOrder, String[] orderArr) {
		for (int i = 0; i < numOfOrder; i++) {
			StringBuilder result = new StringBuilder();
			Stack<String> orderStack = new Stack<>();
			char[] order = orderArr[i].toCharArray();

			for (char c : order) {
				if (c == ')') {
					while (!orderStack.isEmpty() && !"(".equals(orderStack.peek())) {
						result.append(orderStack.pop());
					}
					if ("(".equals(orderStack.pop())) {
						orderStack.push(appendBy(orderStack.pop(), result));
					}
					continue;
				}

				if (c != '(' && !orderStack.isEmpty() && isNumber(orderStack.peek())) {
					orderStack.push(appendBy(orderStack.pop(), new StringBuilder(String.valueOf(c))));
					continue;
				}

				orderStack.push(String.valueOf(c));
			}

			while (!orderStack.isEmpty()) {
				result.append(orderStack.pop());
			}

			System.out.println(result.reverse());
		}
	}

	private boolean isNumber(String prefix) {
		return prefix.charAt(0) >= '1' && prefix.charAt(0) <= '9';
	}

	private String appendBy(String prefix, StringBuilder result) {
		if (isNumber(prefix)) {
			return appendNumber((prefix.charAt(0) - '0'), result);
		}
		return appendCharacter(prefix, result);
	}

	private String appendNumber(int number, StringBuilder string) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number; i++) {
			sb.append(string);
		}
		string.delete(0, string.length());
		return sb.toString();
	}

	private String appendCharacter(String prefix, StringBuilder string) {
		StringBuilder sb = new StringBuilder(string);
		for (int i = 0; i < sb.length(); i+=2) {
			sb.insert(i+1, prefix);
		}
		string.delete(0, string.length());
		return sb.toString();
	}
}
