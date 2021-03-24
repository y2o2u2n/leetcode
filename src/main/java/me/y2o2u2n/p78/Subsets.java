package me.y2o2u2n.p78;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-03-24
 */
public class Subsets {
	public static void main(String[] args) {
		printListList(subsets(new int[] {1, 2, 3,}));
		printListList(subsets(new int[] {0,}));
	}

	private static List<List<Integer>> subsets(int[] nums) {
		int n = nums.length;
		boolean[] visited = new boolean[n];
		List<List<Integer>> ret = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			combination(n, i, 0, nums, visited, ret);
		}

		return ret;
	}

	private static void combination(int n, int r, int start, int[] nums, boolean[] visited, List<List<Integer>> ret) {
		if (r == 0) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					list.add(nums[i]);
				}
			}
			ret.add(list);
		} else {
			for (int i = start; i < n; i++) {
				visited[i] = true;
				combination(n, r - 1, i + 1, nums, visited, ret);
				visited[i] = false;
			}
		}
	}

	private static void printListList(List<List<Integer>> threeSum) {
		for (List<Integer> list : threeSum) {
			for (int i : list) {
				System.out.print(i + ", ");
			}
			System.out.print(" | ");
		}
		System.out.println();
	}
}
