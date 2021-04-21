package me.y2o2u2n.p554;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-04-21
 */
public class BrickWall {
	public static void main(String[] args) {
		System.out.println(leastBricks(
			List.of(
				List.of(1, 2, 2, 1),
				List.of(3, 1, 2),
				List.of(1, 3, 2),
				List.of(2, 4),
				List.of(3, 1, 2),
				List.of(1, 3, 1, 1)
			)
		));

		System.out.println(leastBricks(
			List.of(
				List.of(100000000),
				List.of(100000000),
				List.of(100000000)
			)
		));
	}

	private static int leastBricks(List<List<Integer>> wall) {
		return s2(wall);
	}

	private static int s2(List<List<Integer>> wall) {
		Map<Integer, Integer> map = new HashMap<>();
		for (List<Integer> row : wall) {
			int sum = 0;
			for (int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				Integer count = map.get(sum);
				map.put(sum, count == null ? 1 : count + 1);
			}
		}

		int max = 0;
		for (int count : map.values()) {
			max = Math.max(max, count);
		}

		return wall.size() - max;
	}

	// Memory Limit Exceeded
	private static int s1(List<List<Integer>> wall) {
		int yLength = wall.size();
		List<Integer> firstRow = wall.get(0);
		int xLength = 0;
		for(int i : firstRow) {
			xLength += i;
		}

		if (xLength == 1) {
			return yLength;
		}

		boolean[][] matrix = new boolean[yLength][xLength + 1];

		for (int y = 0; y < wall.size(); y++) {
			List<Integer> row = wall.get(y);
			int x = 0;
			for (int j = 0; j < row.size(); j++) {
				Integer width = row.get(j);
				x += width;
				matrix[y][x] = x != xLength;
			}
		}

		int max = Integer.MIN_VALUE;
		for (int x = 1; x < xLength; x++) {
			int count = 0;
			for (int y = 0; y < yLength; y++) {
				if (matrix[y][x]) {
					count++;
				}
			}

			max = Math.max(max, count);
		}

		return yLength - max;
	}
}
