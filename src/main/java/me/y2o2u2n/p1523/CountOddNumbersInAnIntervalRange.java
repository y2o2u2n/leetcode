package me.y2o2u2n.p1523;

/**
 * Created by JunSeok Youn on 2021-05-19
 */
public class CountOddNumbersInAnIntervalRange {

	public int countOdds(int low, int high) {
		if (low == high) {
			return low % 2 == 1 ? 1 : 0;
		} else if (high - low == 1) {
			return 1;
		}

		if (low % 2 == 1 && high % 2 == 1) {
			return ((high - 1) - (low + 1)) / 2 + 2;
		} else if (low % 2 == 1 && high % 2 == 0) {
			return (high - (low + 1)) / 2 + 1;
		} else if (low % 2 == 0 && high % 2 == 1) {
			return ((high - 1) - low) / 2 + 1;
		}

		return (high - low) / 2;
	}
}
