package _1;

public class TwoSum {
	public static void main(String args[]) {
		int[] arr = { 2, 8, 11, 15 ,9};
		int[] twoSum = twoSum(arr, 24);
		for (int element: twoSum) {
            System.out.println(element);
        }
	}
	public static int[] twoSum(int[] nums, int target) {
		int sum = 0;
		int[] arr = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i+1; j < nums.length ; j++) {
				sum = nums[i] + nums[j];
				if (sum == target) {
					arr[0] = i;
					arr[1] = j;
				}
			}
		}
		return arr;
	}
}