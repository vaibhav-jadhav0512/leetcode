package leetcode;

public class _8_MajorityElement {
	public static void main(String args[]) {
		int[] arr = new int[] { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(majorityElement(arr));
	}

	public static int majorityElement(int[] arr) {
		int count = 0;
		int element = 0;
		for (int i = 0; i < arr.length; i++) {
			if (count == 0)
				element = arr[i];
			if (arr[i] == element)
				count += 1;
			else
				count -= 1;
		}
		return element;
	}
}
//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//Example 1:
//Input: nums = [3,2,3]
//Output: 3
//Example 2:
//Input: nums = [2,2,1,1,1,2,2]
//Output: 2