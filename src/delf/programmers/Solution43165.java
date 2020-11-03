package programmers;

/**
 * 타겟 넘버
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */
public class Solution43165 {
	public static void main(String[] args) {
		System.out.println(new Solution43165().solution(new int[]{1, 1, 1, 1, 1}, 3));
	}

	public int solution(int[] numbers, int target) {
		return dfs(numbers, target, 0, 0, 0);
	}

	private int dfs(int[] numbers, int target, int depth, int sum, int count) {
		if (depth == numbers.length) {
			if (sum == target) {
				count++;
			}
			return count;
		}
		return dfs(numbers, target, depth + 1, sum + numbers[depth], count)
				+ dfs(numbers, target, depth + 1, sum - numbers[depth], count);
	}
}
