package dami.codinginterview.stack;

import java.util.Stack;

public class Stack1 {
	public Stack<Integer> reverse(Stack<Integer> stack) {
		//return mySolution1(stack);
		solution(stack);
		return stack;
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

	// 다른 자료구조를 사용하지 않고 재귀적으로 Stack만 사용
	// 시간 : O(n^2)
	// 공간 : O(n), 메모리를 계속 잡고 있지 않기 때문에 n
	private void solution(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int value = stack.pop();
		solution(stack);
		insertAtBottom(stack, value);
	}

	private void insertAtBottom(Stack<Integer> stack, int number) {
		if (stack.isEmpty()) {
			stack.push(number);
			return;
		}

		int value = stack.pop();
		insertAtBottom(stack, number);
		stack.push(value);
	}
}
