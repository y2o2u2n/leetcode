package me.y2o2u2n.p66;

import java.util.LinkedList;

/**
 * Created by JunSeok Youn on 2021-02-24
 */
public class PlusOne {
	public static void main(String[] args) {
		printIntArr(plusOne(new int[] {1, 2, 3}));
		printIntArr(plusOne(new int[] {4, 3, 2, 1}));
		printIntArr(plusOne(new int[] {0}));
		printIntArr(plusOne(new int[] {9}));
		printIntArr(plusOne(new int[] {9, 9}));
		printIntArr(plusOne(new int[] {9,8,7,6,5,4,3,2,1,0}));
	}

	private static int[] plusOne(int[] digits) {
		LinkedList<Integer> list = new LinkedList<>();
		boolean plus = false;

		int n = digits.length;
		digits[n - 1]++;

		for (int i = n - 1; i >= 0; i--) {
			int digit = digits[i];
			if (plus) {
				digit++;
			}

			if (digit == 10) {
				list.push(0);
				plus = true;
			} else {
				list.push(digit);
				plus = false;
			}
		}

		if (plus) {
			list.push(1);
		}


		return list.stream().mapToInt(i -> i).toArray();
	}

	private static void printIntArr(int[] arr) {
		for (int value : arr) {
			System.out.print(value);
		}
		System.out.println();
	}
}
