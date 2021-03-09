package me.y2o2u2n.p39;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-03-09
 */
public class CombinationSum {
	public static void main(String[] args) {
		printListList(combinationSum(new int[] {2, 3, 6, 7}, 7));
		printListList(combinationSum(new int[] {2, 3, 5}, 8));
		printListList(combinationSum(new int[] {2}, 1));
		printListList(combinationSum(new int[] {1}, 1));
		printListList(combinationSum(new int[] {1}, 2));
	}

	private static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		int[] visited = new int[candidates.length];
		combination(candidates, visited, target, -1, 0, ret);
		return ret;
	}

	private static void combination(int[] arr, int[] visited, int target, int num, int sum, List<List<Integer>> ret) {
		if (sum == target) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < visited.length; i++) {
				for (int j = 0; j < visited[i]; j++) {
					list.add(arr[i]);
				}
			}
			ret.add(list);
		} else if (sum > target) {
			// do nothing
		} else {
			for (int i = 0; i < arr.length; i++) {
				if (num <= arr[i]) {
					visited[i]++;
					combination(arr, visited, target, arr[i], sum + arr[i], ret);
					visited[i]--;
				}

			}
		}
	}

	private static void printListList(List<List<Integer>> listList) {
		for (List<Integer> list : listList) {
			for (int i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println("---");
	}
}
