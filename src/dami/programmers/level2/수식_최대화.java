package dami.programmers.level2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/67257

// 1. 연산자 우선순위 조합 목록 만들기
// 2. 피연산자, 연산자 분리해서 각각 LinkedList에 저장
// 3. 우선순위 조합 목록 크기만큼 반복해서 수식 계산
// 4. 계산 결과 최댓값 비교
public class 수식_최대화 {
	private static final String[] OPERATORS = new String[] {"+", "-", "*"};
	private static final String OPERATOR_PATTERN = Pattern.compile("[+*-]").pattern();
	private static final String OPERAND_PATTERN = Pattern.compile("[0-9]*").pattern();

	public long solution(String expression) {
		List<String> priorities = new ArrayList<>();
		permutation(priorities, new StringBuilder(), 0);

		List<Long> operands = getAllOperands(expression);
		List<String> operators = getAllOperators(expression);
		long max = 0;

		for (String priority : priorities) {
			long sum = 0;
			LinkedList<Long> exOperands = new LinkedList<>(operands);
			LinkedList<String> exOperators = new LinkedList<>(operators);
			for (int i = 0; i < priority.length(); i++) {
				String operator = String.valueOf(priority.charAt(i));
				while (exOperators.contains(operator)) {
					int index = exOperators.indexOf(operator);
					sum = calculate(exOperands.get(index), exOperands.remove(index + 1), exOperators.remove(index));
					exOperands.set(index, sum);
				}
			}
			max = Math.max(max, Math.abs(sum));
		}

		return max;
	}

	private List<Long> getAllOperands(String expression) {
		return Arrays.stream(expression.split(OPERATOR_PATTERN))
				.mapToLong(Long::parseLong)
				.boxed()
				.collect(Collectors.toList());
	}

	private List<String> getAllOperators(String expression) {
		return Arrays.stream(expression.split(OPERAND_PATTERN))
				.filter(operator -> operator.length() != 0)
				.collect(Collectors.toList());
	}

	private void permutation(List<String> priorities, StringBuilder prefix, int depth) {
		if (depth == OPERATORS.length) {
			priorities.add(prefix.toString());
			return;
		}

		for (int i = depth; i < OPERATORS.length; i++) {
			prefix.append(OPERATORS[i]);
			swap(i, depth);
			permutation(priorities, prefix, depth + 1);
			prefix.deleteCharAt(prefix.length() - 1);
			swap(i, depth);
		}
	}

	private void swap(int depth, int i) {
		String temp = OPERATORS[depth];
		OPERATORS[depth] = OPERATORS[i];
		OPERATORS[i] = temp;
	}

	private long calculate(long operand1, long operand2, String operator) {
		long result = 0;
		switch (operator) {
			case "+": result = operand1 + operand2;
				break;
			case "-": result = operand1 - operand2;
				break;
			case "*": result = operand1 * operand2;
				break;
			default: break;
		}
		return result;
	}

}
