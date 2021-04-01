package me.y2o2u2n.p207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-01
 */
public class CourseSchedule {

	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] {{1, 0}})); // t
		System.out.println(canFinish(2, new int[][] {{1, 0}, {0, 1}})); // f
		System.out.println(canFinish(4, new int[][] {{0, 1}, {0, 2}, {2, 1}})); // t
		System.out.println(canFinish(4, new int[][] {{0, 1}, {1, 2}, {2, 0}})); // f
	}

	private static boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> map = new HashMap<>();

		for (int i = 0; i < numCourses; i++) {
			map.put(i, new HashSet<>());
		}

		for (int[] prerequisite : prerequisites) {
			int start = prerequisite[0];
			int next = prerequisite[1];
			map.get(start).add(next);
		}

		boolean[] visited = new boolean[numCourses];
		boolean[] checked = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			if (hasCycle(i, visited, checked, map)) {
				return false;
			}
		}

		return true;
	}

	private static boolean hasCycle(
		int current,
		boolean[] visited,
		boolean[] checked,
		Map<Integer, Set<Integer>> map
	) {
		if (checked[current]) {
			return false;
		}

		if (visited[current]) {
			return true;
		}

		Set<Integer> nextSet = map.get(current);
		if (map.get(current) == null) {
			return false;
		}

		visited[current] = true;
		boolean ret = false;

		for (int next : nextSet) {
			ret = hasCycle(next, visited, checked, map);
			if (ret) {
				break;
			}
		}

		visited[current] = false;
		checked[current] = true;
		return ret;
	}
}
