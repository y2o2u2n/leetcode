package me.y2o2u2n.p881;

import java.util.Arrays;

/**
 * Created by JunSeok Youn on 2021-05-28
 */
public class BoatsToSavePeople {
	// 16 21 24 30 40, 50, 3
	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int i = 0;
		int j = people.length - 1;
		int count = 0;

		while (i <= j) {
			count++;

			if (people[i] + people[j] <= limit) {
				i++;
			}

			j--;
		}

		return count;
	}
}
