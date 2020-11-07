package etc.nhn;

import java.util.Stack;

public class NHN2020_03 {
	public static void main(String[] args) {

		System.out.println(new NHN2020_03().solution("3(RGBGB)"));
		System.out.println(new NHN2020_03().solution("R2(G)B"));
		System.out.println(new NHN2020_03().solution("2(B(1(R)2(G2B)))"));
		System.out.println(new NHN2020_03().solution("2(B(R)2(G))1(B2(B(R)))"));
		// 기본적으론 최근거 pop 해서 앞에 insert
		// 닫힌괄호면 String 추가해서 push
		// 열린괄호면 그 앞에 문자와 (최근 pop 계산) + pop 해서 다시 push
	}

	public String solution(String order) {
		Stack<String> stack = new Stack<>();
		for (int i = order.length() - 1; i >= 0; i--) {
			char ch = order.charAt(i);
			if (ch == ')') {
				stack.push("");
				continue;
			}

			if (ch == '(') {
				String inBracket = stack.isEmpty() ? "" : stack.pop();
				String postBracket = stack.isEmpty() ? "" : stack.pop();
				stack.push(calc(order.charAt(--i), inBracket) + postBracket);
				continue;
			}

			String pre = Character.isDigit(ch)
					? (ch + calc(ch - '0' - 1, order.charAt(i + 1) + ""))
					: ch + "";

			stack.push(pre + (stack.isEmpty() ? "" : stack.pop()));
		}

		return stack.pop();
	}

	private String calc(int num, String ch) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < num; i++) {
			result.append(ch);
		}
		return result.toString();
	}

	private String calc(char preBracket, String inBracket) {
		if (Character.isDigit(preBracket)) {
			return calc(preBracket - '0', inBracket);
		}
		StringBuilder result = new StringBuilder();
		for (char ch : inBracket.toCharArray()) {
			result.append(preBracket).append(ch);
		}
		return result.toString();
	}

}
