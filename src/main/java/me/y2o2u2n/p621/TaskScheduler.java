package me.y2o2u2n.p621;

/**
 * Created by JunSeok Youn on 2021-04-17
 */
public class TaskScheduler {

	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C'}, 2));
		System.out.println(leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2));
		System.out.println(leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 0));
		System.out.println(leastInterval(new char[] {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));

	}

	private static int leastInterval(char[] tasks, int n) {
		int[] count = new int[26];
		int max = 0;
		int maxCount = 0;

		for (char c : tasks) {
			count[c - 'A']++;
			if (count[c - 'A'] == max) {
				maxCount++;
			} else if (count[c - 'A'] > max) {
				max = count[c - 'A'];
				maxCount = 1;
			}
		}

		int emptySlots = (max - 1) * (n - (maxCount - 1));
		int idle = Math.max(0, emptySlots - (tasks.length - maxCount * max));

		return tasks.length + idle;
	}

}
