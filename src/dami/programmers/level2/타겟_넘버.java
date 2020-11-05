package dami.programmers.level2;

import java.util.Arrays;

// https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
public class 타겟_넘버 {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		int sum = Arrays.stream(numbers).sum();

		for (int i = 0; i < numbers.length; i++) {
			answer += recursive(sum - target, i, numbers, 0);
		}

		return answer;
	}

	private int recursive(int currentSum, int currentIndex, int[] numbers, int result) {
		if (currentSum < numbers[currentIndex] * 2) {
			return result;
		}

		if (currentSum == numbers[currentIndex] * 2) {
			return result + 1;
		}

		for (int i = currentIndex; i < numbers.length; i++) {
			if (currentSum > numbers[i] * 2 ) {
				return recursive(currentSum - numbers[i] * 2, i + 1, numbers, result +  1);
			}
		}

		return result;
	}
}
