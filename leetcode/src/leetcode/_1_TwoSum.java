package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
	public static void main(String args[]) {
		int[] str = new int[] { 2, 7, 11, 15 };
		int target = 22;
		str = twoSum(str, target);
		System.out.println(Arrays.toString(str));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numToIndex = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[] {numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
		return new int[] {};
	}
}
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//Example 1:
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//Input: nums = [3,3], target = 6
//Output: [0,1]