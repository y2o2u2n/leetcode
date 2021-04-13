package me.y2o2u2n.p406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-04-13
 */
public class QueueReconstructionByHeight {
	public static void main(String[] args) {
		int[][] p1 = new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
		print2ndArr(reconstructQueue(p1));

		int[][] p2 = new int[][] {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
		print2ndArr(reconstructQueue(p2));
	}

	private static int[][] reconstructQueue(int[][] people) {
		return s2(people);
	}

	private static int[][] s2(int[][] people) {
		Arrays.sort(people, (a1, a2) -> {
			if (a1[0] != a2[0]) {
				return a2[0] - a1[0];
			} else {
				return a1[1] - a2[1];
			}
		});

		ArrayList<int[]> list = new ArrayList<>();

		for (int i = 0; i < people.length; i++) {
			int[] arr = people[i];
			list.add(arr[1], arr);
		}

		int[][] result = new int[people.length][];

		for (int i = 0; i < people.length; i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	// Time Limit Exceeded
	private static int[][] s1(int[][] people) {
		int n = people.length;
		boolean[] visited = new boolean[n];
		List<Integer> list = new ArrayList<>();
		check(people, visited, n, 0, list);

		int[][] ret = new int[n][2];
		for (int i = 0; i < n; i++) {
			ret[i][0] = people[list.get(i)][0];
			ret[i][1] = people[list.get(i)][1];
		}

		return ret;
	}

	private static boolean check(int[][] people, boolean[] visited, int n, int r, List<Integer> list) {
		if (r == n) {
			if (!isRightOrder(people, list)) {
				return false;
			}

			for (int i : list) {
				System.out.print(people[i][0] + "," + people[i][1] + " /");
			}
			System.out.println();

			return true;
		} else {
			if (!isRightOrder(people, list))
				return false;

			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					continue;
				}

				visited[i] = true;
				list.add(r, i);
				if (check(people, visited, n, r + 1, list)) {
					return true;
				}
				visited[i] = false;
				list.remove(r);
			}

			return false;
		}
	}

	private static boolean isRightOrder(int[][] people, List<Integer> list) {
		if (list.isEmpty()) {
			return true;
		}

		int count = 0;
		int lastIndex = list.size() - 1;

		for (int i = 0; i <= lastIndex - 1; i++) {
			if (people[list.get(i)][0] >= people[list.get(lastIndex)][0]) {
				count++;
			}
		}

		return count == people[list.get(lastIndex)][1];
	}

	private static void print2ndArr(int[][] arr) {
		for (int[] element : arr) {
			System.out.print(element[0] + "," + element[1] + " ");
		}

		System.out.println();
	}
}
