package me.y2o2u2n.p566;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JunSeok Youn on 2021/06/30
 */
public class ReshapeTheMatrix {
	public int[][] matrixReshape(int[][] mat, int r, int c) {
		if (mat.length * mat[0].length != r * c) {
			return mat;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int rr = 0; rr < mat.length; rr++) {
			for (int cc = 0; cc < mat[0].length; cc++) {
				queue.offer(mat[rr][cc]);
			}
		}

		int[][] reshaped = new int[r][c];
		int rr = 0;
		int cc = 0;
		while (!queue.isEmpty()) {
			if (cc == c) {
				cc = 0;
				rr++;
			}

			reshaped[rr][cc] = queue.poll();
			cc++;
		}

		return reshaped;
	}
}
