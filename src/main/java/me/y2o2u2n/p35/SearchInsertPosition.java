package me.y2o2u2n.p35;

/**
 * Created by JunSeok Youn on 2021-02-23
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7));
		System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 0));
		System.out.println(searchInsert(new int[] {1}, 0));
	}

	private static int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (target <= nums[i]) {
				return i;
			}
		}

		int lastIndex = nums.length - 1;
		if (target > nums[lastIndex]) {
			return lastIndex + 1;
		}

		return 0;
	}
}
