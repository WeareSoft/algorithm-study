package dami.hackerrank.medium;

import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class Minimum_Swaps_2 {
	public int minimumSwaps(int[] arr) {
		//return timeLimit(arr);
		return solution(arr);
	}

	// 시간 : O(n)
	// 공간 : O(n)
	private int solution(int[] arr) {
		int count = 0;

		Map<Integer, Integer> numberMap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			numberMap.put(arr[i], i);
		}

		for (int i = 0; i < arr.length; i++) {
			int j = numberMap.get(i + 1);
			if (i != j) {
				swap(numberMap, arr, i, j);
				count++;
			}
		}

		return count;
	}


	// 시간 : O(n^2)
	// 공간 : O(1)
	private int timeLimit(int[] arr) {
		int count = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = minIndex + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			if (minIndex != i) {
				swap(arr, i, minIndex);
				count++;
			}
		}

		return count;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void swap(Map<Integer, Integer> numberMap, int[] arr, int i, int j) {
		swap(arr, i, j);
		numberMap.put(arr[i], i);
		numberMap.put(arr[j], j);
	}
}
