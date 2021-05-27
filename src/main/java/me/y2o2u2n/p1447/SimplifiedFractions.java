package me.y2o2u2n.p1447;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-05-28
 */
public class SimplifiedFractions {
	public List<String> simplifiedFractions(int n) {
		if (n == 1) {
			return List.of();
		}

		Set<String> ans = new HashSet<>();

		for (int lower = 2; lower <= n; lower++) {
			for (int upper = 1; upper <= lower - 1; upper++) {
				System.out.println(upper + "/" + lower);
				int[] reduce = reduce(new int[] {upper, lower});
				ans.add(String.format("%d/%d", reduce[0], reduce[1]));
			}
		}

		return new ArrayList<>(ans);
	}

	public int[] reduce(int[] fractions) {
		int upper = fractions[0];
		int lower = fractions[1];
		int gcd = gcd(lower, upper);

		return new int[] {upper / gcd, lower / gcd};
	}

	private int gcd(int bigger, int smaller) {
		if (smaller == 0) {
			return bigger;
		}

		return gcd(smaller, bigger % smaller);
	}
}
