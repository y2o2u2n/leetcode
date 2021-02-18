package me.y2o2u2n.p26;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		int[] nums1 = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
		System.out.println(removeDuplicates(nums1));
	}

	private static int removeDuplicates(int[] nums) {
		int n = nums.length;

		if (n == 0 || n == 1) {
			return n;
		}

		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[j++] = nums[i];
			}
		}

		nums[j++] = nums[n - 1];

		return j;
	}
}
