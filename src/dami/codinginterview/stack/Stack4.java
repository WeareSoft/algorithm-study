package dami.codinginterview.stack;

import java.util.Stack;

public class Stack4 {
	public int[] span(int[] prices) {
		return mySolution1(prices);
	}

	// 현재까지 중 최고값 인덱스 기록
	// 전날보다 상승했으면 최고점부터 연속 구간 길이 계산
	// 전날보다 하락했으면 1
	private int[] mySolution1(int[] prices) {
		int[] result = new int[prices.length];
		result[0] = 1;

		int maxIndex = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[maxIndex]) {
				maxIndex = i;
			}

			if (prices[i] >= prices[i - 1]) {
				if (maxIndex != i) {
					result[i] = i - maxIndex;
				} else {
					result[i] = i + 1;
				}
			} else {
				result[i] = 1;
			}
		}

		return result;
	}

	//         5 3 2 4 7 1
	// index : 0 1 2 3 4 5
	// span  : 1
	// 스택에 index를 넣는 것
	// 현재 값 > 스택 peek한 index의 값이면 span 값 계산 후 현재 값 push
	// 아니면 index의 값일 클 때까지 pop하고 span 값 계산 후 현재 값 push
	// span 값은 현재 인덱스 - 스택 peek 인덱스
	private int[] solution(int[] prices) {
		int[] result = new int[prices.length];
		Stack<Integer> indexes = new Stack<>();
		indexes.push(0);
		result[0] = 1;

		for (int i = 1; i < prices.length; i++) {
			while (!indexes.isEmpty() && prices[i] >= prices[indexes.peek()]) {
				indexes.pop();
			}

			result[i] = indexes.isEmpty() ? i + 1 : i - indexes.peek();
			indexes.push(i);
		}

		return result;
	}
}
