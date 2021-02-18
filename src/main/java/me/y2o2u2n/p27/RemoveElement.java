package me.y2o2u2n.p27;

public class RemoveElement {

	public static void main(String[] args) {
		int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};

		System.out.println(removeElement(nums2, 2));
	}

	private static int removeElement(int[] nums, int val) {
		int n = nums.length;
		int j = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}

		// System.out.println("//");
		// for (int i = 0; i < n; i++) {
		// 	System.out.println(nums[i]);
		// }
		// System.out.println("//");

		return j;
	}
}
