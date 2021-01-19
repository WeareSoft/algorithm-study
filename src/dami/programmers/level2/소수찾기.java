package dami.programmers.level2;

import java.util.*;


// https://programmers.co.kr/learn/courses/30/lessons/42839/solution_groups?language=java&type=all
public class 소수찾기 {
	public int solution(String numbers) {
		HashSet<Integer> numberSet = new HashSet<>();
		permutation("", numbers, numberSet);

		int count = 0;
		while (numberSet.iterator().hasNext()) {
			int number = numberSet.iterator().next();
			numberSet.remove(number);

			if (number == 2) {
				count++;
			}
			if (number % 2 != 0 && isPrime(number)) {
				count++;
			}
		}
		return count;
	}

	private boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		for (int i = 3; i <= (int)Math.sqrt(n); i+=2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private void permutation(String prefix, String numbers, HashSet<Integer> numberSet) {
		int length = numbers.length();

		if (!"".equals(prefix)) {
			numberSet.add(Integer.valueOf(prefix));
		}
		for (int i = 0; i < length; i++) {
			permutation(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1, length), numberSet);
		}
	}
}

/*
public class 소수찾기 {
	private static final Set<Integer> combiNumbers = new HashSet<>();

	public int solution(String numbers) {
		boolean[] visited = new boolean[numbers.length()];

		for (int i = 1; i <= numbers.length(); i++) {
			combination(numbers.toCharArray(), visited, 0, numbers.length(), i);
		}

		return combiNumbers.size();
	}

	private void combination(char[] numbers, boolean[] visited, int start, int arrLength, int combiLength) {
		if (combiLength == 0) {
			addSet(numbers, visited, arrLength);
			return;
		}

		for (int i = start; i < arrLength; i++) {
			visited[i] = true;
			combination(numbers, visited, i + 1, arrLength, combiLength - 1);
			visited[i] = false;
		}
	}

	private void addSet(char[] numbers, boolean[] visited, int length) {
		StringBuilder combiNumber = new StringBuilder();
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				combiNumber.append(numbers[i]);
			}
		}

		permutation(combiNumber.toString().toCharArray(), 0, combiNumber.length(), combiNumber.length());
	}

	private void permutation(char[] numbers, int depth, int arrayLength, int permCount) {
		if (depth == permCount) {
			addPermNumbers(numbers, permCount);
			return;
		}
		for (int i = depth; i < arrayLength; i++) {
			swap(numbers, depth, i);
			permutation(numbers, depth + 1, arrayLength, permCount);
			swap(numbers, depth, i);
		}
	}

	private void swap(char[] arr, int depth, int i) {
		char temp = arr[depth];
		arr[depth] = arr[i];
		arr[i] = temp;
	}

	private void addPermNumbers(char[] numbers, int length) {
		StringBuilder permNumber = new StringBuilder();
		for (int i = 0; i < length; i++) {
			permNumber.append(numbers[i]);
		}

		int number = Integer.parseInt(String.valueOf(permNumber));

		if (isPrimeNumber(number)) {
			combiNumbers.add(number);
		}
	}

	private boolean isPrimeNumber(int number) {
		if (number < 2) {
			return false;
		}

		int sqrt = (int)Math.sqrt(number);
		while (sqrt > 1) {
			if (number % sqrt == 0) {
				return false;
			}
			sqrt--;
		}
		return true;
	}
}
*/
