package dami.programmers.level2;

import java.util.Stack;

public class 올바른_괄호 {
	boolean solution(String s) {
		Stack<Character> brackets = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);

			if (current == '(') {
				brackets.push(current);
				continue;
			}
			if (current == ')') {
				if (brackets.isEmpty()) {
					return false;
				}
				brackets.pop();
			}
		}
		return brackets.isEmpty();
	}
}
