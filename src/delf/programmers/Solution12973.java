package programmers;

import java.util.Stack;

/**
 * 짝지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 */
public class Solution12973 {
	public static void main(String[] args) {
		System.out.println(new Solution12973().solution("cdcd"));
		System.out.println(new Solution12973().solution("baabaa"));
	}

	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(ch);
				continue;
			}

			if (stack.peek() == ch) {
				stack.pop();
				continue;
			}

			stack.push(ch);
		}

		return stack.isEmpty() ? 1 : 0;
	}
}
