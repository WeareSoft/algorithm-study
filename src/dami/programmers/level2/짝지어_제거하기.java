package dami.programmers.level2;

import java.util.Stack;

// https://programmers.co.kr/learn/courses/30/lessons/12973
public class 짝지어_제거하기 {
	public int solution(String s) {
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
}
