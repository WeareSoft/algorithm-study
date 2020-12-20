package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 폰켓몬
 * https://programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Solution1845 {
	public static void main(String[] args) {
		System.out.println(new Solution1845().solution(new int[]{3, 3, 3, 2, 2, 4}));

	}

	public int solution(int[] nums) {

		return Math.min(nums.length / 2, IntStream.of(nums).boxed().collect(Collectors.toCollection(HashSet::new)).size());

	}

	public int solution2(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		return Math.min(nums.length / 2, set.size());
	}
}
