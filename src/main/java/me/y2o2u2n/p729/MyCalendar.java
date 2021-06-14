package me.y2o2u2n.p729;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021/06/14
 */
public class MyCalendar {
	private final List<int[]> mergedSchedules;

	public MyCalendar() {
		this.mergedSchedules = new ArrayList<>();
	}

	public boolean book(int start, int end) {
		int[] schedule = new int[] {start, end};

		if (this.mergedSchedules.isEmpty()) {
			this.mergedSchedules.add(schedule);
			return true;
		}

		for (int[] mergedSchedule : mergedSchedules) {
			if (isIntersect(mergedSchedule, schedule)) {
				return false;
			}
		}

		this.mergedSchedules.add(schedule);

		return true;
	}

	private boolean isIntersect(int[] a, int[] b) {
		return a[0] < b[1] && a[1] > b[0];
	}
}
