//Steven Wang

import java.util.Arrays;

public class Lab4 {

	static int[] arr0 = {0, 1, 2, 3, 4, 5, 6};
	static int[] arr1 = {5, 16, 29, 40, 69, 70, 82, 93};
	static int[] arr2 = {10, 20, 30, 40, 50, 70};
	static int[] arr3 = {67, 80, 46, 39, 12, 68};
	static int[] arr4 = {45, 46, 43, 2};

	public static void main(String[] args) {
		Tests(arr0, 2, 0);
		Tests(arr1, 93, 0);
		Tests(arr2, 25, 0);
		Tests(arr3, 67, 0);
		Tests(arr4, 23, 0);
		//Binary
		Tests(arr0, 2, 1);
		Tests(arr1, 93, 1);
		Tests(arr2, 25, 1);
		Tests(arr3, 67, 1);
		Tests(arr4, 23, 1);
		//Linear

		System.out.println("\nBinary Search: ");
		System.out.println("Input size: " + arr0.length + ", Execution time: " + time(arr0, 2, 0));
		System.out.println("Input size: " + arr1.length + ", Execution time: " + time(arr1, 93, 0));
		System.out.println("Input size: " + arr2.length + ", Execution time: " + time(arr2, 25, 0));
		System.out.println("Input size: " + arr3.length + ", Execution time: " + time(arr3, 67, 0));
		System.out.println("Input size: " + arr4.length + ", Execution time: " + time(arr4, 23, 0));
		System.out.println("Linear Search:");
		System.out.println("Input size: " + arr0.length + ", Execution time: " + time(arr0, 2, 1));
		System.out.println("Input size: " + arr1.length + ", Execution time: " + time(arr1, 93, 1));
		System.out.println("Input size: " + arr2.length + ", Execution time: " + time(arr2, 25, 1));
		System.out.println("Input size: " + arr3.length + ", Execution time: " + time(arr3, 67, 1));
		System.out.println("Input size: " + arr4.length + ", Execution time: " + time(arr4, 23, 1));
	}

	public static int BinarySearch(int arr[], int target, int start, int end ){
		int mdIndex = (start+end) / 2;
		int search = arr[mdIndex];
		int count = 0;
		int limit = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
		while (search != target) {
			if (count >= limit) {
				mdIndex = -1;
				break;
			}
			if (search < target) {
				start = mdIndex + 1;
			} else {
				end = mdIndex - 1;
			}
			mdIndex = (start+end) / 2;
			search = arr[mdIndex];
			count ++;
		}
		return mdIndex;
	}

	public static int linearSearch(int arr[], int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	} 

	public static void Tests(int[] arr, int target, int type) {
		if (type == 0) {
			System.out.println("Binary Search on " + Arrays.toString(arr) + ": Element " + target + " found at index " + BinarySearch(arr, target, 0, arr.length - 1));
		} else if (type == 1) {
			System.out.println("Linear Search on " + Arrays.toString(arr) + ": Element " + target + " found at index " + linearSearch(arr, target));
		}
	}

	public static long time(int[] arr, int target, int type) {
		long timeStart = System.nanoTime();
		if (type == 0) {
			BinarySearch(arr, target, 0, arr.length - 1);
		} else if (type == 1) {
			linearSearch(arr, target);
		}
		long timeElapsed = System.nanoTime() - timeStart;
		return timeElapsed;
	} 

}
