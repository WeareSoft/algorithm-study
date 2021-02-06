package interviewguidemission;

import java.util.Arrays;
import java.util.List;

public class StackMission1 {
	public static void main(String[] args) {
		System.out.println(new StackMission1().solution("[{1+2*(2+2)}-(1-3)]", 1));
	}

	public int solution(String s, int index) {
		List<Character> open = Arrays.asList('(', '{', '[');
		List<Character> close = Arrays.asList(')', '}', ']');
		char openTarget = s.charAt(index);
		char closeTarget = close.get(open.indexOf(openTarget));
		boolean listen = false;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == openTarget) {
				listen = true;
				continue;
			}
			if (listen && ch == closeTarget) {
				return i;
			}
		}
		throw new IllegalStateException();
	}
}