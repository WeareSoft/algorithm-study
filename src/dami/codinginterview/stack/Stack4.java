package dami.codinginterview.stack;

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

	// 스택을 어떻게 활용해야하남..
	private int[] solution(int[] prices) {
		return null;
	}
}
