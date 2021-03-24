package me.y2o2u2n.p75;

/**
 * Created by JunSeok Youn on 2021-03-24
 */
public class SortColors {
	public static void main(String[] args) {
		sortColors(new int[] {2, 0, 2, 1, 1, 0});
		sortColors(new int[] {2, 0, 1});
		sortColors(new int[] {0});
		sortColors(new int[] {1});
	}

	private static void sortColors(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int minIndex = -1;
			int minVal = Integer.MAX_VALUE;

			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < minVal) {
					minIndex = j;
					minVal = nums[j];
				}
			}

			if (minIndex == -1) {
				continue;
			}

			if (nums[i] > nums[minIndex]) {
				int temp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = temp;
			}
		}

		printArr(nums);
	}

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
