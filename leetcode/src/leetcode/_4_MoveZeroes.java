package leetcode;

import java.util.Arrays;

public class _4_MoveZeroes {
	public static void main(String args[]) {
		int[] arr = new int[] { 0, 1, 0, 3, 12 };
		System.out.println(Arrays.toString(moveZeroes(arr)));
	}

	public static int[] moveZeroes(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count++] = temp;
			}
		}
		return arr;
	}
}
//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//Note that you must do this in-place without making a copy of the array.
//Example 1:
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//Input: nums = [0]
//Output: [0]
