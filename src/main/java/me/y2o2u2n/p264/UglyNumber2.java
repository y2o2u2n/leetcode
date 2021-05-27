package me.y2o2u2n.p264;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-05-27
 */
public class UglyNumber2 {

	// 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15
	public int nthUglyNumber(int n) {
		return s3(n);
	}

	private int s3(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(1);

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		while (list.size() < n) {
			int next = Math.min(list.get(i2) * 2, Math.min(list.get(i3) * 3, list.get(i5) * 5));

			list.add(next);

			if (list.get(i2) * 2 == next)
				i2++;
			if (list.get(i3) * 3 == next)
				i3++;
			if (list.get(i5) * 5 == next)
				i5++;
		}

		return list.get(list.size() - 1);
	}

	// Time Limit Exceeded
	private int s2(int n) {
		if (n == 1) {
			return 1;
		}

		Set<Integer> set = new HashSet<>();
		set.add(1);

		int i = 2;
		int count = 1;

		while (count < n) {

			if ((i % 2 == 0 && set.contains(i / 2))
				|| (i % 3 == 0 && set.contains(i / 3))
				|| (i % 5 == 0 && set.contains(i / 5))) {
				set.add(i);
				count++;
			}

			i++;

			if (count == n) {
				return i - 1;
			}
		}

		return -1;
	}

	private int s1(int n) {
		if (n == 1) {
			return 1;
		}

		List<Boolean> list = new ArrayList<>();
		list.add(false);
		list.add(true);

		int i = 2;
		int count = 1;
		while (count < n) {

			if ((i % 2 == 0 && list.get(i / 2))
				|| (i % 3 == 0 && list.get(i / 3))
				|| (i % 5 == 0 && list.get(i / 5))) {
				list.add(true);
				count++;
			} else {
				list.add(false);
			}

			i++;
		}

		return list.size() - 1;
	}
}
