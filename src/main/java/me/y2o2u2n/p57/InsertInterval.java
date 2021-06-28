package me.y2o2u2n.p57;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by JunSeok Youn on 2021-06-29
 */
public class InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int[][] newIntervals = new int[intervals.length + 1][2];
		for (int i = 0; i < intervals.length; i++) {
			newIntervals[i] = intervals[i];
		}
		newIntervals[intervals.length] = newInterval;

		return merge(newIntervals);
	}

	private int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
		LinkedList<int[]> merged = new LinkedList<>();

		for (int i = 0; i < intervals.length; i++) {
			int[] interval = intervals[i];
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}

		return merged.toArray(new int[merged.size()][]);
	}
}
