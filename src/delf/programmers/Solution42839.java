package programmers;


import java.util.HashSet;
import java.util.Set;

/**
 * 소수찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class Solution42839 {


	public static void main(String[] args) {
		System.out.println(new Solution42839().solution("1234"));
	}

	public int solution(String numbers) {
		Set<Integer> set = new HashSet<>();
		for (char i : numbers.toCharArray()) {
			set.add(i - '0');
		}

		for (int i = 2; i <= numbers.length(); i++) {
			set.addAll(new Permutation(numbers, i).getResult());
		}

		int count = 0;
		for (int n : set) {
			count += isPrime(n) ? 1 : 0;
		}

		return count;
	}


	public boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}

	class Permutation {

		private Set<Integer> set = new HashSet<>();

		public Set<Integer> getResult() {
			return set;
		}

		public Permutation(String number, int r) {
			permutation(number.toCharArray(), 0, number.length(), r);
		}

		private void permutation(char[] arr, int depth, int n, int r) {
			if (depth == r) {
				set.add(arrToInteger(arr, r));
				return;
			}

			for (int i = depth; i < n; i++) {
				swap(arr, depth, i);
				permutation(arr, depth + 1, n, r);
				swap(arr, depth, i);
			}
		}

		private void swap(char[] arr, int depth, int i) {
			char temp = arr[depth];
			arr[depth] = arr[i];
			arr[i] = temp;
		}

		private int arrToInteger(char[] arr, int r) {
			int result = 0;
			for (int i = 0; i < r; i++) {
				result *= 10;
				result += (arr[i] - '0');
			}
			return result;
		}
	}

}
