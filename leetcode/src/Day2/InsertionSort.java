package Day2;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] arr = { 6, 4, 2, 8, 3, 1, 9 };
		System.out.println("Before: " + Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("After: " + Arrays.toString(arr));
	}

	public static void insertionSort(int arr[]) {
		for (int i = 1; i < arr.length - 1; i++) {
			int j, temp = arr[i];
			for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}
}
