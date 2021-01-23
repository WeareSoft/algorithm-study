package dami.codinginterview.array;

public class Array4 {
	public int[] sorting(int[] array) {
		return mySolution(array);
		//return solution(array);
	}

	private int[] mySolution(int[] array) {
		int[] sorted = new int[array.length * 2];

		for (int number : array) {
			sorted[number - 1] = number;
		}

		int index = 0;
		for (int number : sorted) {
			if (number != 0) {
				array[index++] = number;
			}
		}

		return array;
	}

	private int[] solution(int[] array) {
		boolean[] booleans = new boolean[array.length * 2];

		for (int number : array) {
			booleans[number] = true;
		}

		int[] sorted = new int[array.length];
		int index = 0;
		for (int i = 0; i < booleans.length; i++) {
			if (booleans[i]) {
				sorted[index++] = i;
			}
		}

		return sorted;
	}
}
