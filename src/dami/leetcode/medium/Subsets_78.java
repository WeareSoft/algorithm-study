package dami.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets_78 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		recursive(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private void recursive(List<List<Integer>> result, List<Integer> set, int[] nums, int start) {
		result.add(new ArrayList<>(set));

		for (int i = start; i < nums.length; i++) {
			set.add(nums[i]);
			recursive(result, set, nums, i + 1);
			set.remove(set.size() - 1);
		}
	}
}
