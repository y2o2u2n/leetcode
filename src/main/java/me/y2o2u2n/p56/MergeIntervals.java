package me.y2o2u2n.p56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by JunSeok Youn on 2021-03-13
 */
public class MergeIntervals {
	public static void main(String[] args) {
		print2ndArr(merge(new int[][] {
			{1, 4},
			{0, 0}
		}));

		print2ndArr(merge(new int[][] {
			{1, 3},
			{2, 6},
			{8, 10},
			{15, 18},
		}));

		print2ndArr(merge(new int[][] {
			{1, 4},
			{4, 5},
		}));

		print2ndArr(merge(new int[][] {
			{1, 4},
			{5, 6},
		}));

		print2ndArr(merge(new int[][] {
			{1, 4},
			{0, 2},
			{3, 5}
		}));
	}

	private static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval : intervals) {
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}

		return merged.toArray(new int[merged.size()][]);
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
