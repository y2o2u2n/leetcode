package me.y2o2u2n.p238;

/**
 * Created by JunSeok Youn on 2021-04-07
 */
public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		printIntArr(productExceptSelf(new int[] {1, 2, 3, 4})); // 24,12,8,6
		printIntArr(productExceptSelf(new int[] {-1, 1, 0, -3, 3})); // 0,0,9,0,0
		printIntArr(productExceptSelf(new int[] {0, 0})); // 0,0
		printIntArr(productExceptSelf(new int[] {0, 0, 0, 0, 0})); // 0,0,0,0,0
		printIntArr(productExceptSelf(new int[] {0, 0, 0, 0, 1})); // 0,0,0,0,0
	}

	private static int[] productExceptSelf(int[] nums) {
		return s3(nums);
	}

	// O(n^2) : time limit exceeded
	private static int[] s1(int[] nums) {
		int n = nums.length;
		int[] ret = new int[n];

		for (int i = 0; i < n; i++) {
			ret[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					ret[i] = ret[i] * nums[j];
				}
			}
		}

		return ret;
	}

	// O(n) with division
	private static int[] s2(int[] nums) {
		int n = nums.length;
		int countZero = 0;

		int allProductExceptZero = 1;

		for (int num : nums) {
			if (num != 0) {
				allProductExceptZero *= num;
			} else {
				countZero++;
			}
		}

		if (countZero > 1) {
			return new int[nums.length];
		}

		int[] ret = new int[n];
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				ret[i] = allProductExceptZero / nums[i];
			} else {
				ret[i] = allProductExceptZero;
			}
		}

		for (int i = 0; i < n; i++) {
			if (countZero > 0 && nums[i] != 0) {
				ret[i] = 0;
			}
		}

		return ret;
	}

	// O(n) without division
	private static int[] s3(int[] nums) {
		int n = nums.length;

		int[] left = new int[n];
		left[0] = 1;

		for (int i = 1; i < n; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		int[] right = new int[n];
		right[n - 1] = 1;

		for (int i = n - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < n; i++) {
			nums[i] = left[i] * right[i];
		}

		return nums;
	}

	private static void printIntArr(int[] arr) {
		for (int value : arr) {
			System.out.print(value + ", ");
		}
		System.out.println();
	}
}
