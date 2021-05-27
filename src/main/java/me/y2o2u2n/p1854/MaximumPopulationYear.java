package me.y2o2u2n.p1854;

/**
 * Created by JunSeok Youn on 2021-05-27
 */
public class MaximumPopulationYear {
	public int maximumPopulation(int[][] logs) {
		int min = 1950;
		int max = 2050;
		int[] population = new int[max + 1];

		for (int[] log : logs) {
			int birth = log[0];
			int death = log[1];

			for (int i = birth; i < death; i++) {
				population[i]++;
			}
		}

		int maxP = 0;

		for (int i = min; i <= max; i++) {
			maxP = Math.max(maxP, population[i]);
		}

		for (int i = min; i <= max; i++) {
			if (maxP == population[i]) {
				return i;
			}
		}

		return -1;
	}
}
