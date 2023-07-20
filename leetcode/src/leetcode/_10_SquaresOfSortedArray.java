package leetcode;

import java.util.Arrays;

public class _10_SquaresOfSortedArray {
	public static void main(String args[]) {
		int[] arr = new int[] { -7, -3, 2, 3, 11 };
		System.out.println(Arrays.toString(squaresOfSortedArray(arr)));
	}

	private static int[] squaresOfSortedArray(int[] arr) {
		int[] arr1 = new int[arr.length];
		int left = 0, right = arr.length - 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[left] * arr[left] > arr[right] * arr[right]) {
				arr1[i] = arr[left] * arr[left];
				left++;
			} else {
				arr1[i] = arr[right] * arr[right];
				right--;
			}
		}
		return arr1;
	}
}
//Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
//Example 1:
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
//Example 2:
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]