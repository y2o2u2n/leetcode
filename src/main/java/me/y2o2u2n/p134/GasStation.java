package me.y2o2u2n.p134;

/**
 * Created by JunSeok Youn on 2021-05-26
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {

		for (int start = 0; start < gas.length; start++) {
			boolean possible = true;
			int tank = 0;

			for (int current = start; current < gas.length; current++) {
				tank += gas[current];
				if (tank < cost[current]) {
					possible = false;
					break;
				}

				tank -= cost[current];
			}

			if (!possible) {
				continue;
			}

			for (int current = 0; current < start; current++) {
				tank += gas[current];
				if (tank < cost[current]) {
					possible = false;
					break;
				}

				tank -= cost[current];
			}

			if (!possible) {
				continue;
			}

			return start;
		}

		return -1;
	}
}
