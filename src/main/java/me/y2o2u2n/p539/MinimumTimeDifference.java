package me.y2o2u2n.p539;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinimumTimeDifference {
	private static final int MINUTE_OF_DAY = 24 * 60;

	public int findMinDifference(List<String> timePoints) {
		List<Integer> minutes = new ArrayList<>();
		for (String timePoint : timePoints) {
			minutes.add(toMinute(timePoint));
		}

		minutes.sort(Comparator.comparingInt(o -> o));

		int min = minutes.get(0) + MINUTE_OF_DAY - minutes.get(minutes.size() - 1);

		for (int i = 1; i < minutes.size(); i++) {
			int diff = minutes.get(i) - minutes.get(i - 1);
			min = Math.min(min, diff);
		}

		return min;
	}

	private Integer toMinute(String timePoint) {
		String[] split = timePoint.split(":");
		int hour = Integer.valueOf(split[0]);
		int minute = Integer.valueOf(split[1]);

		return hour * 60 + minute;
	}
}
