package me.y2o2u2n.p448;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-03-11
 */
public class FindAllNumbersDisappearedInAnArray {
	public static void main(String[] args) {
		printList(findDisappearedNumbers(new int[] {4, 3, 2, 7, 8, 2, 3, 1}));
	}

	private static List<Integer> findDisappearedNumbers(int[] nums) {
		boolean[] exist = new boolean[nums.length + 1];
		for (int num : nums) {
			exist[num] = true;
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < exist.length; i++) {
			if (!exist[i]) {
				list.add(i);
			}
		}

		return list;
	}

	private static void printList(List<Integer> list) {
		for (int i : list) {
			System.out.print(i);
		}
		System.out.println();
	}
}
