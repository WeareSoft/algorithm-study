package dami.programmers.level2;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/12973
public class 짝지어_제거하기 {
	public int solution_2020(String s) {
		Stack<Character> stack = new Stack<>();
		stack.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
				stack.pop();
			} else {
				stack.push(s.charAt(i));
			}
		}
		return stack.size() > 0 ? 0 : 1;
	}

	public int solution_2023(String s) {
		// baabaa cdcd stack?
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (char c : chars) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty() ? 1 : 0;
	}

	public static void main(String[] args) {
		System.out.println(new 짝지어_제거하기().solution_2023("a"));
	}
}
