package me.y2o2u2n.p33;

/**
 * Created by JunSeok Youn on 2021-03-05
 */
public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
		System.out.println(search(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
		System.out.println(search(new int[] {1}, 0));
		System.out.println(search(new int[] {1}, 1));
	}

	private static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target <= nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] <= target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}
}
