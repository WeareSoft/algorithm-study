package dami.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/3sum/
public class Three_Sum_15 {
	private static final int TARGET = 0;

	// {-1, 0, 1, 2, -1, -4}
	public List<List<Integer>> threeSum(int[] nums) {
		Map<Integer, Integer> numsMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			numsMap.putIfAbsent(nums[i], i);
		}

		List<List<Integer>> result = new ArrayList<>();
		for (Integer key : numsMap.keySet()) {
			int newTarget = TARGET - key;
			int i = numsMap.get(key) + 1;
			while (i < nums.length) {
				int lastValue = newTarget - nums[i];
				if (numsMap.containsKey(lastValue) && numsMap.get(lastValue) != i && lastValue != key) {
					result.add(new ArrayList<>(Arrays.asList(key, nums[i], lastValue)));
					break;
				}
				i++;
			}
		}


		return result;
	}
}
