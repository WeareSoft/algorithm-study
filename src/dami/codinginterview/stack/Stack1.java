package dami.codinginterview.stack;

import java.util.Stack;

public class Stack1 {
	public Stack<Integer> reverse(Stack<Integer> stack) {
		return mySolution1(stack);
	}

	// 시간 : O(n)
	// 공간 : O(1)
	private Stack<Integer> mySolution1(Stack<Integer> stack) {
		int size = stack.size();
		for (int i = 0; i < size / 2; i++) {
			swap(stack, i, size - i - 1);
		}
		return stack;
	}

	private void swap(Stack<Integer> stack, int i, int j) {
		int temp = stack.elementAt(i);
		stack.setElementAt(stack.elementAt(j), i);
		stack.setElementAt(temp, j);
	}

	// 시간 : O(n)
	// 공간 : O(n)
	private Stack<Integer> mySolution2(Stack<Integer> stack) {
		Stack<Integer> reversed = new Stack<>();
		while (!stack.isEmpty()) {
			reversed.push(stack.pop());
		}
		return reversed;
	}

	private Stack<Integer> solution(Stack<Integer> stack) {
		return null;
	}
}
