package dami.leetcode;

public class Two_Sum_1 {

    // int[] nums = {2, 7, 11, 15};
    // int target = 9;
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return null;
    }
}
