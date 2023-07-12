package leetcode;

public class _2_BestTimeToBuyStock {
	public static void main(String args[]) {
		int[] arr = new int[] { 7, 1, 5, 3, 6, 4 };
		System.out.println(bestTimeToBuyStock(arr));
	}

	public static int bestTimeToBuyStock(int[] arr) {
		int maxProfit = 0;
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
			if (maxProfit < arr[i] - min)
				maxProfit = arr[i] - min;
		}
		return maxProfit;
	}
}
