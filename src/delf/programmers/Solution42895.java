package programmers;

import java.util.*;

/**
 * N으로 표현
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 */
public class Solution42895 {
	private final static int MAX = 8;

	public static int solution(int n, int num) {
		List<Set<Integer>> sets = new ArrayList<>();

		for (int i = 0; i < MAX; i++) {
			Set<Integer> set = new HashSet<>();
			set.add(repeatIntegerN(n, i + 1));
			sets.add(set);
		}

		for (int i = 0; i < sets.size(); i++) {
			for (int j = 0; j < i; j++) {
				for (int op1 : sets.get(j)) {
					for (int op2 : sets.get(i - j - 1)) {
						sets.get(i).add(op1 + op2);
						sets.get(i).add(op1 - op2);
						sets.get(i).add(op1 * op2);
						if (op2 != 0) {
							sets.get(i).add(op1 / op2);
						}
					}
				}
			}
			if (sets.get(i).contains(num)) {
				return i + 1;
			}
		}
		return -1;
	}

	private static int repeatIntegerN(int n, int repeat) {
		int result = 0;
		while (repeat-- > 0) {
			result *= 10;
			result += n;
		}
		return result;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (j + i != 3) {
					continue;
				}
				System.out.println(i + " " + j);
			}
			System.out.println();
		}
		System.out.println(solution(5, 12));
	}

}
