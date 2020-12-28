package dami.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/

// 순열 알고리즘 연습
public class Permutations_46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		recursive(result, nums, new ArrayList<>(), 0);

		return result;
	}

	private void recursive(List<List<Integer>> result, int[] nums, List<Integer> perms, int depth) {
		if (depth == nums.length) {
			result.add(new ArrayList<>(perms));
			return;
		}

		for (int i = depth; i < nums.length; i++) {
			perms.add(nums[i]);
			swap(nums, i, depth);
			recursive(result, nums, perms, depth + 1);
			perms.remove(perms.size() - 1);
			swap(nums, i, depth);
		}
	}

	private void swap(int[] nums, int index, int depth) {
		int temp = nums[index];
		nums[index] = nums[depth];
		nums[depth] = temp;
	}
}
