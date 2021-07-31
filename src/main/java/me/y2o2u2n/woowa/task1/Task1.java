package me.y2o2u2n.woowa.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021/07/31
 */
public class Task1 {
	public String solution(int U, int L, int[] C) {
		int yLength = 2;
		int xLength = C.length;
		int[][] M = new int[yLength][xLength];
		boolean[] visited = new boolean[xLength];

		for (int x = 0; x < C.length; x++) {
			if (C[x] == 2) {
				M[0][x] = 1;
				U--;
				M[1][x] = 1;
				L--;
				C[x] -= 2;
			}

			if (C[x] != 1) {
				visited[x] = true;
			}
		}

		int cSum = 0;
		for (int c : C) {
			cSum += c;
		}

		if (U + L != cSum) {
			return "IMPOSSIBLE";
		}

		for (int x = 0; x < xLength; x++) {
			if (visited[x]) {
				continue;
			}

			if (U > 0) {
				M[0][x] = 1;
				U--;
				C[x] -= 1;
			} else if (L > 0) {
				M[1][x] = 1;
				L--;
				C[x] -= 1;
			}

			visited[x] = true;
		}

		List<String> rows = new ArrayList<>();

		for (int y = 0; y < yLength; y++) {
			StringBuilder sb = new StringBuilder();
			for (int x = 0; x < xLength; x++) {
				sb.append(M[y][x]);
			}
			rows.add(sb.toString());
		}

		return String.join(",", rows);
	}
}
