package me.y2o2u2n.p973;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by JunSeok Youn on 2021-04-30
 */
public class KClosestPointsToOrigin {
	public static void main(String[] args) {
		print2ndArr(kClosest(new int[][] {{1, 3}, {-2, 2}}, 1));
		print2ndArr(kClosest(new int[][] {{3, 3}, {5, -1}, {-2, 4}}, 2));
	}

	private static int[][] kClosest(int[][] points, int k) {
		Arrays.sort(points, Comparator.comparingDouble(o -> Math.sqrt(o[0] * o[0] + o[1] * o[1])));

		int[][] ret = new int[k][2];

		for (int i = 0; i < k; i++) {
			ret[i] = points[i];
		}

		return ret;
	}

	private static void print2ndArr(int[][] intervals) {
		for (int[] interval : intervals) {
			for (int val : interval) {
				System.out.print(val + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
