package dami.programmers.level2;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/1845

// 1. 최대 종류 수는 nums.length / 2
// 2. 주어진 배열을 set에 저장
// 3. set의 크기와 최대 종류 수 중 작은 값 return

public class 폰켓몬 {
	public int solution(int[] nums) {
		int maxType = nums.length / 2;
		Set<Integer> numSet = Arrays.stream(nums)
				.boxed()
				.collect(Collectors.toSet());

		return Math.min(numSet.size(), maxType);
	}
}
