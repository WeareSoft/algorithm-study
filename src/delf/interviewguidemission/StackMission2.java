package interviewguidemission;

import java.util.*;

public class StackMission2 {
	public static void main(String[] args) {
		System.out.println(new StackMission2().solution("{{{}}"));
		System.out.println(new StackMission2().solution("{{{{}}"));
		System.out.println(new StackMission2().solution("}}}}{}}}"));
		System.out.println(new StackMission2().solution("{{{{"));
	}
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		for (char ch : s.toCharArray()) {
			if (stack.isEmpty()) {
				if (ch == '}') {
					cnt++;
					stack.push('{');
				} else {
					stack.push(ch);
				}
				continue;
			}

			if (ch == '{') {
				stack.push(ch);
			} else if (ch == '}' && stack.peek() == '{') {
				stack.pop();
			}
		}

		if (stack.isEmpty()) {
			return cnt;
		}

		if (stack.size() % 2 != 0) {
			return -1;
		}

		return cnt + stack.size() / 2;
	}
}
