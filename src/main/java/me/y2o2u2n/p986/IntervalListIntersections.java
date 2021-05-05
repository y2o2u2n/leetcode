package me.y2o2u2n.p986;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-05-05
 */
public class IntervalListIntersections {
	public static void main(String[] args) {
		print2ndArr(
			intervalIntersection(
				new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
				new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}}
			)
		);

		print2ndArr(
			intervalIntersection(
				new int[][] {{1, 3}, {5, 9}},
				new int[][] {}
			)
		);

		print2ndArr(
			intervalIntersection(
				new int[][] {{5, 10}},
				new int[][] {{3, 10}}
			)
		);

		print2ndArr(
			intervalIntersection(
				new int[][] {{3, 5}, {9, 20}},
				new int[][] {{4, 5}, {7, 10}, {11, 12}, {14, 15}, {16, 20}}
			)
		);
	}

	private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		return s2(firstList, secondList);
	}

	private static int[][] s2(int[][] firstList, int[][] secondList) {
		int fLength = firstList.length;
		int sLength = secondList.length;

		int f = 0;
		int s = 0;

		List<int[]> answer = new ArrayList<>();

		while (f < fLength && s < sLength) {
			int low = Math.max(firstList[f][0], secondList[s][0]);
			int high = Math.min(firstList[f][1], secondList[s][1]);

			if (low <= high) {
				answer.add(new int[] {low, high});
			}

			if (firstList[f][1] < secondList[s][1]) {
				f++;
			} else {
				s++;
			}
		}

		return answer.toArray(new int[answer.size()][]);
	}

	private static int[][] s1(int[][] firstList, int[][] secondList) {
		int fLength = firstList.length;
		int sLength = secondList.length;

		int f = 0;
		int s = 0;

		List<int[]> answer = new ArrayList<>();

		while (f < fLength && s < sLength) {
			int[] fInterval = firstList[f];
			int[] sInterval = secondList[s];

			if (hasInterval(fInterval, sInterval)) {
				int[] interval = getInterval(fInterval, sInterval);
				answer.add(interval);
			}

			if (shouldFirstRemove(fInterval, sInterval)) {
				f++;
			} else {
				s++;
			}
		}

		int[][] ret = new int[answer.size()][2];
		for (int i = 0; i < answer.size(); i++) {
			ret[i] = answer.get(i);
		}

		return ret;
	}

	private static boolean shouldFirstRemove(int[] fInterval, int[] sInterval) {
		int fEnd = fInterval[1];
		int sEnd = sInterval[1];

		return fEnd < sEnd;
	}

	private static boolean hasInterval(int[] fInterval, int[] sInterval) {
		int fStart = fInterval[0];
		int fEnd = fInterval[1];
		int sStart = sInterval[0];
		int sEnd = sInterval[1];

		return (sStart <= fStart && fStart <= sEnd)
			|| (sStart <= fEnd && fEnd <= sEnd)
			|| (fStart <= sStart && sStart <= fEnd)
			|| (fStart <= sEnd && sEnd <= fEnd);
	}

	private static int[] getInterval(int[] fInterval, int[] sInterval) {
		int fStart = fInterval[0];
		int fEnd = fInterval[1];
		int sStart = sInterval[0];
		int sEnd = sInterval[1];

		return new int[] {Math.max(fStart, sStart), Math.min(fEnd, sEnd)};
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
