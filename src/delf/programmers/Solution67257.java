package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 수식 최대화
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */
public class Solution67257 {
	public static void main(String[] args) {
		System.out.println(new Solution67257().solution("100-200*300-500+20"));
		System.out.println(new Solution67257().solution("50*6-3*2"));
	}

	private List<Long> numbers;
	private List<Character> operator = new ArrayList<>();

	public long solution(String expression) {
		String[] tmp = expression.split("[+*\\-]");
		numbers = Arrays.stream(tmp).mapToLong(Long::parseLong).boxed().collect(toList());

		int cursor = 0;
		for (int i = 0; i < numbers.size() - 1; i++, cursor++) {
			cursor += tmp[i].length();
			operator.add(expression.charAt(cursor));
		}

		String[] priorities = {"+*-", "+-*", "*+-", "*-+", "-+*", "-*+"};

		long max = 0;
		for (String priority : priorities) {
			long value = calcValueByPriority(priority);
			max = Math.max(max, Math.abs(value));
		}

		return max;
	}

	private long calcValueByPriority(String priority) {
		List<Long> tmpNumbers = new ArrayList<>(numbers);
		List<Character> tmpOperator = new ArrayList<>(operator);
		long result = 0;
		for (char op : priority.toCharArray()) {
			if (!tmpOperator.contains(op)) {
				continue;
			}
			int index;
			while ((index = tmpOperator.indexOf(op)) != -1) {
				long op1 = tmpNumbers.remove(index + 1);
				long op2 = tmpNumbers.get(index);
				result = calc(op2, op1, tmpOperator.remove(index));
				tmpNumbers.set(index, result);
			}

		}
		return result;
	}

	private long calc(long op1, long op2, char operator) {
		switch (operator) {
			case '+':
				return op1 + op2;
			case '-':
				return op1 - op2;
			case '*':
				return op1 * op2;
		}
		throw new IllegalArgumentException();
	}
}
