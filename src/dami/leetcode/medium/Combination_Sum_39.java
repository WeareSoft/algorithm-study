package dami.leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/

public class Combination_Sum_39 {
	private List<List<Integer>> result;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);

		result = new ArrayList<>();
		recursive(new ArrayList<>(), candidates, target, 0, 0);

		return result;
	}

	private void recursive(List<Integer> candidate, int[] candidates, int target, int sum, int index) {
		if (sum == target) {
			result.add(new ArrayList<>(candidate));
			return;
		}

		for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
			if (sum + candidates[i] > target) {
				break;
			}
			candidate.add(candidates[i]);
			recursive(candidate, candidates, target, sum + candidates[i], index++);
			candidate.remove(candidate.size() - 1);
		}
	}

	/*
	private void recursive2(List<Integer> candidate, int[] candidates, int target, int index) {
		if (target == 0) {
			result.add(new ArrayList<>(candidate));
			return;
		}

		for (int i = index; i < candidates.length && candidates[i] <= target; i++) {
			if (target - candidates[i] > target) {
				break;
			}
			candidate.add(candidates[i]);
			recursive2(candidate, candidates,target - candidates[i], index++);
			candidate.remove(candidate.size() - 1);
		}
	}
	*/
}


/*

// 합한 값이 아니라 target에서 candidates[i] 값 빼서 최종 target == 0으로 비교하면 재귀 메소드 인자 한 개 줄이기 가능
// recursive2가 참고해서 인자 수 줄인 메소드

public List<List<Integer>> combinationSum(int[] candidates, int target) {
  List<List<Integer>> result = new ArrayList<>();
    helper(result,candidates,new ArrayList<>(),target,0);
    return result;
}
 void helper(List<List<Integer>> result, int[] candidates, List<Integer> temp, int target,int index) {
      if(target == 0) {
        result.add(new ArrayList<>(temp));
        return;
     }
        for(int i = index; i < candidates.length; i++) {
            if(candidates[i] <= target) {
            temp.add(candidates[i]);
            helper(result,candidates,temp,target-candidates[i],i);
            temp.remove(temp.size()-1);
        }
    }
}

*/
