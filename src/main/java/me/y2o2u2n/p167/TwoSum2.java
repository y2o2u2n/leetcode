package me.y2o2u2n.p167;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-04-09
 */
public class TwoSum2 {
	public static void main(String[] args) {

		printArr(twoSum(new int[] {2, 7, 11, 15}, 9));
	}

	private static int[] twoSum(int[] numbers, int target) {
		return s3(numbers, target);
	}

	private static int[] s1(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] {i + 1, j + 1};
				}
			}
		}

		return null;
	}

	private static int[] s2(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i + 1);
		}

		for (int i = 0; i < numbers.length; i++) {
			int residue = target - numbers[i];
			if (map.containsKey(residue)) {
				return new int[] {i + 1, map.get(residue)};
			}
		}

		return new int[0];
	}

	private static int[] s3(int[] numbers, int target) {
		int start = 0;
		int end = numbers.length - 1;

		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				return new int[] {start + 1, end + 1};
			} else if (sum > target) {
				end--;
			} else {
				start++;
			}
		}

		return new int[0];
	}

	private static void printArr(int[] arr) {
		if (arr == null) {
			return;
		}

		for (int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}

}
