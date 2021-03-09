package me.y2o2u2n.p34;

/**
 * Created by JunSeok Youn on 2021-03-09
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		printArr(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 8));
		printArr(searchRange(new int[] {5, 7, 7, 8, 8, 10}, 6));
		printArr(searchRange(new int[] {}, 0));
	}

	private static int[] searchRange(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int found = -1;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] == target) {
				found = mid;
				break;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		if (found == -1) {
			return new int[] {-1, -1};
		}

		int leftMinIndex = Integer.MAX_VALUE;
		int rightMaxIndex = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			if (nums[i] == target) {
				leftMinIndex = Math.min(leftMinIndex, i);
				rightMaxIndex = Math.max(rightMaxIndex, i);
			}

		}

		return new int[] {leftMinIndex, rightMaxIndex};
	}

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}
}
