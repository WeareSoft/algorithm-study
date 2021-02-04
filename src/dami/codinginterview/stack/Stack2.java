package dami.codinginterview.stack;

import java.util.*;

// 스택 혹은 디큐를 써도 되는지 묻기
public class Stack2 {
	public boolean isPair(String expression) {
		return mySolution(expression);
	}

	private boolean mySolution(String expression) {
		Map<Character, Character> brackets = new HashMap<>();
		brackets.put('[', ']');
		brackets.put('{', '}');
		brackets.put('(', ')');

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
			if (brackets.containsKey(current)) {
				stack.push(current);
			// TODO "(())))" 같은 경우 고려 필요
			} else if (!stack.isEmpty() && brackets.get(stack.peek()) == current) {
				stack.pop();
			}
		}

		return stack.isEmpty();
	}

	private boolean solution(String expression) {
		List<Character> openingBrackets = Arrays.asList('[', '{', '(');
		List<Character> closingBrackets = Arrays.asList(']', '}', ')');

		Stack<Character> brackets = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
			if (openingBrackets.contains(current)) {
				brackets.push(current);
			} else if (closingBrackets.contains(current)) {
				if (brackets.isEmpty()) {
					return false;
				}

				Character bracket = brackets.pop();
				if (openingBrackets.indexOf(bracket) != closingBrackets.indexOf(current)) {
					return false;
				}
			}
		}

		return brackets.isEmpty();
	}
}
