package me.y2o2u2n.p46;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-03-10
 */
public class Permutations {

	public static void main(String[] args) {
		printListList(permute(new int[] {1, 2, 3}));
		printListList(permute(new int[] {0, 1}));
		printListList(permute(new int[] {1}));
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		int[] output = new int[nums.length];
		perm(nums, visited, output, 0, nums.length, nums.length, ret);
		return ret;
	}

	private static void perm(int[] arr, boolean[] visited, int[] output, int depth, int n, int r, List<List<Integer>> ret) {
		if (depth == r) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < depth; i++) {
				list.add(output[i]);
			}
			ret.add(list);

			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, visited, output, depth + 1, n, r, ret);
				visited[i] = false;
			}
		}
	}

	private static void printListList(List<List<Integer>> threeSum) {
		for (List<Integer> list : threeSum) {
			for (int i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
