package me.y2o2u2n.p455;

import java.util.PriorityQueue;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		PriorityQueue<Integer> greedPq = new PriorityQueue<>();
		for(int num : g) {
			greedPq.add(num);
		}

		PriorityQueue<Integer> sizePq = new PriorityQueue<>();
		for(int num : s) {
			sizePq.add(num);
		}

		int contentChildren = 0;
		while(!greedPq.isEmpty()) {
			Integer greed = greedPq.poll();

			while (!sizePq.isEmpty() && greed > sizePq.peek()) {
				sizePq.poll();
			}

			if (sizePq.isEmpty()) {
				break;
			} else {
				sizePq.poll();
				contentChildren++;
			}
		}

		return contentChildren;
	}
}
