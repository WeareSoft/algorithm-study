package dami.codinginterview.array;

import java.util.HashMap;
import java.util.Map;

public class Array3 {
	public int[] solution(int[] numbers, int target) {
		//return iteration(numbers, target);
		//return useHashMap(numbers, target);
		return threeSum(numbers, target);
	}

	// 시간 : O(n^2), 공간 : O(1)
	private int[] iteration(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] {i, j};
				}
			}
		}

		return null;
	}

	// 시간 : O(n), 공간 : O(n)
	private int[] useHashMap(int[] numbers, int target) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			int otherValue = Math.abs(target - numbers[i]);
			if (indexMap.containsKey(otherValue)) {
				return new int[] {i, indexMap.get(otherValue)};
			}
			indexMap.put(numbers[i], i);
		}

		return null;
	}

	// 시간 : O(n^2), 공간 : O(n)
	private int[] threeSum(int[] numbers, int target) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			indexMap.put(numbers[i], i);
		}

		for (int i = 0; i < numbers.length; i++) {
			int newTarget = target - numbers[i];
			for (int j = i + 1; j < numbers.length; j++) {
				int otherValue = newTarget - numbers[j];
				if (indexMap.containsKey(otherValue) && indexMap.get(otherValue) != j) {
					return new int[] {i, j, indexMap.get(otherValue)};
				}
			}
		}

		return null;
	}
}
