package dami.codinginterview.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Stack3 {
	public int calculatePostfix(String expression) {
		return mySolution(expression);
	}

	private int mySolution(String expression) {
		Set<Character> operators = new HashSet<>();
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char current = expression.charAt(i);
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

	private int solution(String expression) {
		return 0;
	}
}
