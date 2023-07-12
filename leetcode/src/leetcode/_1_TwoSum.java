package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
	public static void main(String args[]) {
		int[] str = new int[] { 2, 7, 11, 15 };
		int target = 22;
		str = twoSum(str, target);
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
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
