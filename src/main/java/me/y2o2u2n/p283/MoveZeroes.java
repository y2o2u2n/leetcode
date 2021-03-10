package me.y2o2u2n.p283;

/**
 * Created by JunSeok Youn on 2021-03-10
 */
public class MoveZeroes {
	public static void main(String[] args) {
		int[] n1 = {0, 1, 0, 3, 12};
		moveZeroes(n1);
		printArr(n1);

		int[] n2 = {0, 0, 1};
		moveZeroes(n2);
		printArr(n2);
	}

	private static void moveZeroes(int[] nums) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (nums[i] == 0) {
				for (int j = i + 1; j < length; j++) {
					if (nums[j] != 0) {
						int temp = nums[i];
						nums[i] = nums[j];
						nums[j] = temp;
						break;
					}
				}
			}

		}
	}

	private static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + ",");
		}
		System.out.println();
	}
}
