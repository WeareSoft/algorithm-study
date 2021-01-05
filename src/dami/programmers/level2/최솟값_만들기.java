package dami.programmers.level2;

// https://programmers.co.kr/learn/courses/30/lessons/12941

import java.util.Arrays;

public class 최솟값_만들기 {
	public int solution(int []A, int []B) {
		Arrays.sort(A);
		Arrays.sort(B);

		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum += A[i] * B[B.length - i - 1];
		}

		return sum;
	}

	// 정렬 알고리즘 연습 (퀵 정렬)
	private void ascSort(int[] array) {
		recursiveAsc(array, 0, array.length - 1);
	}

	private void recursiveAsc(int[] array, int start, int end) {
		if (end - start <= 0) {
			return;
		}

		int low = start + 1;
		int high = end;
		int pivot = array[start];
		while (low <= high) {
			while (low <= high && pivot > array[low]) { // pivot보다 큰 값 찾을 때까지 이동
				low++;
			}

			while (pivot < array[high]) { // pivot보다 작은 값 찾을 때까지 이동
				high--;
			}

			if (low <= high) {
				swap(array, low, high);
			}
		}

		if (start < end) {
			swap(array, start, high);
			recursiveAsc(array, start, high - 1);
			recursiveAsc(array, high + 1, end);
		}
	}

	private void descSort(int[] array) {
		recursiveDesc(array, 0, array.length - 1);
	}

	private void recursiveDesc(int[] array, int start, int end) {
		if (end - start <= 0) {
			return;
		}

		int low = start + 1;
		int high = end;
		int pivot = array[start];
		while (low <= high) {
			while (low <= high && pivot < array[low]) { // pivot보다 작은 array 값 찾을 때까지 이동
				low++;
			}

			while (pivot > array[high]) { // pivot보다 큰 array 값 찾을 때까지 이동
				high--;
			}

			if (low <= high) {
				swap(array, low, high);
			}
		}

		if (start < end) {
			swap(array, start, high);
			recursiveDesc(array, start, high - 1);
			recursiveDesc(array, high + 1, end);
		}
	}

	private void swap(int[] array, int low, int high) {
		int temp = array[low];
		array[low] = array[high];
		array[high] = temp;
	}
}
