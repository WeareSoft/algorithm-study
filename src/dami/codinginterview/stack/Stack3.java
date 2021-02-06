package dami.codinginterview.stack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class Stack3 {
	public int calculatePostfix(String postfix) {
		return mySolution(postfix);
	}

	private int mySolution(String postfix) {
		Set<Character> operators = new HashSet<>();
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < postfix.length(); i++) {
			char current = postfix.charAt(i);
			if (!operators.contains(current)) {
				stack.push(current - '0');
			} else {
				int num2 = stack.pop();
				int num1 = stack.pop();
				stack.push(operate(num1, num2, current));
			}
		}

		return stack.pop();
	}

	private int operate(int num1, int num2, int operator) {
		switch (operator) {
			case '+' : return num1 + num2;
			case '-' : return num1 - num2;
			case '*' : return num1 * num2;
			case '/' : return num1 / num2;
		}
		throw new IllegalArgumentException("수식 오류");
	}

	private int solution(String postfix) {
		LinkedList<Integer> numbers = new LinkedList<>();
		char[] chars = postfix.trim().toCharArray();
		for (char c : chars) {
			if (Character.isDigit(c)) {
				numbers.push(c - '0');
			} else {
				int right = numbers.pop();
				int left = numbers.pop();

				switch (c) {
					case '+' : numbers.push(left + right); break;
					case '-' : numbers.push(left - right); break;
					case '*' : numbers.push(left * right); break;
					case '/' : numbers.push(left / right); break;
				}
			}
		}

		return numbers.pop();
	}

	private String infixToPostfix(String infix) {
		Stack<Character> operators = new Stack<>();

		infix = infix.trim();
		StringBuilder postfix = new StringBuilder();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (Character.isDigit(c)) {
				postfix.append(c);
			} else if (c == '(') {
				operators.push(c);
			} else if (c == ')') {
				while (!operators.isEmpty() && operators.peek() != '(') {
					postfix.append(operators.pop());
				}
				operators.pop();
			} else {
				while (!operators.isEmpty() && precedence(c) <= precedence(operators.peek())) {
					postfix.append(operators.pop());
				}

				operators.push(c);
			}
		}

		while (!operators.isEmpty()) {
			postfix.append(operators.pop());
		}

		return postfix.toString();
	}

	private int precedence(char c) {
		if (c == '+' || c == '-') {
			return 1;
		} else if (c == '*' || c == '/') {
			return 2;
		}
		return 0;
	}
}
