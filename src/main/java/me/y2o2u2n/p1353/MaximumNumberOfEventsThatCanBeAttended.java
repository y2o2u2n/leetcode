package me.y2o2u2n.p1353;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021/06/09
 */
public class MaximumNumberOfEventsThatCanBeAttended {
	public int maxEvents(int[][] events) {
		return s2(events);
	}

	private int s2(int[][] events) {
		Arrays.sort(events, Comparator.comparingInt(a -> a[0])); // sort by start day asc

		int i = 0;
		int ans = 0;
		int length = events.length;
		Queue<Integer> pq = new PriorityQueue<>();

		for (int day = 1; day <= 100000; day++) {
			while (!pq.isEmpty() && pq.peek() < day) {
				pq.poll();
			}

			while (i < length && events[i][0] == day) {
				pq.offer(events[i][1]);
				i++;
			}

			if (!pq.isEmpty()) {
				pq.poll();
				ans++;
			}
		}

		return ans;
	}

	// Time Limit Exceeded
	private int s1(int[][] events) {
		List<int[]> eventList = new ArrayList<>();
		Collections.addAll(eventList, events);

		Set<Integer> attend = new HashSet<>();

		eventList.sort((o1, o2) -> {
			if (o1[1] != o2[1]) {
				return o1[1] - o2[1];
			}

			return o1[0] - o2[0];
		});

		int ans = 0;

		for (int[] event : eventList) {
			int startDay = event[0];
			int endDay = event[1];

			for (int j = startDay; j <= endDay; j++) {
				if (!attend.contains(j)) {
					attend.add(j);
					ans++;
					break;
				}
			}
		}

		return ans;
	}
}
